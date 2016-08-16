package com.example.administrator.bobomanhua.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.bobomanhua.R;


/**
 * Created by Administrator on 2016/8/6 0006.
 */
public class InflaterViewUtils {

/*
* 该方法 用于 动态填充布局
* */
    public static View getViewFormFragment(int tag, LayoutInflater inflater, ViewGroup container) {
        View view = null;
        // 根据 tag 标记 填充布局
        switch (tag) {
            case 0:
                view = inflater.inflate(R.layout.recommend_layout_fragment, container, false);
                break;
            case 1:
                view = inflater.inflate(R.layout.bookshelf_layout_fragment, container, false);
                break;
            case 2:
                view = inflater.inflate(R.layout.search_layout_fragment, container, false);
                break;
            case 3:
                view = inflater.inflate(R.layout.more_layout_fragment, container, false);
                break;
        }
        return view;
    }


}
