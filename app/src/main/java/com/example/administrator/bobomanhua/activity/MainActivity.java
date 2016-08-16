package com.example.administrator.bobomanhua.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.fragment.MyFragment;
import com.example.administrator.bobomanhua.helper.MyFragmentHelper;
import com.example.administrator.bobomanhua.utils.ButtonUtils;

import java.util.ArrayList;
import java.util.List;




public class MainActivity extends AppCompatActivity {
    // 单选按钮组
    private RadioGroup radioGroup_main;
    // 上线文环境
    private Context context = this;
    // 数据源存放碎片
    private List<Fragment> totalList = new ArrayList<>();
    // 碎片管理者
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化碎片管理者
        manager = getSupportFragmentManager();
        // 调用 初始化 单选按钮组
        initRadioGroup();
    }

/*
* 该方法 用于初始化 单选按钮组
* */
    private void initRadioGroup() {
        // 初始化 按钮组
        radioGroup_main = (RadioGroup) findViewById(R.id.radioGroup_main);
        // 动态创建单选按钮
        final RadioButton[] radioButton = ButtonUtils.getRadioButton(context);
        // 循环 添加 碎片
        for (int i = 0; i < radioButton.length; i++) {
            // 按钮组 添加按钮
            radioGroup_main.addView(radioButton[i]);
            // 创建碎片
            MyFragment fragment = MyFragment.instanceMyFragment(i);
            // 数据源添加 碎片
            totalList.add(fragment);
        }
        // 默认第一个 按钮被点击
        ButtonUtils.setButtonColor(context, 0, true);
        // 默认加载 第一个碎片内容
        MyFragmentHelper.replace(manager, R.id.fragment_container, totalList, 0, 0, 0);
        // 设置 按钮组的 监听事件
        radioGroup_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 先将 所有的 按钮 恢复 原色
                ButtonUtils.setButtonColor(context, 0, false);
                // 遍历 判断 谁被点击
                for (int i = 0; i < radioButton.length; i++) {
                    // 如果被点击
                    if (radioButton[i].getId() == checkedId) {
                        // 加载碎片
                        MyFragmentHelper.switchFragment(manager, R.id.fragment_container, totalList, i, 0, 0);
                       // 按钮变色
                        ButtonUtils.setButtonColor(context, i, true);
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        // 拦截 返回键
        // 创建 对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // 设置 图标
        builder.setIcon(R.drawable.app_icon);
        // 标题
        builder.setTitle("提示:");
        // 内容
        builder.setMessage("确认退出?");
        // 确认按钮
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        // 展示
        builder.show();
    }
//
//    private void initBomb() {
//        BmobConfig config = new BmobConfig.Builder(this)
//                .setApplicationId("9716e68ff62546157d693d1b95a8fae3")
//                .build();
//        Bmob.initialize(config);
//
//    }

}

