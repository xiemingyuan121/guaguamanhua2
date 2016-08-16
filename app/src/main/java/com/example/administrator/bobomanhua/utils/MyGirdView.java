package com.example.administrator.bobomanhua.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Administrator on 2016/8/8 0008.
 */
public class MyGirdView extends GridView {
    public MyGirdView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }
    public MyGirdView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyGirdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
