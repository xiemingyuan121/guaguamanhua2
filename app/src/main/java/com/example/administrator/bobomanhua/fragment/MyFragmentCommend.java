package com.example.administrator.bobomanhua.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
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
import android.widget.AdapterView;
import android.widget.ScrollView;
import android.widget.Toast;


import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.activity.DetailsActivity;
import com.example.administrator.bobomanhua.adapter.GirdViewAdapter;
import com.example.administrator.bobomanhua.adapter.MyChildAdapter;
import com.example.administrator.bobomanhua.adapter.ViewPagerTuiJian;
import com.example.administrator.bobomanhua.bean.ADBean;
import com.example.administrator.bobomanhua.bean.HotBean;
import com.example.administrator.bobomanhua.bean.RecommendBean;
import com.example.administrator.bobomanhua.bean.SplendidBean;
import com.example.administrator.bobomanhua.bean.UpDateBean;
import com.example.administrator.bobomanhua.decoration.SpacesItemDecoration;
import com.example.administrator.bobomanhua.helper.OkHttpClientHelper;
import com.example.administrator.bobomanhua.utils.MyGirdView;
import com.example.administrator.bobomanhua.utils.UrlUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2016/8/6 0006.
 */
public class MyFragmentCommend extends Fragment {
    // 碎片类型标记
    private int tag;
    // 上下文环境
    private Context context;
    // 碎片管理者
    private FragmentManager manager;
    // 布局填充器
    private LayoutInflater inflater;
    //recyclerVIew 布局
    private RecyclerView recyclerView_fragment;
    // viewpager 布局
    private ViewPager viewPager_child_tuiJian;
    //下拉工具
    private PtrFrameLayout prtFrameLayout_fragment;
    //适配器
    private MyChildAdapter adapter;
    //线性布局管理者
    private LinearLayoutManager linearLayoutManager;
    // 网格布局管理者
    private GridLayoutManager gridLayoutManager;
    // viewPager 适配器
    private ViewPagerTuiJian viewPagerAdapter;
    //数据集合
    private List<HotBean.DataBean> hotBeanList = new ArrayList<>();
    //数据集合
    private List<ADBean.DataBean> adBeanList = new ArrayList<>();
    //数据集合
    private List<RecommendBean.DataBean> recBeanList = new ArrayList<>();
    //数据集合
    private List<SplendidBean.DataBean> splBeanList = new ArrayList<>();
    //数据集合
    private List<UpDateBean.DataBean> upDateBeanList = new ArrayList<>();
    // 消息传递者
    private Handler handler = new Handler();
    // 网格布局 适配器
    private GirdViewAdapter girdViewAdapter;
    // 网格 布局
    private MyGirdView myGirdView_viewpager_show;
    //下拉刷新 工具
    private PullToRefreshScrollView pullRefreshScrollView;
    // recyclerVIew 最后一个位置
    private int lastVisibleItemPosition;
    // 页数
    private int page = 1;
    // 数据Url
    private String Url = "";
    // 判断 标签
    private boolean isFlag = false;
    // 数据集合
    private List<HotBean.DataBean> newHotList = new ArrayList<>();

    /*
    * 该方法用于 创建碎片并传递 类型tag 值
    * */
    public static MyFragmentCommend instanceMyFragmentTuiJian(int tag) {
        // 创建碎片
        MyFragmentCommend fragment = new MyFragmentCommend();
        // bundle 对象
        Bundle bundle = new Bundle();
        // 传递 tag
        bundle.putInt("tag", tag);
        // 发送 bundle
        fragment.setArguments(bundle);
        // 返回碎片
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 获取 tag 类型值
        tag = getArguments().getInt("tag");
        // 初始化上下文
        context = getContext();
        // 初始化管理者
        manager = getFragmentManager();
        //初始化填充器
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 调用 初始化数据的方法
        initData();
    }


    private void initData() {
        // 根据tag 类型值 判断碎片种类
        switch (tag) {
            case 0:
                // 获取Url
                Url = UrlUtils.getHotUrl(page);
                break;
            case 1:
                // 获取Url
                Url = UrlUtils.getTuiJianUrl(page);
                break;
            case 2:
                // 获取Url
                Url = UrlUtils.getGangManUrl(page);
                break;
            case 3:
                // 获取Url
                Url = UrlUtils.getUpDateUrl(page);
                break;
        }
        // 根据 tag 判断 碎片种类
        switch (tag) {
            case 0:
                // 加载 首页的 json 数据
                // 开启子线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 获取json 数据
                             String jsonADData = OkHttpClientHelper.getStringFromURL(context, UrlUtils.guangGaoUrl, "video");
                            // 解析数据
                            final ADBean adBean = (ADBean) parseJsonToQiuShiModel(jsonADData, 4);
                            // 填充数据
                            adBeanList.addAll(adBean.getData());
                            // 获取 json 数据
                            String jsonData = OkHttpClientHelper.getStringFromURL(context, Url, "video");
                            // 解析数据
                            final HotBean hotBean = (HotBean) parseJsonToQiuShiModel(jsonData, tag);
                            // list 填充数据
                            hotBeanList.addAll(hotBean.getData());
                            // 回到主线程
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    // 创建适配器
                                    viewPagerAdapter = new ViewPagerTuiJian(adBeanList, context);
                                    // 添加适配器
                                    viewPager_child_tuiJian.setAdapter(viewPagerAdapter);
                                    //更新 下拉 刷新 上啦 加载 后 更新数据源 ;
                                    if (page == 1) {
                                        // 更新数据 并删除 以前的数据
                                        newHotList =  girdViewAdapter.reloadListView(hotBean.getData(), true);
                                        viewPagerAdapter.reloadData(adBean.getData(),true);
                                    } else {
                                        //更新数据 不删除 以前数据
                                        newHotList = girdViewAdapter.reloadListView(hotBean.getData(), false);
                                        viewPagerAdapter.reloadData(adBean.getData(),true);
                                    }
                                    //下拉 刷新 完成
                                    pullRefreshScrollView.onRefreshComplete();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


                break;
            case 1:
                // 加载 首页的 json 数据
                // 开启子线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // okhttp 和工具类 解析 获得 网络数据
                            String jsonData = OkHttpClientHelper.getStringFromURL(context, Url, "video");
                            // 解析数据
                            final RecommendBean recommendBean = (RecommendBean) parseJsonToQiuShiModel(jsonData, tag);
                            // list 填充数据
                            recBeanList.addAll(recommendBean.getData());
                            // 回到主线程
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    // 更新 下拉 刷新 上啦 加载 后 更新数据源 ;
                                    if (page == 1) {
                                        // 更新数据 并删除 以前的数据
                                        adapter.reloadRecyclerView(recommendBean.getData(), true);
                                    } else {
                                        // 更新数据 不删除 以前数据
                                        adapter.reloadRecyclerView(recommendBean.getData(), false);
                                    }
                                    // 下拉 刷新 完成
                                    prtFrameLayout_fragment.refreshComplete();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;
            case 2:
                // 加载 首页的 json 数据
                // 开启子线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // okhttp 和工具类 解析 获得 网络数据
                            String jsonData = OkHttpClientHelper.getStringFromURL(context, Url, "video");
                            // 解析数据
                            final SplendidBean splendidBean = (SplendidBean) parseJsonToQiuShiModel(jsonData, tag);
                            // list 填充数据
                            splBeanList.addAll(splendidBean.getData());
                            // 回到主线程
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    // 更新 下拉 刷新 上啦 加载 后 更新数据源 ;
                                    if (page == 1) {
                                        // 更新数据 并删除 以前的数据
                                        adapter.reloadRecyclerView(splendidBean.getData(), true);
                                    } else {
                                        // 更新数据 不删除 以前数据
                                        adapter.reloadRecyclerView(splendidBean.getData(), false);
                                    }
                                    // 下拉 刷新 完成
                                    prtFrameLayout_fragment.refreshComplete();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case 3:
                // 加载 首页的 json 数据
                // 开启子线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // okhttp 和工具类 解析 获得 网络数据
                            String jsonData = OkHttpClientHelper.getStringFromURL(context, Url, "video");
                            // 解析数据
                            final UpDateBean upDateBean = (UpDateBean) parseJsonToQiuShiModel(jsonData, tag);
                            // list 填充数据
                            upDateBeanList.addAll(upDateBean.getData());
                            // 回到主线程
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    // 更新 下拉 刷新 上啦 加载 后 更新数据源 ;
                                    if (tag == 1) {
                                        // 更新数据 并删除 以前的数据
                                        adapter.reloadRecyclerView(upDateBean.getData(), true);
                                    } else {
                                        // 更新数据 不删除 以前数据
                                        adapter.reloadRecyclerView(upDateBean.getData(), false);
                                    }
                                    // 下拉 刷新 完成
                                    prtFrameLayout_fragment.refreshComplete();
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
        }
    }
/*
* 该方法 用与 根据 tag 解析 数据
* */
    private Object parseJsonToQiuShiModel(String jsonData, int tags) {
        // 先判断 数据源 是 哪个碎片的 是 首页 , 资讯 , 还是 直播
        // 创建 gson对象
        Gson gson = new Gson();
        if (tags == 0) {
            // 解析数据
            HotBean bean = gson.fromJson(jsonData, new TypeToken<HotBean>() {
            }.getType());
            return bean;
        } else if (tags == 1) {
            // 解析数据
            RecommendBean bean = gson.fromJson(jsonData, new TypeToken<RecommendBean>() {
            }.getType());
            return bean;
        } else if (tags == 2) {
            // 解析数据
            SplendidBean bean = gson.fromJson(jsonData, new TypeToken<SplendidBean>() {
            }.getType());
            return bean;
        } else if (tags == 3) {
            // 解析数据
            UpDateBean bean = gson.fromJson(jsonData, new TypeToken<UpDateBean>() {
            }.getType());
            return bean;
        } else {
            // 解析数据
            ADBean bean = gson.fromJson(jsonData, new TypeToken<ADBean>() {
            }.getType());
            return bean;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        // 根据 tag 值 判断碎片类型
        if (tag == 0) {
            // 填充布局
            view = inflater.inflate(R.layout.child_recommend_laout_fragment, container, false);
        } else {
            // 填充布局
            view = inflater.inflate(R.layout.toolabar_recyclerview, container, false);
        }
        // 根据 tag 值 判断碎片类型
        if (tag == 0) {
            // 初始化 viewPager
            viewPager_child_tuiJian = (ViewPager) view.findViewById(R.id.viewPager_child_tuiJian);
           // 初始化 girdVIew
            myGirdView_viewpager_show = (MyGirdView) view.findViewById(R.id.myGirdView_viewpager_show);
            // 初始化 下拉工具
            pullRefreshScrollView = (PullToRefreshScrollView) view.findViewById(R.id.pullRefreshScrollView);
        } else {
            // 初始化 recycleVIew
            recyclerView_fragment = (RecyclerView) view.findViewById(R.id.recyclerView_fragment);
           // 初始化 下拉工具
            prtFrameLayout_fragment = (PtrFrameLayout) view.findViewById(R.id.ptrFrameLayout_fragment);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        // 根据tag 判断碎片类型
        if (tag != 0) {
            // 设置定高
            recyclerView_fragment.setHasFixedSize(true);
            // 设置 动画
            recyclerView_fragment.setItemAnimator(new DefaultItemAnimator());
            // 设置 间隔
            recyclerView_fragment.addItemDecoration(new SpacesItemDecoration(5));
        }
        // 根据tag 判断碎片类型
        switch (tag) {
            case 0:
                //  创建 网格适配器
                girdViewAdapter = new GirdViewAdapter(context, hotBeanList,0);
                // 添加适配器
                myGirdView_viewpager_show.setAdapter(girdViewAdapter);
                // 下拉刷新 类型
                pullRefreshScrollView.setMode(PullToRefreshBase.Mode.BOTH);
                // 设置 item 点击事件
                myGirdView_viewpager_show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // 创建 跳转
                        Intent intent = new Intent(context, DetailsActivity.class);
                        // 添加数据
                        intent.putExtra("data",newHotList.get(position).getComicId()+"");
                        // 开始跳转
                        startActivity(intent);
                    }
                });
                break;
            case 1:
                // 创建网格布局管理者
                gridLayoutManager = new GridLayoutManager(context, 3);
                // 添加 网格布局管理者
                recyclerView_fragment.setLayoutManager(gridLayoutManager);
                // 创建 适配器
                adapter = new MyChildAdapter(context, recBeanList, 1,recyclerView_fragment);
                // 添加适配器
                recyclerView_fragment.setAdapter(adapter);
                break;
            case 2:
                // 创建网格布局管理者
                gridLayoutManager = new GridLayoutManager(context, 3);
                // 添加网格布局管理者
                recyclerView_fragment.setLayoutManager(gridLayoutManager);
                // 创建 适配器
                adapter = new MyChildAdapter(context, splBeanList, 2,recyclerView_fragment);
                // 添加 适配器
                recyclerView_fragment.setAdapter(adapter);
                break;
            case 3:
                // 创建线性布局管理者
                linearLayoutManager = new LinearLayoutManager(context);
                // 添加线性布局管理者
                recyclerView_fragment.setLayoutManager(linearLayoutManager);
                // 创建适配器
                adapter = new MyChildAdapter(context, upDateBeanList, 3,recyclerView_fragment);
                // 添加适配器
                recyclerView_fragment.setAdapter(adapter);
                break;
        }

        if (tag == 0) {
            // 调用网格布局 刷新监听事件
            pullRefreshGirld();
        } else {
            // 调用recuclerVIew 刷新事件
            pullRefreshFragment();
        }
        super.onActivityCreated(savedInstanceState);
    }
/*
* 该方法 gird 下拉刷新
* */
    private void pullRefreshGirld() {
        // 设置 下拉刷新监听器
        pullRefreshScrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                // 下拉 页数 = 1 ;
                page = 1;
                // 加载数据
                initData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                // 上拉 加载 更多
                page++;
                // 加载数据
                initData();
            }
        });
    }
    /*
     * 该方法用于 监听下拉刷新
     * */
    private void pullRefreshFragment() {


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
               // 页数
                page = 1;
                // 加载数据
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
                    //加载数据
                    initData();
                    //通知
                    Toast.makeText(context, "加载成功!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // 滚动监听器  判断 根据 视图 管理者来获取 最后一个视图的 位置 ;
                if (tag == 1 || tag == 2) {
                    lastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
                } else if (tag == 3) {
                    lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                }
            }
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
