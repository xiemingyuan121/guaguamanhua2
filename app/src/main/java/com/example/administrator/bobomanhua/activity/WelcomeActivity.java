package com.example.administrator.bobomanhua.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.administrator.bobomanhua.R;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show);
        // 开启子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 线程睡眠 等待
                    Thread.sleep(2500);
                    // 页面跳转
                    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                    // 开始跳转
                    startActivity(intent);
                    // 关闭页面
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
