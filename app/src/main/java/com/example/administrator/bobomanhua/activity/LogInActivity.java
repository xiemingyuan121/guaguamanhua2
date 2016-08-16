package com.example.administrator.bobomanhua.activity;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.administrator.bobomanhua.R;
import com.example.administrator.bobomanhua.helper.SwipBackActivityHelper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogInActivity extends SwipBackActivityHelper {
    // 文本输入框
    private EditText editText_word;
    // 文本 输入框
    private EditText editText_detail;
    // 文本提示框
    private TextInputLayout textInput_word;
    // 文本提示框
    private TextInputLayout textInput_detail;
    // 是否满足
    private boolean isUserTrue = false;
    // 是否满足
    private boolean isPassWordTrue = false;
    // 上下文环境
    private Context context = this;
    // toolbar
    private Toolbar toolBar_LogIn;
    // 文本输入框
    private EditText editText_yanZhengMa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        initView();// 调用初始化 控件 的方法
    }
    /*
    * 该方法 用于 初始化 控件
    * */
    private void initView() {
        // 初始化文本输入框
        editText_word = (EditText) findViewById(R.id.editText_dialog_word);
        // 初始化文本输入框
        editText_detail = (EditText) findViewById(R.id.editText_dialog_detail);
       // 初始化文本输入框的提示
        textInput_word = (TextInputLayout) findViewById(R.id.textInputLayout_word);
        // 初始化文本输入框的提示
        textInput_detail = (TextInputLayout) findViewById(R.id.textInputLayout_detail);
        // 初始化 toolbar
        toolBar_LogIn = (Toolbar) findViewById(R.id.toolBar_LogIn);
        // 初始化文本输入框
        editText_yanZhengMa = (EditText) findViewById(R.id.editText_yanZhengMa);
        // toolbar 设置 图标
        toolBar_LogIn.setNavigationIcon(R.mipmap.back);
        // 设置 标题
        toolBar_LogIn.setTitle("Login");
        // 设置 图标点击事件
        toolBar_LogIn.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 销毁界面
                finish();
            }
        });
        // 文本输入框 监听器
        editText_word.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 如果满足 正则
                if(isUser(editText_word.getText().toString())){
                    // 不提示文本提示框
                    textInput_word.setErrorEnabled(false);
                    textInput_word.setError("");
                    isUserTrue = true;
                }else{
                    // 不满足 提示文本显示错误
                    textInput_word.setErrorEnabled(true);
                    textInput_word.setError("输入有错误，单词中包含有不合法字符");
                    isUserTrue = false ;
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        // 文本提示框
        editText_detail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 文本满足正则
                if(isPassWord(editText_detail.getText().toString())){
                    // 不显示 提示框
                    textInput_detail.setErrorEnabled(false);
                    textInput_detail.setError("");
                    isPassWordTrue = true ;
                }else{
                    // 不满足 显示文本提示框
                    textInput_detail.setErrorEnabled(true);
                    textInput_detail.setError("输入有错误，注释中包含有不合法字符");
                    isPassWordTrue = false ;
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    // 按钮点击监听
    public void run(View view) {
        switch (view.getId()){
            // 登录按钮
            case R.id.button_login:
                // 判断是否 填写正确
                if(isPassWordTrue&&isUserTrue){
                    // 正确 ...
                    Toast.makeText(context,"用户名:"+editText_word.getText()+""+"/r/n"+"密码:"+editText_detail.getText()+"",Toast.LENGTH_SHORT).show();
                }else{
                    // 不正确 ...
                    Toast.makeText(context,"填写项有错误，请重新填写！",Toast.LENGTH_SHORT).show();
                }
                break ;
            // 验证码按钮
            case R.id.button_yanZhengMa:

                break ;
        }
    }

    // 正则表达式判断方法
    public boolean isUser(String str){
        String regexp = "^[A-Za-z0-9]{6,16}$|^[\\u4E00-\\u9FA5]{2,8}$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    // 正则表达式判断方法
    public boolean isPassWord(String str) {
        String regexp = "^[\\@A-Za-z0-9\\!\\#\\$\\%\\^\\&\\*\\.\\~]{6,22}$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
