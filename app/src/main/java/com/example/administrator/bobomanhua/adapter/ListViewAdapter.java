package com.example.administrator.bobomanhua.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.bean.ChatBean;
import com.example.administrator.bobomanhua.bean.DetailsBean;
import com.example.administrator.bobomanhua.helper.BaseAdapterHelper;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class ListViewAdapter extends BaseAdapterHelper {
    // 数据源 类型标记
    private int tag ;
    public ListViewAdapter(Context context, List list,int tag) {
        super(context, list);
        this.tag = tag;
        }



    @Override
    public View getItemView(int position, View convertView, ViewGroup parent, List list, final LayoutInflater inflater) {
        // 根据 数据源标记 判断 数据源类型
        if(tag==0){
            MyViewHolderDetails viewHolderDetails = null ;
            // 初始化 控件
            if(convertView==null){
                viewHolderDetails = new MyViewHolderDetails();
                convertView = inflater.inflate(R.layout.item_listview_details,parent,false);
                viewHolderDetails.textView_date_listView = (TextView) convertView.findViewById(R.id.textView_date_listView);
                viewHolderDetails.textView_zhangjie_listView = (TextView) convertView.findViewById(R.id.textView_zhangJie_listView);
                viewHolderDetails.textView_title_listView = (TextView) convertView.findViewById(R.id.textView_title_listView);
                convertView.setTag(viewHolderDetails);
            }else{
                viewHolderDetails = (MyViewHolderDetails) convertView.getTag();
            }
            // 强转 数据源
            DetailsBean.DataBean.ComicSrcBean detaBean = (DetailsBean.DataBean.ComicSrcBean) list.get(position);
            // 填充数据
            viewHolderDetails.textView_title_listView.setText(detaBean.getTitle());
            viewHolderDetails.textView_zhangjie_listView.setText(detaBean.getLastCharpterTitle());
            long time = new Long(detaBean.getLastCharpterUpdateTime()+"");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String string = sdf.format(time*1000);
            viewHolderDetails.textView_date_listView.setText(string);
            return convertView;
        }else {
            // 初始化 控件
            MyViewHolderChat viewHolderChat = null ;
            if(convertView==null){
                viewHolderChat = new MyViewHolderChat();
                convertView = inflater.inflate(R.layout.item_chat_listview,parent,false);
                viewHolderChat.simpleDraweeView_chat_listView = (SimpleDraweeView) convertView.findViewById(R.id.simpleDraweeView_chat_listView);
                viewHolderChat.textView_user_listView = (TextView) convertView.findViewById(R.id.textView_user_listView);
                viewHolderChat.textView_chat_listView = (TextView) convertView.findViewById(R.id.textView_chat_listView);
                viewHolderChat.textView_date_listView = (TextView) convertView.findViewById(R.id.textView_date_listView);
                viewHolderChat.textView_content_listView = (TextView) convertView.findViewById(R.id.textView_content_listView);
                convertView.setTag(viewHolderChat);
            }else{
                viewHolderChat = (MyViewHolderChat) convertView.getTag();
            }
            // 强转数据源
           ChatBean.DataBean.CommentListBean  bean= (ChatBean.DataBean.CommentListBean) list.get(position);
            // 加载数据
            viewHolderChat.simpleDraweeView_chat_listView.setImageURI(Uri.parse(bean.getUser_thumb()));
            viewHolderChat.textView_user_listView.setText(bean.getNickname());
            viewHolderChat.textView_date_listView.setText(bean.getPost_time());
            viewHolderChat.textView_chat_listView.setText(bean.getReply_no());
            viewHolderChat.textView_content_listView.setText(bean.getContent());

            return convertView;
        }

    }
        // 内部类
    class MyViewHolderDetails {
        private TextView textView_title_listView;
        private TextView textView_zhangjie_listView;
        private TextView textView_date_listView;
    }
    // 内部类
    class MyViewHolderChat{
        private SimpleDraweeView simpleDraweeView_chat_listView;
        private TextView textView_user_listView;
        private TextView textView_date_listView;
        private TextView textView_chat_listView;
        private TextView textView_content_listView;
    }
}
