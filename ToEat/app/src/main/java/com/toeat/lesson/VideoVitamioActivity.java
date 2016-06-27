package com.toeat.lesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.toeat.R;

import android.app.Activity;
import android.net.Uri;
import android.widget.Toast;


import java.util.Random;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class VideoVitamioActivity extends Activity {

    private VideoView mVideoView;

    private String[] video = {
            "http://dlqncdn.miaopai.com/stream/MVaux41A4lkuWloBbGUGaQ__.mp4",
            "http://movie.ks.js.cn/flv/other/2014/06/20-2.flv",
            "http://movie.ks.js.cn/flv/other/1_0.mp4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(this);
        setContentView(R.layout.activity_video_vitamio);
//        m_actionBar.hide();
        playfunction();

    }

    void playfunction(){
        String path = "";
        path = video[new Random().nextInt(video.length)];
        if (path == "") {
            Toast.makeText(this, "请填写视频的URL", Toast.LENGTH_LONG).show();
            return;
        }
        mVideoView = (VideoView) findViewById(R.id.surface_view);
        mVideoView.setVideoPath(path);   //设置视频网络地址
//      mVideoView.setVideoURI(Uri.parse(path)); //也可以是本地,也可以是网络地址
        mVideoView.setMediaController(new MediaController(this)); //设置媒体控制器
        mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0);   //设置视频的缩放参数,这里设置为拉伸
        mVideoView.requestFocus();
        //视频播放器的准备,此时播放器已经准备好了,此处可以设置一下播放速度,播放位置等等
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //此处设置播放速度为正常速度1
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
        //当播放完成后,从头开始
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.seekTo(0);   //转到第一帧
                mediaPlayer.start();     //开始播放
            }
        });

    }
}
