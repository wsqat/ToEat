package com.toeat.lesson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.MainThread;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.toeat.R;
import com.toeat.lesson.Video;

public class ListViewVideo extends Activity {

    private ListView lv;
    private ArrayList<Video> list;
    //private String HTTPURL = "http://litchiapi.jstv.com/api/GetFeeds?column=3&PageSize=20&pageIndex=1&val=100511D3BE5301280E0992C73A9DEC41";
    //private String HTTPURL = "http://10.0.2.2:8080/ToEatServer/QueryVideos.action";
    private String HTTPURL = "http://119.29.189.83:8080/ToEatServer/";
    private Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    MyAdaper adapter = new MyAdaper(list);
                    lv.setAdapter(adapter);
                    break;

                default:
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_video);
        lv = (ListView) this.findViewById(R.id.lv);
        initData();
    }

    private void initData() {
        list = new ArrayList<Video>();
        OkHttpClient client = new OkHttpClient();
        String json_url = HTTPURL +"QueryVideos.action";
        Request request = new Request.Builder().url(json_url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    JSONObject jo1 = new JSONObject(response.body().string());
                    JSONArray ja = jo1.getJSONArray("Video");
                    //News news = null;
                    Video video =null;
                    for (int i = 0; i < ja.length(); i++) {
                        JSONObject data = ja.getJSONObject(i);
                        String imageUrl = HTTPURL + data.getString("thumbnailurl");
                        String title = data.getString("name");
                        String summary = data.getString("intro");
                        String url = data.getString("url");
                        video = new Video(imageUrl, title, summary, url);
                        list.add(video);
                    }


                    //设置item点击事件,传参数
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            // TODO Auto-generated method stub
                            Video video=(Video)adapterView.getAdapter().getItem(i);
                            Log.d("video.getUrl()...",video.getUrl());
                            String videoUrl = HTTPURL + list.get(i).getUrl();
                            Intent intent = new Intent();
                            //Intent传递参数
                            //  intent.putExtra("videoUrl",videoUrl);
                            intent.putExtra("video",video);
                            //intent.setClass(ListViewVideo.this, VideoPlayActivity.class);
                            intent.setClass(ListViewVideo.this, VideoPlayVitamioActivity.class);
                            ListViewVideo.this.startActivity(intent);
                        }
                    });



                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mHandler.obtainMessage(0).sendToTarget();
            }

            @Override
            public void onFailure(Request arg0, IOException arg1) {

            }
        });
    }
}