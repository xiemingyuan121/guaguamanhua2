package com.example.administrator.bobomanhua.helper;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;


import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.okhttp.OkHttpClient;




/**
 * Created by Administrator on 2016/8/6 0006.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttp();// 该方法用于 初始化 okhttp
        initFresco(); // 该方法用于 初始化 fresco
        initBmob(); // 该方法用于 初始化 bmob

    }

    private void initBmob() {
//       Bmob.initialize(this, "9e2c99b8497028b855112dda79063f23");
    }


    private void initFresco() {
        // 设置单例
        Fresco.initialize(getApplicationContext());
    }


    private void initOkHttp() {
        // 设置单例
        OkHttpClient okHttpClient = OkHttpClientHelper.getOkHttpSingletonInstance();
    }
}
