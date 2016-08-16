package com.example.administrator.bobomanhua.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.activity.DetailsActivity;
import com.example.administrator.bobomanhua.bean.RecommendBean;
import com.example.administrator.bobomanhua.bean.SearchBean;
import com.example.administrator.bobomanhua.bean.SearchTwoBean;
import com.example.administrator.bobomanhua.bean.SplendidBean;
import com.example.administrator.bobomanhua.bean.UpDateBean;
import com.example.administrator.bobomanhua.helper.RecyclerViewAdapterHelper;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.squareup.okhttp.internal.http.HeaderParser;

import java.util.List;

/**
 * Created by Administrator on 2016/8/6 0006.
 */
public class MyChildAdapter extends RecyclerViewAdapterHelper {
    // 数据类型 标记
    private int tag;
    private RecyclerView recyclerView;
    // 接口对象
    private onClickListener listener ;
    // 初始化 接口对象
    public void setOnClickListener(onClickListener listener){
        this.listener = listener ;
    }
    // 自定义接口
   public  interface  onClickListener{
       void onClick(int position);
   }

    public MyChildAdapter(Context mContext, List list, int tag, RecyclerView recyclerView) {
        super(mContext, list);
        this.tag = tag;
        this.recyclerView = recyclerView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateMyViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        // 根据 数据源类型 做填充布局
        switch (tag) {
            case 1:
                view = mInflater.inflate(R.layout.item_recyclerview_fragment, parent, false);
                break;
            case 2:
                view = mInflater.inflate(R.layout.item_recyclerview_fragment, parent, false);
                break;
            case 3:
                view = mInflater.inflate(R.layout.item_adapter_updatefragment, parent, false);
                break;
            case 4:
                view = mInflater.inflate(R.layout.item_adapter_updatefragment, parent, false);
                break;
            case 5:
                view = mInflater.inflate(R.layout.item_imageshow_recyclerview, parent, false);
                break;
            case 6:
                view = mInflater.inflate(R.layout.item_adapter_updatefragment, parent, false);
                break ;
        }
        // 设置监听 事件
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转
                if (tag != 5) {
                    // 获取位置
                    int position = recyclerView.getChildAdapterPosition(v);
                    // 跳转信息
                    Intent intent = new Intent(mContext, DetailsActivity.class);
                    // 数据库 填充数据
                    switch (tag) {
                        case 1:
                            RecommendBean.DataBean recBean = (RecommendBean.DataBean) list.get(position);
                            intent.putExtra("data", recBean.getComicId() + "");
                            break;
                        case 2:
                            SplendidBean.DataBean splBean = (SplendidBean.DataBean) list.get(position);
                            intent.putExtra("data", splBean.getComicId() + "");
                            break;
                        case 3:
                            UpDateBean.DataBean updBean = (UpDateBean.DataBean) list.get(position);
                            intent.putExtra("data", updBean.getComicId() + "");
                            break;
                        case 4:
                            SearchBean.DataBean seaBean = (SearchBean.DataBean) list.get(position);
                            intent.putExtra("data", seaBean.getComicId() + "");
                            break;
                        case 6:
                            SearchTwoBean.DataBean seaTBean = (SearchTwoBean.DataBean) list.get(position);
                            intent.putExtra("data", seaTBean.getComicId() + "");
                            break ;
                    }
                    // 开始跳转
                    mContext.startActivity(intent);
                }else{
                    //获取位置
                   int position =  recyclerView.getChildAdapterPosition(v);
                    //执行 自定义 接口
                    listener.onClick(position);
                }
            }
        });
        // 初始化 内部类对象
        switch (tag) {
            case 1:
                return new MyViewHolderRecommend(view);
            case 2:
                return new MyViewHolderSplendid(view);
            case 3:
                return new MyViewHolderUpdate(view);
            case 4:
                return new MyViewHolderUpdate(view);
            case 5:
                return new MyViewHolderImageShow(view);
            case 6:
                return new MyViewHolderUpdate(view);
        }
        return null;
    }

    @Override
    public void onBindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        // 根据数据源类型 填充 数据
        if (holder instanceof MyViewHolderRecommend) {
            RecommendBean.DataBean recommendBean = (RecommendBean.DataBean) list.get(position);
            ((MyViewHolderRecommend) holder).textView_title.setText(recommendBean.getTitle());
            ((MyViewHolderRecommend) holder).textView_number.setText(recommendBean.getLastCharpter().getTitle());
            ((MyViewHolderRecommend) holder).simpleDraweeView_image.setImageURI(Uri.parse(recommendBean.getThumb()));
        } else if (holder instanceof MyViewHolderSplendid) {
            SplendidBean.DataBean splendidBean = (SplendidBean.DataBean) list.get(position);
            ((MyViewHolderSplendid) holder).textView_title.setText(splendidBean.getTitle());
            ((MyViewHolderSplendid) holder).textView_number.setText(splendidBean.getLastCharpter().getTitle());
            ((MyViewHolderSplendid) holder).simpleDraweeView_image.setImageURI(Uri.parse(splendidBean.getThumb()));
        } else if (holder instanceof MyViewHolderImageShow) {
            String url = (String) list.get(position);

            DraweeController controller = (DraweeController) Fresco.newDraweeControllerBuilder()
                    .setOldController(((MyViewHolderImageShow) holder).simpleDraweeView_imageShow.getController())
                    .setTapToRetryEnabled(true)
                    .setUri(Uri.parse(url))
                    .build();
            GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(mContext.getResources())
                    .setProgressBarImage(new ProgressBarDrawable()).build();
            ((MyViewHolderImageShow) holder).simpleDraweeView_imageShow.setHierarchy(hierarchy);
            ((MyViewHolderImageShow) holder).simpleDraweeView_imageShow.setController(controller);


        } else {

            if (tag == 3) {
                UpDateBean.DataBean upBean = (UpDateBean.DataBean) list.get(position);
                ((MyViewHolderUpdate) holder).textView_updateFragment_titles.setText("标题:" + upBean.getTitle());
                ((MyViewHolderUpdate) holder).textView_updateFragment_author.setText("作者:" + upBean.getAuthorName());
//               ((MyViewHolderUpdate)holder).textView_updateFragment_newest.setText("最新章节:"+upBean.getLastCharpter().getTitle()+"");
                ((MyViewHolderUpdate) holder).textView_updateFragment_type.setText("类型:" + upBean.getComicType());
                ((MyViewHolderUpdate) holder).simpleDraweeView_updateFragment_show.setImageURI(Uri.parse(upBean.getThumb()));
            } else if (tag == 6){
                  SearchTwoBean.DataBean  searchTwoBean = (SearchTwoBean.DataBean) list.get(position);
                ((MyViewHolderUpdate) holder).textView_updateFragment_titles.setText("标题:" + searchTwoBean.getTitle());
                ((MyViewHolderUpdate) holder).textView_updateFragment_author.setText("作者:" + searchTwoBean.getAuthorName());
//                ((MyViewHolderUpdate)holder).textView_updateFragment_newest.setText("最新章节:"+seaBean.getLastCharpter().getTitle());
                ((MyViewHolderUpdate) holder).textView_updateFragment_type.setText("类型:" + searchTwoBean.getComicType());
                ((MyViewHolderUpdate) holder).simpleDraweeView_updateFragment_show.setImageURI(Uri.parse(searchTwoBean.getThumb()));
            }else {
                SearchBean.DataBean seaBean = (SearchBean.DataBean) list.get(position);
                ((MyViewHolderUpdate) holder).textView_updateFragment_titles.setText("标题:" + seaBean.getTitle());
                ((MyViewHolderUpdate) holder).textView_updateFragment_author.setText("作者:" + seaBean.getAuthorName());
//                ((MyViewHolderUpdate)holder).textView_updateFragment_newest.setText("最新章节:"+seaBean.getLastCharpter().getTitle());
                ((MyViewHolderUpdate) holder).textView_updateFragment_type.setText("类型:" + seaBean.getComicType());
                ((MyViewHolderUpdate) holder).simpleDraweeView_updateFragment_show.setImageURI(Uri.parse(seaBean.getThumb()));
            }

        }
    }

    // 内部类
    class MyViewHolderHot extends RecyclerView.ViewHolder {
        private SimpleDraweeView simpleDraweeView_image;
        private TextView textView_title;
        private TextView textView_number;
        // 初始化 控件
        public MyViewHolderHot(View itemView) {
            super(itemView);
            simpleDraweeView_image = (SimpleDraweeView) itemView.findViewById(R.id.simpleDraweeView_image);
            textView_title = (TextView) itemView.findViewById(R.id.textView_title);
            textView_number = (TextView) itemView.findViewById(R.id.textView_number);
        }
    }
    // 内部类
    class MyViewHolderRecommend extends RecyclerView.ViewHolder {
        private SimpleDraweeView simpleDraweeView_image;
        private TextView textView_title;
        private TextView textView_number;
        // 初始化 控件
        public MyViewHolderRecommend(View itemView) {
            super(itemView);
            simpleDraweeView_image = (SimpleDraweeView) itemView.findViewById(R.id.simpleDraweeView_image);
            textView_title = (TextView) itemView.findViewById(R.id.textView_title);
            textView_number = (TextView) itemView.findViewById(R.id.textView_number);
        }
    }
    // 内部类
    class MyViewHolderSplendid extends RecyclerView.ViewHolder {

        private SimpleDraweeView simpleDraweeView_image;
        private TextView textView_title;
        private TextView textView_number;
        // 初始化控件
        public MyViewHolderSplendid(View itemView) {
            super(itemView);
            simpleDraweeView_image = (SimpleDraweeView) itemView.findViewById(R.id.simpleDraweeView_image);
            textView_title = (TextView) itemView.findViewById(R.id.textView_title);
            textView_number = (TextView) itemView.findViewById(R.id.textView_number);
        }
    }
    // 内部类
    class MyViewHolderUpdate extends RecyclerView.ViewHolder {
        private SimpleDraweeView simpleDraweeView_updateFragment_show;
        private TextView textView_updateFragment_titles;
        private TextView textView_updateFragment_author;
        private TextView textView_updateFragment_type;
        private TextView textView_updateFragment_newest;
        // 初始化控件
        public MyViewHolderUpdate(View itemView) {
            super(itemView);
            simpleDraweeView_updateFragment_show = (SimpleDraweeView) itemView.findViewById(R.id.simpleDraweeView_updateFragment_show);
            textView_updateFragment_titles = (TextView) itemView.findViewById(R.id.textView_updateFragment_titles);
            textView_updateFragment_author = (TextView) itemView.findViewById(R.id.textView_updateFragment_author);
            textView_updateFragment_type = (TextView) itemView.findViewById(R.id.textView_updateFragment_type);
            textView_updateFragment_newest = (TextView) itemView.findViewById(R.id.textView_updateFragment_newest);
        }
    }
    // 内部类
    class MyViewHolderImageShow extends RecyclerView.ViewHolder {
        private SimpleDraweeView simpleDraweeView_imageShow;
        // 初始化控件
        public MyViewHolderImageShow(View itemView) {
            super(itemView);
            simpleDraweeView_imageShow = (SimpleDraweeView) itemView.findViewById(R.id.simpleDraweeView_image_imageShow_recyclerView);
        }
    }
}
