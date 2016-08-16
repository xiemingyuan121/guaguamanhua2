package com.example.administrator.bobomanhua.helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * Created by Administrator on 2016/7/21 0021.
 * 动将动态生成 的碎片 放置在 布局文件中 ;
 */

public class MyFragmentHelper {
    public  static void replace(FragmentManager manager, int layoutId , List<Fragment> list , int position , int enter , int exit ){
            //  开启事务
        FragmentTransaction transaction = manager.beginTransaction();
        // 判断有没有动画效果
        if(enter!=0&&exit!=0){

            transaction.setCustomAnimations(enter,exit);
        }

        // replace 的方式 去 添加 碎片
        transaction.replace(layoutId,list.get(position));
        // 关闭事物
        transaction.commit();
    }

    public static void switchFragment(FragmentManager manager, int layoutId , List<Fragment> list , int position , int enter , int exit){
        FragmentTransaction transaction = manager.beginTransaction();
        // 先 判断 有没有正在 显示 的 碎片
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).isVisible()){
                // 如果有 先隐藏
                transaction.hide(list.get(i));
            }
        }
        // 判断有没有动画
        if(enter!=0&&exit!=0){
            // 设置动画
            transaction.setCustomAnimations(enter,exit);
        }
        //  获得要添加的碎片
        Fragment toFragment = list.get(position);
        // 判断是否已经生成过
        if(toFragment.isAdded()){
            // 如果有 直接显示
            transaction.show(toFragment);
        }else{
            // 如果没有 直接创建
            transaction.add(layoutId,toFragment);
        }
        // 关闭事物
        transaction.commit();
    }
}
