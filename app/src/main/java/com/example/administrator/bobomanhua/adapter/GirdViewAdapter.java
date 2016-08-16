package com.example.administrator.bobomanhua.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.bean.HotBean;
import com.example.administrator.bobomanhua.bean.PagerBean;
import com.example.administrator.bobomanhua.helper.BaseAdapterHelper;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class GirdViewAdapter extends BaseAdapterHelper {
    // 标记
    int tag ;
    // 构造方法
    public GirdViewAdapter(Context context, List list ,int tag) {
        super(context, list);
        this.tag = tag ;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent, List list, LayoutInflater inflater) {
        // 判断 数据源 类型
        if(tag==0){
            // 创建 内部类对象
            MyViewHolder viewHolder = null ;
            if(convertView == null ){
                // 初始化对象
                viewHolder = new MyViewHolder();
                // 填充布局
                convertView = inflater.inflate(R.layout.item_recyclerview_fragment,null);
                // 初始化控件
                viewHolder.simpleDraweeView_image = (SimpleDraweeView) convertView.findViewById(R.id.simpleDraweeView_image);
                viewHolder.textView_number = (TextView) convertView.findViewById(R.id.textView_number);
                viewHolder.textView_title = (TextView) convertView.findViewById(R.id.textView_title);
                // 打标签
                convertView.setTag(viewHolder);
            }else{
                // 获取标签
                viewHolder = (MyViewHolder) convertView.getTag();
            }
            // 根据数据源 强转 得到数据
            HotBean.DataBean dataBean = (HotBean.DataBean) list.get(position);
            // 根据数据源 填充数据
            viewHolder.simpleDraweeView_image.setImageURI(Uri.parse(dataBean.getThumb()));
            viewHolder.textView_title.setText(dataBean.getTitle());
            viewHolder.textView_number.setText(dataBean.getLastCharpter().getTitle());
            return convertView;
        }else {
            // 创建内部类对象
            MyViewHolderPop viewHolderPop = null ;
            if(convertView==null){
                // 初始化 控件
                viewHolderPop= new MyViewHolderPop();
                convertView = inflater.inflate(R.layout.item_girldview_popwindow,null);
                viewHolderPop.textView_popWindow_show= (TextView) convertView.findViewById(R.id.textView_popWindow_show);
                convertView.setTag(viewHolderPop);
            }else{
               viewHolderPop = (MyViewHolderPop) convertView.getTag();
            }
            // 加载数据
            PagerBean.DataBean dataBean = (PagerBean.DataBean) list.get(position);
            viewHolderPop.textView_popWindow_show.setText(dataBean.getTitle());
            return convertView;
        }

    }
    // 内部类
    class MyViewHolder {
        private SimpleDraweeView simpleDraweeView_image;
        private TextView textView_title;
        private TextView textView_number;
    }
    // 内部类
    class MyViewHolderPop{
        private TextView textView_popWindow_show;
    }
}
