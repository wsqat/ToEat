package com.toeat.lesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import java.io.File;
import com.toeat.R;

public class VideoPlayActivity extends AppCompatActivity {
    private VideoView vv_videoview;
    private MediaController mController;
    private Button btn_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        //Intent获取参数
        Intent intent = getIntent();
        final String videoUrl = intent.getStringExtra("videoUrl");

        btn_play = (Button) findViewById(R.id.btn_play);
        vv_videoview = (VideoView) findViewById(R.id.vv_videoview);
        mController = new MediaController(this);

        // Button响应事件，播放本地视频
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Uri videoUri = Uri.parse("http://www.androidbegin.com/tutorial/AndroidCommercial.3gp");
                Uri videoUri = Uri.parse("http://10.0.2.2:8080/ToEatServer/video/transcodeVideo/6.mp4");
                vv_videoview.setVideoURI(videoUri);
                /*File videoFile = new File("/sdcard/DCIM/Camera/test.mp4");
                if (videoFile.exists()) {
                    vv_videoview.setVideoPath(videoFile.getAbsolutePath());
                    vv_videoview.setMediaController(mController);
                    vv_videoview.start();
                    vv_videoview.requestFocus();
                }*/
                //点击播放
                vv_videoview.setMediaController(mController);
                vv_videoview.start();
                vv_videoview.requestFocus();
            }
        });
    }
}
