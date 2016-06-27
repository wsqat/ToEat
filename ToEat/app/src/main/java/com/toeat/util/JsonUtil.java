package com.toeat.util;

/**
 * 作者：sage_wang
 * 邮箱：786607676@qq.com
 * 时间： 2016/5/12.
 * JsonUtil是工具类
 */
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
public class JsonUtil {
    public JsonUtil(){

    }

    // 将InputStream格式转化为StringBuilder格式
    public static StringBuilder is2sb (InputStream is) {

        String ln = "";
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try{
            while ((ln=br.readLine()) != null){
                sb.append(ln);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return sb;

    }

    // JSON转换成List
    public static void json2list(String strJson) throws JSONException {

        JSONObject jsonObject = new JSONObject(strJson);
        JSONArray jsonUsers = jsonObject.getJSONArray("Users");
        for (int i=0; i<jsonUsers.length(); i++){
            Var.lstId.add(i, jsonUsers.getJSONObject(i).getString("id"));
            Var.lstName.add(i, jsonUsers.getJSONObject(i).getString("name"));
            Var.lstComm.add(i, jsonUsers.getJSONObject(i).getString("phone"));
        }

    }

}
