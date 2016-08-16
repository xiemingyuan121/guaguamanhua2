package com.example.administrator.bobomanhua.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Administrator on 2016/8/6 0006.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {
    // 标题 数组
    private String  [] arrTitles ;
    // 碎片集合
    private List<Fragment> list ;
    public MyViewPagerAdapter(FragmentManager fm , List<Fragment> list ,String [] arrTitles) {
        super(fm);
        this.arrTitles = arrTitles;
        this.list = list ;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrTitles[position];
    }
}
