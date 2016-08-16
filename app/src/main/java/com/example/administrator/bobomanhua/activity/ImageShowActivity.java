package com.example.administrator.bobomanhua.activity;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.adapter.MyChildAdapter;
import com.example.administrator.bobomanhua.bean.ImageShowBean;
import com.example.administrator.bobomanhua.decoration.SpacesItemDecoration;
import com.example.administrator.bobomanhua.helper.OkHttpClientHelper;
import com.example.administrator.bobomanhua.helper.SwipBackActivityHelper;
import com.example.administrator.bobomanhua.utils.UrlUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageShowActivity extends SwipBackActivityHelper {
    // recyclerView 布局
    private RecyclerView recyclerView_fragment;
    // 消息传递
    private Handler handler = new Handler();
    // 上下文环境
    private Context context = this;
    // 线性布局 管理者
    private LinearLayoutManager linearLayoutManager;
    // 适配器
    private MyChildAdapter adapter;
    // 集合 存放数据
    private List<ImageShowBean.DataBean> imageList = new ArrayList<>();
    // 集合存放 图片 网址
    private List<String> imageUrlList = new ArrayList<>();
    // 文本显示 时间
    private TextView textView_time_imageShow;
    // 文本显示 章节
    private TextView textView_title_imageShow;
    // 文本显示 电量
    private TextView textView_dianLiang_imageShow;
    // 文本显示 进度
    private TextView textView_jinDu_imageShow;
    // 按钮 调节 上一章
    private Button button_imageShow_up;
    // 按钮 调节下一张
    private Button button_imageShow_down;
    // 网址
    private String dataUrl = "" ;
    // 页数
    private  int page ;
    // 所有章节的 Url
    private String [] arrUrl = null ;
    // 是否 显示
    private boolean isShow = false ;
    // 进度条
    private SeekBar seekBar_progress;
    // 亮度进度条
    private SeekBar seekBar_liangDu;
    // 文本显示 章节进度
    private TextView textView_progress;
    // 相对布局 存放 进度条
    private RelativeLayout relativeLayout_seekBar;
    // 相对布局  存放 图片按钮
    private RelativeLayout relativeLayout_imageButton;
    // 是否 显示布局
    private boolean isOpen = false;
    // 是否 改变
    private boolean isChange = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show2);
        // 调用初始化 控件方法
        initView();
        //  接受 传递过来的 值
        dataUrl = getIntent().getStringExtra("data");
        // 接受 传递过来的 值
        page = getIntent().getExtras().getInt("position");
        // 接受 传递过来的 值
        arrUrl = getIntent().getExtras().getStringArray("arrUrl");

        initData(); // 调用初始化数据的方法
        loadData(); // 调用加载数据的方法
    }

    /*
    * 该方法用于加载数据
    * */
    private void loadData() {
        // 获取系统当前的时间
        Date date = new Date();
        // 格式化 魔板
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //  格式化时间
        String newDate = dateFormat.format(date);
        // 添加 时间
        textView_time_imageShow.setText(newDate);
        // 这是 固定高度
        recyclerView_fragment.setHasFixedSize(true);
        // 设置动画
        recyclerView_fragment.setItemAnimator(new DefaultItemAnimator());
        // 设置 间距
        recyclerView_fragment.addItemDecoration(new SpacesItemDecoration(5));
        // 初始化 线性布局
        linearLayoutManager = new LinearLayoutManager(context);
        // 添加 布局文件
        recyclerView_fragment.setLayoutManager(linearLayoutManager);
        //创建适配器
        adapter = new MyChildAdapter(context, imageUrlList, 5, recyclerView_fragment);
        // 添加适配器
        recyclerView_fragment.setAdapter(adapter);
        // 添加监听事件
        adapter.setOnClickListener(new MyChildAdapter.onClickListener() {
            @Override
            public void onClick(int position) {
                // 判断图标 是否打开
                if(isOpen){
                    // 如果打开 就 关闭
                    seekBar_liangDu.setVisibility(View.GONE);
                    // 变为 没打开
                    isOpen = false ;
                }
                // 判断 布局 是否 显示
                if(isShow){
                    //  如果显示 就 关闭
                    relativeLayout_seekBar.setVisibility(View.GONE);
                    relativeLayout_imageButton.setVisibility(View.GONE);
                    isShow = false;
                }else{
                    // 果果没显示 就打开
                    relativeLayout_seekBar.setVisibility(View.VISIBLE);
                    relativeLayout_imageButton.setVisibility(View.VISIBLE);
                    isShow = true ;
                }
            }
        });
        // 设置 滚动监听
        recyclerView_fragment.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 判断 滚动状态 是否停止
                if(newState==RecyclerView.SCROLL_STATE_IDLE){
                    // 获取 滚动后的 对应位置
                   int position =  linearLayoutManager.findLastVisibleItemPosition()+1;
                    //添加 位置
                    textView_jinDu_imageShow.setText(position+"/"+imageUrlList.size());
                    // 添加进度
                    textView_progress.setText(position+"/"+imageUrlList.size());
                    // 进度条 相对位置
                    seekBar_progress.setProgress(position);
                    // 如果是 第一个位置 就显示 上一章 按钮
                    if(position==1){
                        button_imageShow_up.setVisibility(View.VISIBLE);
                        // 如果是 最后一个 就显示 下一张按钮
                    }else if (position == adapter.getItemCount()){
                        button_imageShow_down.setVisibility(View.VISIBLE);
                    }else{
                        button_imageShow_down.setVisibility(View.GONE);
                        button_imageShow_up.setVisibility(View.GONE);
                    }
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

            }
        });
    }
/*
* 该方法 用于 初始化 数据
* */
    private void initData() {
        // 获取对应的Url
        final String imageShowUrl = UrlUtils.getImageShowUrl(dataUrl);
        // 开启子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 初始化 gson
                    Gson gson = new Gson();
                    // 获取 json 数据
                    String jsonData = OkHttpClientHelper.getStringFromURL(context, imageShowUrl, "video");
                    // 解析 json数据
                    final ImageShowBean bean = gson.fromJson(jsonData, new TypeToken<ImageShowBean>() {
                    }.getType());
                    // 添加 数据原
                    imageList.add(bean.getData());
                    // 添加数据源
                    imageUrlList.addAll(bean.getData().getAddrs());
                    // 回到 主线程
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            // 刷新 适配器
                            adapter.reloadRecyclerView(bean.getData().getAddrs(),true);
                            // 文本显示章节
                            textView_title_imageShow.setText(bean.getData().getTitle());
                            // 进度条 设置最大 页数
                            seekBar_progress.setMax(bean.getData().getAddrs().size());
                            // 文本添加 进度
                            textView_jinDu_imageShow.setText("1/"+bean.getData().getAddrs().size());
                            // 文本添加 进度
                            textView_progress.setText("1/"+bean.getData().getAddrs().size());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
/*
* 该方法 用于 初始化 控件
* */
    private void initView() {
        // 初始化进度条
        seekBar_progress = (SeekBar) findViewById(R.id.seekBar_progress);
        // 初始化进图条
        seekBar_liangDu = (SeekBar) findViewById(R.id.seekBar_liangDu);
        // 初始化 文本进度
        textView_progress = (TextView) findViewById(R.id.textView_progress);
        // 初始化 存放 进度条的 布局
        relativeLayout_seekBar = (RelativeLayout) findViewById(R.id.relativeLayout_seekBar);
        // 初始化 存放 图片按钮的 布局
        relativeLayout_imageButton = (RelativeLayout) findViewById(R.id.relativeLayout_imageButton);
        // 初始化recyclerView
        recyclerView_fragment = (RecyclerView) findViewById(R.id.recyclerView_fragment);
        // 初始化 文本 时间
        textView_time_imageShow = (TextView) findViewById(R.id.textView_time_imageShow);
        // 初始化 文本 章节
        textView_title_imageShow = (TextView) findViewById(R.id.textView_title_imageShow);
        // 初始化 文本 电量
        textView_dianLiang_imageShow = (TextView) findViewById(R.id.textView_dianLiang_imageShow);
        // 初始化 上一章 按钮
        button_imageShow_up = (Button) findViewById(R.id.button_imageShow_up);
        // 初始化 下一张 按钮
        button_imageShow_down = (Button) findViewById(R.id.button_imageShow_down);
        // 初始化 文本进度
        textView_jinDu_imageShow = (TextView) findViewById(R.id.textView_jinDu_imageShow);
        // 接受 本地广播
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        // 初始化 内部类对象
        BatteryReceiver receiver = new BatteryReceiver();
        // 注册 接受本地广播
        registerReceiver(receiver, filter);
        // 进图条 设置监听
        seekBar_progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // 最新进度
            private  int newprogress ;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 滑动距离
                newprogress = progress ;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // recycler 滑动到 相对位置
                recyclerView_fragment.scrollToPosition(newprogress);
                // 文本进度条 改变
                textView_jinDu_imageShow.setText(newprogress+"/"+imageUrlList.size());
                // 文本进度条 改变
                textView_progress.setText(newprogress+"/"+imageUrlList.size());
            }
        });

        // 亮度 进度条 设置监听
        seekBar_liangDu.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // 滚动距离
            float brightness;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
              // 滚动距离
                brightness = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // 获取 当前 亮度 管理者
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                // 添加滑动后的 亮度
                lp.screenBrightness = Float.valueOf(brightness) * (1f / 255f);
                // 填充 连读管理者
                getWindow().setAttributes(lp);
            }
        });
    }
        // 按钮点击 监听事件
    public void onClick(View view) {
        // 判断
        switch (view.getId()){
            // 上一章 按钮
            case R.id.button_imageShow_up:
                // 如果 是第一张
               if((arrUrl.length-1-page)==0){
                   Toast.makeText(context,"已经是第一章了",Toast.LENGTH_SHORT).show();
               }else{
                   // 不是 就跳转到 上一章
                   dataUrl = arrUrl[++page];
                   // 加载数据
                   initData();
               }
                break;
            // 下一张按钮
            case R.id.button_imageShow_down:
                // 如果是最后一张
                if(page == 0){
                    Toast.makeText(context,"已经是最后一章了",Toast.LENGTH_SHORT).show();
                }else{
                    // 不是 就加载 下一张
                    dataUrl = arrUrl[--page];
                    // 加载数据
                    initData();
                }
                break ;
        }
    }
    // 图片 按钮 点击事件
    public void onImageClick(View view) {
        switch (view.getId()){
            // 如果是 旋转按钮
            case R.id.imageButton_xuanZhuan:
                // 是否 改变过 方向
                // 是
                if(isChange){
                    // 改变回来
                    linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,true);
                    // 重新加载
                    recyclerView_fragment.setLayoutManager(linearLayoutManager);
                    isChange = false;
                }else {
                    // 不是
                    linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true);
                    // 改变方向 加载
                    recyclerView_fragment.setLayoutManager(linearLayoutManager);
                    isChange = true ;
                }
                break ;
            // 亮度 按钮
            case R.id.imageButton_liangDu:
                // 获取当前 亮度
                int nowBrightnessValue = 0;
                ContentResolver resolver = getContentResolver();
                try {
                    nowBrightnessValue = Settings.System.getInt(
                            resolver, Settings.System.SCREEN_BRIGHTNESS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 设置 进度条 最大进度
                seekBar_liangDu.setMax(255);
                // 填充当前 进度位置
                seekBar_liangDu.setProgress(nowBrightnessValue);
                // 是否 打开过 进度条
                if(isOpen){
                    // 是 就 消失
                    seekBar_liangDu.setVisibility(View.GONE);
                    isOpen = false;
                }else{
                    // 不是就 显示
                    seekBar_liangDu.setVisibility(View.VISIBLE);
                    isOpen = true;
                }
                break ;
        }
    }
    // 内部类 接受 系统广播
    private class BatteryReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 获取 数值
            int current = intent.getExtras().getInt("level");
            // 获取比例
            int total = intent.getExtras().getInt("scale");
            // 进行计算
            int percent = current * 100 / total;
            // 显示出来
            textView_dianLiang_imageShow.setText(percent + "%");
        }
    }

}
