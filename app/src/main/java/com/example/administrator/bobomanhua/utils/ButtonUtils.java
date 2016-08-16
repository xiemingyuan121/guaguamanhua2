package com.example.administrator.bobomanhua.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.RadioButton;

import com.example.administrator.bobomanhua.R;


/**
 * Created by Administrator on 2016/8/6 0006.
 */
public class ButtonUtils {
    // 单选按钮 数组
    private static RadioButton[] radioButtons;
    // 图标数组
    private static Drawable[] arrIcons;
    //  图标地址 数组
    private static TypedArray array ;
    // 标题
    private static String[] arrTitles ;
    /*
    * 该方法 用于 初始化 数组内容
    * */
    public static void initButtons(Context context){
        // 添加标题
        arrTitles = context.getResources().getStringArray(R.array.arrButtonTitle);
        // 添加图标
        array = context.getResources().obtainTypedArray(R.array.arrButtonIcons);
        // 添加图标
        arrIcons = new Drawable[array.length()];
        // 添加 按钮个数
        radioButtons = new RadioButton[arrTitles.length];
    }
/*
* 该方法用于 动态 创建 单选按钮
* */
    public static RadioButton[] getRadioButton(Context context) {
            initButtons(context);
        // 循环遍历 标题 数组
        for (int i = 0; i < arrTitles.length; i++) {
            // 获取 图标
            arrIcons[i] = array.getDrawable(i);
            // 创建 按钮
            radioButtons[i] = new RadioButton(context);
            // 去掉 单选 圈
            radioButtons[i].setButtonDrawable(android.R.color.transparent);
            // 去掉 点击 背景
            radioButtons[i].setBackgroundResource(android.R.color.transparent);
            // 设置标题
            radioButtons[i].setText(arrTitles[i]);
            // 设置 文字颜色
            radioButtons[i].setTextColor(Color.GRAY);
            // 设置 图标大小
            arrIcons[i].setBounds(0, 0, 100, 100);
            // 设置 图标位置
            radioButtons[i].setCompoundDrawables(null, arrIcons[i], null, null);
            // 设置 图文间距
            radioButtons[i].setCompoundDrawablePadding(5);
            // 这是文字位置
            radioButtons[i].setGravity(Gravity.CENTER);
            // 设置 图标颜色
            arrIcons[i].setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
            // 获取 控件 宽度
            int widthPixels = context.getResources().getDisplayMetrics().widthPixels;
            // 设置 按钮 宽度
            radioButtons[i].setWidth(widthPixels / radioButtons.length);
        }
        return radioButtons;
    }
/*
* 该方法 用于 改变 图片的 颜色
* */
    public static void setButtonColor(Context context,int position, boolean isSelected) {
    // 判断是否 被选中
        if (isSelected) {
            // 改变 被选中的 按钮的 文字颜色
            radioButtons[position].setTextColor(Color.RED);
            // 改变 被选中的 按钮的 图片颜色
            arrIcons[position].setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        }else{
            // 所有 按钮 恢复 原来色彩
            for (int i = 0; i <radioButtons.length ; i++) {
                radioButtons[i].setTextColor(Color.GRAY);
                arrIcons[i].setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
            }
        }
    }
}
