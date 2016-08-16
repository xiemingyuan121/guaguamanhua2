package com.example.administrator.bobomanhua.activity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupWindow;


import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.adapter.GirdViewAdapter;
import com.example.administrator.bobomanhua.adapter.ListViewAdapter;
import com.example.administrator.bobomanhua.bean.DetailsBean;
import com.example.administrator.bobomanhua.bean.PagerBean;
import com.example.administrator.bobomanhua.helper.MySQLiteOpenHelper;
import com.example.administrator.bobomanhua.helper.OkHttpClientHelper;
import com.example.administrator.bobomanhua.helper.SwipBackActivityHelper;
import com.example.administrator.bobomanhua.utils.UrlUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.view.ViewGroup.LayoutParams;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class DetailsActivity extends SwipBackActivityHelper {
    // toobar 栏
    private Toolbar toolbar;
    // 浮动标签
    private FloatingActionButton fab;
    // 图片 加载 布局
    private SimpleDraweeView simpleDraweeView_details_image;
    // listView 存放分类
    private ListView listView_details;
    // 线程传递消息
    private Handler handler = new Handler();
    // 上下文环境
    private Context context = this;
    // 存放 数据源
    private List<DetailsBean.DataBean.ComicSrcBean> detailsCsbList = new ArrayList<>();
    // 存放 数据源
    private List<DetailsBean.DataBean> detailsList = new ArrayList<>();
    // 存放 数据源
    private List<PagerBean.DataBean> zjBeanList = new ArrayList<>();
    // listView 的适配器
    private ListViewAdapter listViewAdapter;
    // 网格布局的 适配器
    private GirdViewAdapter popAdapter;
    // 滑动 toolbar 的 父布局
    private CollapsingToolbarLayout toolbar_layout;
    // 数据库 工具类
    private MySQLiteOpenHelper openHelper;
    // 数据库 管理者
    private SQLiteDatabase dbConn;
    // 弹出 windows
    private PopupWindow popupWindow;
    // 该activity 的 主布局
    private CoordinatorLayout layout_pop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initView(); // 调用 初始化 view 的方法
        initData(); // 调用初始化 数据的方法

    }

    /*
    * 该方法 用于加载 数据
    * */
    private void loadData() {

        // 为滚动窗口 设置 图片 加载
        simpleDraweeView_details_image.setImageURI(Uri.parse(detailsList.get(0).getThumb()));
        // 添加 标题
        toolbar_layout.setTitle(detailsList.get(0).getTitle());
        // 添加 标题 方法后的 颜色
        toolbar_layout.setExpandedTitleColor(Color.BLUE);
        // 添加标题 缩小后的 显色
        toolbar_layout.setCollapsedTitleTextColor(Color.BLUE);
        //  listView 设置 点击事件 的 监听器
        listView_details.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //初始化  弹出窗口的 布局
                View popWindows_view = getLayoutInflater().inflate(R.layout.listview_pupwindows, null);
                // 初始化 窗口中 的 网格布局
                GridView girdView_pupWindows_show = (GridView) popWindows_view.findViewById(R.id.girdView_pupWindows_show);
                // 拼凑出 相对应的 Url
                final String popData = UrlUtils.getZhangJieUrl(detailsCsbList.get(position).getId() + "", detailsList.get(0).getComicId() + "");
                // 开启子线程 进行 网络访问
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 初始化 gson
                            Gson gson = new Gson();
                            // 获取 json 数据
                            String jsonPop = OkHttpClientHelper.getStringFromURL(context, popData, "video");
                            //   解析 json
                            final PagerBean zhangJieBean = gson.fromJson(jsonPop, new TypeToken<PagerBean>() {
                            }.getType());
                            // 集合 填充数据源
                            zjBeanList.addAll(zhangJieBean.getData());
                            // 回到主线程
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    // 刷新适配器 显示数据
                                    popAdapter.reloadListView(zhangJieBean.getData(),true);
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                // 创建 适配器
                popAdapter = new GirdViewAdapter(context, zjBeanList, 1);
                // 添加适配器
                girdView_pupWindows_show.setAdapter(popAdapter);
                // 设置 item 点击监听事件
                girdView_pupWindows_show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // 页面跳转 并传值
                        Intent intent = new Intent(context,ImageShowActivity.class);
                        // 添加 要跳转的数据
                        intent.putExtra("data",zjBeanList.get(position).getId()+"");
                        // 创建 bundle 对象
                        Bundle bundle = new Bundle();
                        // 配所有 章节 的 id 存放 数组
                        String [] arrUrl = new String [zjBeanList.size()];
                        //  遍历数组 并 传值
                        for (int i = 0; i <zjBeanList.size() ; i++) {
                           // 添加 id
                            arrUrl[i] = zjBeanList.get(i).getId()+"";

                        }
                        // bundle 添加 url
                        bundle.putStringArray("arrUrl",arrUrl);
                        // 添加 点击  的 位置
                        bundle.putInt("position",position);
                        // 添加 bundle对象
                        intent.putExtras(bundle);
                        // 开始 跳转
                        startActivity(intent);
                    }
                });
                //弹出窗口 初始化 长宽高
                popupWindow = new PopupWindow(popWindows_view,LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT, true);
                // 设置动画 效果
                popupWindow.setAnimationStyle(R.style.popwin_anim_style);
                // 设置 弹出的 位置
                popupWindow.showAtLocation(layout_pop, Gravity.BOTTOM,0, 0);
                // 设置 点击 空白 关闭窗口
                popWindows_view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        if (popupWindow != null && popupWindow.isShowing()) {
                            popupWindow.dismiss();
                            popupWindow = null;
                        }
                        return false;
                    }
                });
            }
        });


        // 浮动按钮 点击监听事件
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Books bmobBean = new Books();
//                bmobBean.setComId(detailsList.get(0).getComicId()+"");
//                bmobBean.setId(detailsList.get(0).getComicId()+"");
//                bmobBean.setImageUrl(detailsList.get(0).getThumb());
//                bmobBean.setTitle(detailsList.get(0).getTitle());
//                bmobBean.setUpDateSection(detailsList.get(0).getComicSrc().get(0).getLastCharpterTitle());
//                bmobBean.setUpDateTime(detailsList.get(0).getUpdateTime());
//                bmobBean.setObjectId(detailsList.get(0).getComicId()+"");
//                bmobBean.save(context);
                // 创建 内容 存放者
                ContentValues values = new ContentValues();
                // values 添加 要存进 数据库的 内容
                values.put("_id", detailsList.get(0).getComicId());
                // values 添加 要存进 数据库的 内容
                values.put("title", detailsList.get(0).getTitle());
                // values 添加 要存进 数据库的 内容
                values.put("upDateTime", detailsList.get(0).getUpdateTime());
                // values 添加 要存进 数据库的 内容
                values.put("upDateSection", detailsList.get(0).getComicSrc().get(0).getLastCharpterTitle());
                // values 添加 要存进 数据库的 内容
                values.put("imageUrl", detailsList.get(0).getThumb());
                // values 添加 要存进 数据库的 内容
                values.put("comId",detailsList.get(0).getComicId());
                // 工具 向 数据库 添加 数据
                dbConn.insert("tb_collects", null, values);
                // 通知 保存成功
                Snackbar.make(view, "收藏成功", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /*
    * 该方法 用于下载数据
    * */
    private void initData() {
        // 接收 跳转 并且 传来的值
        String page = getIntent().getStringExtra("data");
        // 获取 对应的 URL
        final String Url = UrlUtils.getXiangQingURL(page);
        // 开启 子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 初始化 gson 对象
                Gson gson = new Gson();
                try {
                    // 获取 json 数据
                    String data = OkHttpClientHelper.getStringFromURL(context, Url, "video");
                    // 解析 json 数据
                    DetailsBean detailsBean = gson.fromJson(data, new TypeToken<DetailsBean>() {
                    }.getType());
                    // 集合添加 数据源
                    detailsCsbList.addAll(detailsBean.getData().getComicSrc());
                    // 集合 添加 数据源
                    detailsList.add(detailsBean.getData());
                    // 回到 主线程
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            // list view 添加 适配器
                            listView_details.setAdapter(listViewAdapter);
                            // 适配器 刷新数据
                            listViewAdapter.notifyDataSetChanged();
                            // 调用 加载 填充 数据的方法
                            loadData();
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
        // 初始化 图片加载view
        simpleDraweeView_details_image = (SimpleDraweeView) findViewById(R.id.simpleDraweeView_details_image);
        // 初始化 滚动的 toobar父布局
        toolbar_layout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        // 初始化 toobar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // 设置为 action bar
        setSupportActionBar(toolbar);
        //  弹出 窗口的 布局
        layout_pop = (CoordinatorLayout) findViewById(R.id.layout_pop);
        // 初始化 listView
        listView_details = (ListView) findViewById(R.id.listView_details);
        // 初始化 适配器
        listViewAdapter = new ListViewAdapter(context, detailsCsbList, 0);
        // toolbar 添加 图标
        toolbar.setNavigationIcon(R.mipmap.back);
        // 添加 图标的 点击监听事件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 页面销毁
                finish();
            }
        });
        // 初始化 浮动按钮
        fab = (FloatingActionButton) findViewById(R.id.fab);
        // 初始化 数据库 工具类
        openHelper = new MySQLiteOpenHelper(context);
        // 初始化数据库 工具
        dbConn = openHelper.dbConn;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 获取菜单 布局
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 菜单布局 的 监听事件
        switch (item.getItemId()) {
            // 评论按钮
            case R.id.action_pinglun:
                // 开启页面跳转
                Intent intent = new Intent(this, ChatActivity.class);
                // 传值
                intent.putExtra("data", detailsList.get(0).getComicId() + "");
                // 开始跳转
                startActivity(intent);
                break;
            // 简介 按钮
            case R.id.action_jianjie:
                // 初始化 对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                // 设置  标题
                builder.setTitle(detailsList.get(0).getTitle());
                // 设置 内容
                builder.setMessage(detailsList.get(0).getIntro());
                // 设置按钮
                builder.setNegativeButton("确定", null);
                // 展示
                builder.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
