package com.toeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.toeat.lesson.LessonDisplayActivity;
import com.toeat.lesson.ListViewVideo;
import com.toeat.lesson.VideoVitamioActivity;
import com.toeat.user.Main2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main_home);
        //注册按钮的内部匿名类实现跳转页面
        Button btnRegister = (Button)findViewById(R.id.main_btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        //登录按钮的内部匿名类实现跳转页面
        Button btnLogin = (Button)findViewById(R.id.main_btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Login3Activity.class);
                startActivity(intent);
            }
        });

        //直接进入按钮的内部匿名类实现跳转页面
        Button btnEnter = (Button)findViewById(R.id.main_btn_enter);
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
//                intent.setClass(MainActivity.this,Login2Activity.class);
//                intent.setClass(MainActivity.this,FragmentMainActivity.class);
                intent.setClass(MainActivity.this,LessonDisplayActivity.class);
//                intent.setClass(MainActivity.this,ListViewVideo.class);
//                intent.setClass(MainActivity.this,VideoVitamioActivity.class);
                startActivity(intent);

            }
        });


    }
}
