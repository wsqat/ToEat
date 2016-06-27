package com.toeat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

import com.toeat.lesson.LessonDisplayActivity;
import  com.toeat.user.User;
import  com.toeat.util.HttpUtil;
import  com.toeat.util.HttpCallbackListener;

public class Login3Activity extends AppCompatActivity implements View.OnClickListener{

    private EditText mPhoneNumberEditText;
    private EditText mPassWordEditText;
    private Button mLoginButton;
    //private String originAddress = "http://10.0.2.2:8080/ToEatServer/ClientLogin.action";
    private String originAddress = "http://119.29.189.83:8080/ToEatServer/ClientLogin.action";

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String result = "";
            if ("OK".equals(msg.obj.toString())){
                result = "登录成功，即将跳转至主页!";
            }else if ("Wrong".equals(msg.obj.toString())){
                result = "登录失败，请重试~";
            }else {
                result = msg.obj.toString();
            }
            Log.d("result...",result);
            Toast.makeText(Login3Activity.this, result, Toast.LENGTH_LONG).show();
            if ("OK".equals(msg.obj.toString())){
                Intent intent = new Intent();
                intent.setClass(Login3Activity.this,LessonDisplayActivity.class);
                startActivity(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);
        initView();
        initEvent();
    }

    private void initView() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        mPhoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        mPassWordEditText = (EditText) findViewById(R.id.passwordEditText);
        mLoginButton = (Button) findViewById(R.id.loginButton);
    }

    private void initEvent() {
        mLoginButton.setOnClickListener(this);
    }

    public void login() {
        //取得用户输入的账号和密码
        if (!isInputValid()){
            return;
        }
        HashMap<String, String> params = new HashMap<String, String>();
//        params.put(User.PHONE, mPhoneNumberEditText.getText().toString());
//        params.put(User.PASSWORD, mPassWordEditText.getText().toString());
        System.out.println("mPhoneNumberEditText.getText().toString()..."+mPhoneNumberEditText.getText().toString());
        System.out.println("mPassWordEditText.getText().toString()..."+mPassWordEditText.getText().toString());
        params.put(User.PHONE, mPhoneNumberEditText.getText().toString());
        params.put(User.PASSWORD, mPassWordEditText.getText().toString());
        try {
            String compeletedURL = HttpUtil.getURLWithParams(originAddress, params);
            HttpUtil.sendHttpRequest(compeletedURL, new HttpCallbackListener() {
                @Override
                public void onFinish(String response) {
                    Message message = new Message();
                    message.obj = response;
                    mHandler.sendMessage(message);
                }

                @Override
                public void onError(Exception e) {
                    Message message = new Message();
                    message.obj = e.toString();
                    mHandler.sendMessage(message);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isInputValid() {
        //检查用户输入的合法性，这里暂且默认用户输入合法
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginButton:
                login();
                break;
        }
    }
}
