package com.toeat.common;

/**
 * 作者：sage_wang
 * 邮箱：786607676@qq.com
 * 时间： 2016/5/12.
 * CommThread是通信线程
 */

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import com.toeat.user.Main2Activity;
import com.toeat.util.JsonUtil;
import com.toeat.util.Var;

public class CommThread extends Thread{

    // 消息变量
    private Message msg;
    private Bundle bdl;

    // 构造函数
    public void run(){

        InputStream resIS;
        StringBuilder resSB;
        String resStr;

        resIS = getIS(Var.strURL);
        if (resIS == null)
        {
            return;
        }
        else
        {
            resSB = JsonUtil.is2sb(resIS);
            resStr = resSB.toString();
            try{
                JsonUtil.json2list(resStr);
                sendMessage(Var.msg_connect,"");
            }catch (Exception e){
                e.printStackTrace();
                sendMessage(Var.msg_error,e.toString());
            }
        }

    }

    // 通过GET方法获取信息
    public InputStream getIS (String url){

        InputStream is=null;

        try{
            // 取得默认HttpClient实例
            HttpClient hc = new DefaultHttpClient();
            // 连接到服务器
            HttpResponse hr = hc.execute(new HttpGet(url));
            // 获取数据内容
            is = hr.getEntity().getContent();
        }catch (Exception e){
            e.printStackTrace();
            sendMessage(Var.msg_error,e.toString());
        }

        return is;

    }

    // 发送消息(用于更新UI)
    public void sendMessage(int x, String s){

        msg = new Message();
        bdl = new Bundle();
        bdl.putString("1",s);
        msg.what = x;
        msg.setData(bdl);
        Main2Activity.mainHandler.sendMessage(msg);

    }

}
