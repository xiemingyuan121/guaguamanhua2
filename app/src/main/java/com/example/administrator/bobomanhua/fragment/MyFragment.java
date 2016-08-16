package com.example.administrator.bobomanhua.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.activity.LogInActivity;
import com.example.administrator.bobomanhua.activity.SearchActivity;
import com.example.administrator.bobomanhua.adapter.MyButtonAdapter;
import com.example.administrator.bobomanhua.adapter.MyViewPagerAdapter;
import com.example.administrator.bobomanhua.bean.TypeBean;
import com.example.administrator.bobomanhua.decoration.SpacesItemDecoration;
import com.example.administrator.bobomanhua.helper.MySQLiteOpenHelper;
import com.example.administrator.bobomanhua.helper.OkHttpClientHelper;
import com.example.administrator.bobomanhua.utils.InflaterViewUtils;
import com.example.administrator.bobomanhua.utils.UrlUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2016/8/6 0006.
 */
public class MyFragment extends Fragment {
    // 碎片 类型标记
    private int tag;
    // 上下文环境
    private Context context;
    // 布局填充器
    private LayoutInflater inflater;
    // 碎片管理者
    private FragmentManager manager;
    // tab layout
    private TabLayout tabLayout_fragment;
    // viewpager
    private ViewPager viewPager_fragment;
    // recyclerVIew
    private RecyclerView recyclerView;
    // webVIew
    private WebView webView_fragment;
    // 下拉刷新 框
    private PtrFrameLayout prtFrameLayout_fragment;
    // 标题 数组
    private String[] arrTabLayoutTitles;
    // 碎片集合
    private List<Fragment> totalList = new ArrayList<>();
    // viewPager 适配器
    private MyViewPagerAdapter pagerAdapter;
    // 图片按钮
    private ImageButton imageButton_fragment;
    // 线性布局管理者
    private LinearLayoutManager linearLayoutManager;
    // 网格布局 管理者
    private GridLayoutManager gridLayoutManager;
    // 碎片适配器
    private MyButtonAdapter adapter;
    // 文本输入框
    private EditText editText_fragment;
    // 图片按钮
    private ImageButton imageView_fragment_search;
    // WebVIew 的 Url
    private String WebViewUrl;
    // 消息传递者
    private Handler handler = new Handler();
    // 分类 集合
    private List<TypeBean.DataBean> typeList = new ArrayList<>();
    // 数据库 操作者
    private MySQLiteOpenHelper openHelper;
    // 数据操作 工具
    private SQLiteDatabase dbConn;
    // 数据库数据 集合
    private List<Map<String, String>> collectList = new ArrayList<>();
/*
* 该方法用于 创建碎片并且传递 碎片类型值
* */
    public static MyFragment instanceMyFragment(int tag) {
        // 创建碎片
        MyFragment fragment = new MyFragment();
        // bundle 对象
        Bundle bundle = new Bundle();
        // 传递 标记值
        bundle.putInt("tag", tag);
        // 填充bundle
        fragment.setArguments(bundle);
        // 返回 碎片对象
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 获取 类型标记值
        tag = getArguments().getInt("tag");
        // 初始化上下文环境
        context = getContext();
        // 初始化碎片管理者
        manager = getFragmentManager();
        // 初始化布局管理器
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 初始化 数据库 工具类对象
        openHelper = new MySQLiteOpenHelper(context);
        // 初始化 数据库 工具对象
        dbConn = openHelper.dbConn;
        // 调用 初始化数据方法
        initData();
    }
/*
* 该方法用于 初始化 数据
* */
    private void initData() {
        // 加载解析网络数据
        switch (tag) {
            // 根据 tag 判断 fragment 类型
            case 0:
                //  加载 viewPager 中的 4 个碎片
                for (int i = 0; i < 4; i++) {
                    // 创建 4 种子碎片
                    MyFragmentCommend fragmnet = MyFragmentCommend.instanceMyFragmentTuiJian(i);
                    // 添加在 碎片集合中
                    totalList.add(fragmnet);
                }
                break;
            case 1:
                // 获取数据库中的 数据
                Cursor cursor = dbConn.rawQuery("select * from tb_collects ", null);
                // 将cursor 转换成 map 存入 集合中 ;
                collectList = openHelper.cursorToList(cursor);
                break;
            case 2:
                // 开启子线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 初始化 gson
                            Gson gson = new Gson();
                            // 获取 json 数据
                            String jsonData = OkHttpClientHelper.getStringFromURL(context, UrlUtils.fenLeiUrl, "video");
                            // 解析 json 数据
                            TypeBean bean = gson.fromJson(jsonData, new TypeToken<TypeBean>() {
                            }.getType());
                            // 将解析的数据 放入 集合中
                            typeList.addAll(bean.getData());
                            // 回到 主线程中
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    // 刷新适配器
                                    adapter.notifyDataSetChanged();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case 3:
                // 获取 Url
                WebViewUrl = "http://www.bilibili.com/";
                break;

        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // 填充布局
        View view = InflaterViewUtils.getViewFormFragment(tag, inflater, container);
        // 调用初始化 布局 的 方法
        initView(view);
        return view;
    }

    private void initView(View view) {
        // 根据 tag 判断 碎片的类型 , 初始化 各自的 碎片布局文件
        switch (tag) {
            case 0:
                // 初始化 tabLayout
                tabLayout_fragment = (TabLayout) view.findViewById(R.id.tabLayout_fragment);
                // 初始化 viewPager
                viewPager_fragment = (ViewPager) view.findViewById(R.id.viewPager_fragment);
                break;
            case 1:
                // 初始化 图片按钮
                imageButton_fragment = (ImageButton) view.findViewById(R.id.imageButton_fragment);
                // 初始化 下拉框
                prtFrameLayout_fragment = (PtrFrameLayout) view.findViewById(R.id.ptrFrameLayout_fragment);
                // 初始化 recyclerView
                recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_fragment);
                break;
            case 2:
                // 初始化 文本输入框
                editText_fragment = (EditText) view.findViewById(R.id.editText_fragment);
                // 初始化 图片按钮
                imageView_fragment_search = (ImageButton) view.findViewById(R.id.imageView_fragment_search);
                // 初始化 下拉框
                prtFrameLayout_fragment = (PtrFrameLayout) view.findViewById(R.id.ptrFrameLayout_fragment);
                // 初始化 recyclerVIew
                recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_fragment);
                break;
            case 3:
                // 初始化webVIew
                webView_fragment = (WebView) view.findViewById(R.id.webView_fragment);
                break;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // 调用 布局 加载数据 的方法
        loadView();
        super.onActivityCreated(savedInstanceState);
    }
    /*
    * 该方法 用于加载 数据
    * */
    private void loadView() {
        // 根据 tag 判断碎片的类型 根据类型 加载数据
        switch (tag) {
            case 0:
                // 获取 tab layout 的标题
                arrTabLayoutTitles = context.getResources().getStringArray(R.array.arrTabLayoutTitles);
                // 创建 viewPager 的 适配器
                pagerAdapter = new MyViewPagerAdapter(manager, totalList, arrTabLayoutTitles);
                // 设置 偏移量
                viewPager_fragment.setOffscreenPageLimit(4);
                // 添加 适配器
                viewPager_fragment.setAdapter(pagerAdapter);
                // 关联 tabLayout 和 viewPager
//                tabLayout_fragment.setupWithViewPager(viewPager_fragment);
                break;
            case 1:
                // 图片按钮的 监听事件
                imageButton_fragment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 跳转到 登录界面
                        Intent intent = new Intent(context, LogInActivity.class);
                        // 开启跳转
                        startActivity(intent);
                    }
                });
                // 设置 固定高度
                recyclerView.setHasFixedSize(true);
                // 设置 默认动画
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                // 设置 间距
                recyclerView.addItemDecoration(new SpacesItemDecoration(10));
                // 创建 布局管理者
                linearLayoutManager = new LinearLayoutManager(context);
                //添加布局管理者
                recyclerView.setLayoutManager(linearLayoutManager);
                // 创建 适配器
                adapter = new MyButtonAdapter(context, collectList, 1, recyclerView);
                // 添加适配器
                recyclerView.setAdapter(adapter);

                break;
            case 2:
                // 图片按钮 设置监听事件
                imageView_fragment_search.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 获取输入框中的 内容
                        String data  = editText_fragment.getText().toString();
                        // 判断 是否输入内容
                        if("".equals(data)||data == null){
                            Toast.makeText(context,"输入框为空!",Toast.LENGTH_SHORT).show();
                        }else{
                            // 创建 跳转
                            Intent intent = new Intent(context, SearchActivity.class);
                            // 传递 输入的搜索内容
                            intent.putExtra("data",data);
                            // 传递 数据 类型标签
                            intent.putExtra("tag",1);
                            // 开启跳转
                            startActivity(intent);
                        }
                    }
                });
                // 设置固定高度
                recyclerView.setHasFixedSize(true);
                // 设置默认动画
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                // 设置的边距
                recyclerView.addItemDecoration(new SpacesItemDecoration(5));
                // 创建 网格布局管理者
                gridLayoutManager = new GridLayoutManager(context, 4);
                // 添加 布局管理者
                recyclerView.setLayoutManager(gridLayoutManager);
                // 创建适配器
                adapter = new MyButtonAdapter(context, typeList, tag, recyclerView);
                // 添加适配器
                recyclerView.setAdapter(adapter);
                break;
            case 3:
                //让WebView充当url打开的客户端，避免打开浏览器软件
                webView_fragment.setWebViewClient(new WebViewClient());
                //让WebView支持alert这些特殊的javascript语句
                webView_fragment.setWebChromeClient(new WebChromeClient());
                //让WebView支持普通的JavaScript语句
                webView_fragment.getSettings().setJavaScriptEnabled(true);
                //加载url所对应的数据
                webView_fragment.loadUrl(WebViewUrl);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // 判断 是否为 书架收藏碎片
        if (tag == 1) {
            // 是
            collectList = new ArrayList<>();
            // 重新 加载数据
            initData();
            // 创建适配器
            adapter = new MyButtonAdapter(context, collectList, 1, recyclerView);
            // 添加数据
            recyclerView.setAdapter(adapter);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
