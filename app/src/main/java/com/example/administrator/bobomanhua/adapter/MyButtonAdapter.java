package com.example.administrator.bobomanhua.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.activity.DetailsActivity;
import com.example.administrator.bobomanhua.activity.SearchActivity;
import com.example.administrator.bobomanhua.bean.TypeBean;
import com.example.administrator.bobomanhua.helper.MySQLiteOpenHelper;
import com.example.administrator.bobomanhua.helper.RecyclerViewAdapterHelper;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;
import java.util.Map;



/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class MyButtonAdapter extends RecyclerViewAdapterHelper {
    // 数据源 类型 标记
    private int pag;
    // recyclerview
    private RecyclerView recyclerView;
    // 数据 操作 助手
    private SQLiteDatabase dbConn;
    // 数据操作助手
    private MySQLiteOpenHelper openHelper;



    public MyButtonAdapter(Context mContext, List list, int pag, RecyclerView recyclerView) {
        super(mContext, list);
        this.recyclerView = recyclerView;
        this.pag = pag;
        openHelper = new MySQLiteOpenHelper(mContext);
        dbConn = openHelper.dbConn;
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        // 根据 tag 判断数据源类型
        if (pag == 2) {
            // 填充布局
            View view = mInflater.inflate(R.layout.item_type_fragment, parent, false);
            // 设置监听器
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // 获取位置
                    final int position = recyclerView.getChildAdapterPosition(v);
                    //获取 数据
                    TypeBean.DataBean dataBean= (TypeBean.DataBean) list.get(position);
                    // 跳转信息
                    Intent intent = new Intent(mContext, SearchActivity.class);
                    // 填充数据
                    intent.putExtra("data",dataBean.getCateId());
                    intent.putExtra("tag",2);
                    // 开始跳转
                    mContext.startActivity(intent);
                }
            });
            return new MyViewHolderType(view);
        } else {
            // 填充数据
            final View view = mInflater.inflate(R.layout.item_collect_fragment, parent, false);
            // 单击监听事件
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 获取位置
                    int position = recyclerView.getChildAdapterPosition(v);
                    // 获取数据
                    Map<String, String> map = (Map<String, String>) list.get(position);
                    // 跳转信息
                    Intent intent = new Intent(mContext, DetailsActivity.class);
                    // 填充数据
                    intent.putExtra("data", map.get("comId"));
                    //开始跳转
                    mContext.startActivity(intent);
                }
            });
            // 长按监听事件
              view.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            // 获取位置
            final int position = recyclerView.getChildAdapterPosition(v);
            final Map<String, String> map = (Map<String, String>) list.get(position);
            // 弹出 对话框
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle(map.get("title"));
//                    Books gameScore = new Books();
//                    gameScore.setObjectId(map.get("_id"));
//                    gameScore.delete(mContext);
            // 填充布局
            View textView = mInflater.inflate(R.layout.textview_show,null);
            builder.setView(textView)
                    .setNegativeButton("取消", null)
                    .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 删除 数据库文件
                            dbConn.delete("tb_collects", "_id=?", new String[]{map.get("_id")});
                            list.remove(position);
                            // 刷新数据库
                            notifyDataSetChanged();
                        }
                    }).show();

            return true;
        }
    });
    return new MyViewHolderTypeCollect(view);
}
}

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        // 绑定数据
        if (holder instanceof MyViewHolderType) {
            // 获取数据 填充数据
            TypeBean.DataBean dataBean = (TypeBean.DataBean) list.get(position);
            DraweeController controller = (DraweeController) Fresco.newDraweeControllerBuilder()
                    .setUri(Uri.parse(dataBean.getThumb()))
                    .setTapToRetryEnabled(true)
                    .setOldController(((MyViewHolderType) holder).simpleDraweeView_type_item.getController())
                    .build();
            ((MyViewHolderType) holder).simpleDraweeView_type_item.setController(controller);

            ((MyViewHolderType) holder).textView_type_item.setText(dataBean.getTitle());
        } else {
            // 填充数据
            Map<String, String> map = (Map<String, String>) list.get(position);
            ((MyViewHolderTypeCollect) holder).simpleDraweView_collect.setImageURI(Uri.parse(map.get("imageUrl")));
            ((MyViewHolderTypeCollect) holder).textView_collect_title.setText("名称:" + map.get("title"));
            ((MyViewHolderTypeCollect) holder).textView_collect_upDateTime.setText("更新时间:" + map.get("upDateTime"));
            ((MyViewHolderTypeCollect) holder).textView_collect_upDateSection.setText("最新章节" + map.get("upDateSection"));
        }

    }
    // 内部类
    class MyViewHolderType extends RecyclerView.ViewHolder {
        private SimpleDraweeView simpleDraweeView_type_item;
        private TextView textView_type_item;
        // 初始化控件
        public MyViewHolderType(View itemView) {
            super(itemView);
            simpleDraweeView_type_item = (SimpleDraweeView) itemView.findViewById(R.id.simpleDraweeView_type_item);
            textView_type_item = (TextView) itemView.findViewById(R.id.textView_type_item);
        }
    }
    // 内部类
    class MyViewHolderTypeCollect extends RecyclerView.ViewHolder {
        private SimpleDraweeView simpleDraweView_collect;
        private TextView textView_collect_title;
        private TextView textView_collect_upDateTime;
        private TextView textView_collect_upDateSection;
        // 初始化控件
        public MyViewHolderTypeCollect(View itemView) {
            super(itemView);
            simpleDraweView_collect = (SimpleDraweeView) itemView.findViewById(R.id.simpleDraweView_collect);
            textView_collect_title = (TextView) itemView.findViewById(R.id.textView_collect_title);
            textView_collect_upDateTime = (TextView) itemView.findViewById(R.id.textView_collect_upDateTime);
            textView_collect_upDateSection = (TextView) itemView.findViewById(R.id.textView_collect_upDateSection);
        }
    }


}
