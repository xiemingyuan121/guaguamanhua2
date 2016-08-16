package com.example.administrator.bobomanhua.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.activity.DetailsActivity;
import com.example.administrator.bobomanhua.bean.ADBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;


import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/6 0006.
 */
public class ViewPagerTuiJian extends PagerAdapter {
    // 数据源
    private List<ADBean.DataBean> list = null;
    // 上下文
    private Context context = null;
    // 布局填充器
    private LayoutInflater inflater = null;

    public ViewPagerTuiJian(List<ADBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        // 填充布局
        View view = inflater.inflate(R.layout.item_viwepger_imageshow, container, false);
        // 设置监听器
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转 并 传值
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("data",list.get(position).getRecom_return()+"");
                context.startActivity(intent);
            }
        });
        // 加载数据
        SimpleDraweeView simpleDraweeView_viewPager = (SimpleDraweeView) view.findViewById(R.id.simpleDraweeView_viewPager);
        TextView textView_title_viewPager = (TextView) view.findViewById(R.id.textView_title_viewPager);
        if(list.size()!=0){
            DraweeController controller = (DraweeController) Fresco.newDraweeControllerBuilder()
                    .setUri(Uri.parse(list.get(position).getThumb()))
                    .setTapToRetryEnabled(true)
                    .setOldController(simpleDraweeView_viewPager.getController())
                    .build();
            simpleDraweeView_viewPager.setController(controller);
            textView_title_viewPager.setText(list.get(position).getTitle());
        }
        container.addView(view);
        return view;
    }
/*
* 该方法 用于 刷新适配器
* */
    public void reloadData(List<ADBean.DataBean> _list , boolean isClear){
        if(isClear){
            list.clear();
        }
        list.addAll(_list);
        notifyDataSetChanged();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
