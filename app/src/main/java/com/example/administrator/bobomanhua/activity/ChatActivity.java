package com.example.administrator.bobomanhua.activity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;


import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.adapter.ListViewAdapter;
import com.example.administrator.bobomanhua.bean.ChatBean;
import com.example.administrator.bobomanhua.helper.OkHttpClientHelper;
import com.example.administrator.bobomanhua.helper.SwipBackActivityHelper;
import com.example.administrator.bobomanhua.utils.UrlUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.Utils;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase;
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper;
/*
* 该 Activity 用来 展示 评论内容
* */
public class ChatActivity extends SwipBackActivityHelper {
    //   listView 用来 展示 评论的 列表
    private ListView listView_chatActivity;
    // 初始化 上下文环境
    private Context context= this;
    // 用来 存放 并论内容的 list 集合
    private List<ChatBean.DataBean.CommentListBean> listBeen = new ArrayList<>();
    // 线程之间 消息传递
    private Handler handler = new Handler();
    // listView 的 适配器
    private ListViewAdapter adapter ;
    // toolbar
    private Toolbar toolBar_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        initView();  // 该方法 用于初始化 控件
        initData();  //  该方法用于 子线程下载数据
        loadData();  // 该方法用于 加载数据
    }
    /*
    *  该方法 加载数据
    * */
    private void loadData() {
        // 创建 适配器
        adapter = new ListViewAdapter(context,listBeen,1);
        // lisetView 添加适配器
        listView_chatActivity.setAdapter(adapter);
    }

    /*
    * 该方法用于 网络访问 下载数据
    * */
    private void initData() {
        // 接受页面跳转的值
        String data = getIntent().getStringExtra("data");
        // 根据 页面跳转 传来的 值 配凑出 url
        final String Url = UrlUtils.getChatUrl(data);
        // 开启子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 创建 gson 类
                Gson gson = new Gson();

                try {
                    // 下载出 json 数据
                    String data = OkHttpClientHelper.getStringFromURL(context, Url, "video");
                    // 解析出 网络数据
                    ChatBean chatBean = gson.fromJson(data, new TypeToken<ChatBean>() {
                    }.getType());
                    // 集合 添加 解析出来的数据
                    listBeen.addAll(chatBean.getData().getComment_list());
                    // 返回主线程
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            // 适配器 刷新 数据
                         adapter.notifyDataSetChanged();
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
        // 初始化 listView
        listView_chatActivity = (ListView) findViewById(R.id.listView_chatActivity);
        //  初始化 toolbar
        toolBar_chat = (Toolbar) findViewById(R.id.toolBar_chat);
        // toolbar 添加标题
        toolBar_chat.setTitle("评论");
        // 添加返回标签
        toolBar_chat.setNavigationIcon(R.mipmap.back);
        // 添加 图标 点击时间
        toolBar_chat.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
