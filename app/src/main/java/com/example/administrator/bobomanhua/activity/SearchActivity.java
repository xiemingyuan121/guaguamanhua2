package com.example.administrator.bobomanhua.activity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.adapter.MyChildAdapter;
import com.example.administrator.bobomanhua.bean.SearchBean;
import com.example.administrator.bobomanhua.bean.SearchTwoBean;
import com.example.administrator.bobomanhua.decoration.SpacesItemDecoration;
import com.example.administrator.bobomanhua.helper.OkHttpClientHelper;
import com.example.administrator.bobomanhua.helper.SwipBackActivityHelper;
import com.example.administrator.bobomanhua.utils.UrlUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TooManyListenersException;

import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class SearchActivity extends SwipBackActivityHelper {
    // recycler
    private RecyclerView recyclerView_fragment;
    // 消息传递
    private Handler handler = new Handler();
    // 上下文
    private Context context = this;
    // 数据源 集合
    private List<SearchBean.DataBean> searchList = new ArrayList<>();
    // 数据源 集合
    private List<SearchTwoBean.DataBean> searchTwoList = new ArrayList<>();
    // 数据源 集合
    private List<SearchBean.DataBean> newSearchList = new ArrayList<>();
    // 数据源 集合
    private List<SearchTwoBean.DataBean> newSearchTwoList = new ArrayList<>();
    // 适配器
    private MyChildAdapter adapter ;
    // 线性布局管理者
    private LinearLayoutManager linearLayoutManager;
    // 网址
    private String Url ="";
    // 标题
    private String title = "";
    // toolbar
    private Toolbar toolbar_search;
    // 浮动按钮
    private FloatingActionButton fab_top;
    // 最后显示条目
    private int lastVisibleItemPosition;
    // 页数
    private int page = 1;
    // 下拉刷新 框架
    private PtrFrameLayout prtFrameLayout_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView(); // 调用初始化控件方法
        initData(); // 调用初始化数据方法
        loadData(); // 调用加载数据方法
    }
/*
*   该方法 用于加载数据
* */
    private void loadData() {
        // 设置固定高度
        recyclerView_fragment.setHasFixedSize(true);
        // 设置 默认动画
        recyclerView_fragment.setItemAnimator(new DefaultItemAnimator());
        // 设置间距
        recyclerView_fragment.addItemDecoration(new SpacesItemDecoration(5));
        // 初始化 管理者
        linearLayoutManager = new LinearLayoutManager(context);
        // 添加 管理者
        recyclerView_fragment.setLayoutManager(linearLayoutManager);
        // 判断 数据 的 来源
        if(getIntent().getIntExtra("tag",0)==1){
            // 创建相对应的适配器
            adapter = new MyChildAdapter(context,searchList,4,recyclerView_fragment);
        }else{
            // 创建相对应的适配器
            adapter = new MyChildAdapter(context,searchTwoList,6,recyclerView_fragment);
        }
        // 添加适配器
        recyclerView_fragment.setAdapter(adapter);
        // 浮动按钮监听事件
        fab_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 置顶
                recyclerView_fragment.scrollToPosition(0);
            }
        });
    }
    /*
    * 该方法 用于加载数据源
    * */
    private void initData() {
        // 获取 URL
        final String data = getIntent().getStringExtra("data");
        // 初始化 标题
        title = data ;
        // 判断 数据来源
        if(getIntent().getIntExtra("tag",0)==1){
            // 拼凑 相对应的Url
            Url = UrlUtils.getSearchUrl(data,page);
        }else {
            // 拼凑 相对应的Url
            Url = UrlUtils.getSearch2Url(data,page);
        }
        // 开启子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 初始化 gson
                    Gson gson = new Gson();
                    // 获取 json 数据
                    String jsonData = OkHttpClientHelper.getStringFromURL(context,Url, "video");
                    // 判断来源
                    if(getIntent().getIntExtra("tag",0)==1){
                        // 解析json
                        SearchBean bean = gson.fromJson(jsonData, new TypeToken<SearchBean>() {
                        }.getType());
                        // 添加数据
                        searchList.addAll(bean.getData());
                        newSearchList.addAll(bean.getData());
                    }else {
                        // 解析数据
                        SearchTwoBean bean = gson.fromJson(jsonData, new TypeToken<SearchTwoBean>() {
                        }.getType());
                        // 添加数据
                        searchTwoList.addAll(bean.getData());
                        newSearchTwoList.addAll(bean.getData());
                        // 添加标题
                        title = bean.getData().get(0).getComicType();
                    }
                    // 回到主线程
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            // 判断数据来源
                            if(getIntent().getIntExtra("tag",0)==1){
                                // 判断页数 刷新数据
                                if(page==1){

                                    adapter.reloadRecyclerView(newSearchList,true);
                                }else{
                                    adapter.reloadRecyclerView(newSearchList,false);
                                }
                            }else{
                                if(page==1){
                                    adapter.reloadRecyclerView(newSearchTwoList,true);
                                }else{
                                    adapter.reloadRecyclerView(newSearchTwoList,false);
                                }
                            }
                            // 刷新 完成
                            prtFrameLayout_fragment.refreshComplete();
                            //设置 标题
                            toolbar_search.setTitle(title);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
/*
* 该方法 用于初始化 控件
* */
    private void initView() {
        // 初始化 recyclerVIew
        recyclerView_fragment = (RecyclerView) findViewById(R.id.recyclerView_fragment);
        // 初始化 toolbar
        toolbar_search = (Toolbar) findViewById(R.id.toolbar_search);
        //toolbar 设置 图标
        toolbar_search.setNavigationIcon(R.mipmap.back);
        // 设置图标监听事件
        toolbar_search.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // 初始化 浮动按钮
        fab_top = (FloatingActionButton) findViewById(R.id.fab_top);
        // 初始化下拉框
        prtFrameLayout_fragment = (PtrFrameLayout)findViewById(R.id.ptrFrameLayout_fragment);

        // 创建 下拉刷新的 头饰图
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(context);
        // 下拉 控件 添加头饰图
        prtFrameLayout_fragment.setHeaderView(header);
        //  下拉控件 添加 下拉 样式
        prtFrameLayout_fragment.addPtrUIHandler(header);
        //  设置 下拉 监听器
        prtFrameLayout_fragment.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                // 判断 是哪个 控件 下拉:
                page = 1;
                initData();
            }
        });

        recyclerView_fragment.addOnScrollListener(new RecyclerView.OnScrollListener() {
            // 这是 上拉 加载 数据 监听器
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 如果滚动状态为停止 并且 最后一个view 是 最后一个 Item
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItemPosition == adapter.getItemCount() - 1) {
                    // 根据 下拉的 碎片类型不同 判断 加载的 数据 的 page 改变样式 ;
                    page++;
                    // 加载数据
                    initData();
                    Toast.makeText(context, "加载成功!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // 滚动监听器  判断 根据 视图 管理者来获取 最后一个视图的 位置 ;
                    lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            }
        });
    }
}
