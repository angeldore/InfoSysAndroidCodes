package com.example.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener
{

    private String GOOGLE_API_KEY = "AIzaSyBZVbNSsdQZCX_yWFCHPQ_fQMcK4xf9hDk";
    private String YOUTUBE_VIDEO_ID = "EknEIzswvC0";
    private String YOUTUBE_PLAYLIST= "PLS1QulWo1RIbb1cYyzZpLFCKvdYV_yJ-E";
    private Button btnPlayVideo;
    private  Button btnPlayplaylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlayplaylist= (Button) findViewById(R.id.btnPlayList);
        btnPlayVideo= (Button) findViewById(R.id.btnVideo);
        btnPlayVideo.setOnClickListener(this);
         btnPlayplaylist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent= null;
        switch (v.getId()){
            case R.id.btnVideo:
                intent = YouTubeStandalonePlayer.createVideoIntent(this,GOOGLE_API_KEY,YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlayList:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this,GOOGLE_API_KEY,YOUTUBE_PLAYLIST);

                break;
            default:
        }

        if(intent!= null){
            startActivity(intent);
        }
    }
}
