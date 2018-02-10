package com.jahangiri.alquranaudio;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class PlayActivity extends AppCompatActivity {

    TextView txtVUParaName;
    Button play;
    Button pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        txtVUParaName = findViewById(R.id.txt_vu_para_name);
        play = findViewById(R.id.btn_play_para);
        pause = findViewById(R.id.btn_pause_para);

        Intent incomingIntent = getIntent();
        String paraName = incomingIntent.getStringExtra("txt_vu_para_name");
        txtVUParaName.setText(paraName);

        String url = "http://nooresunnat.com/Audio/Complete%20Quran/Audio%20Quran%20Taqi%20Usmani/Para%20Wise/Para%201.mp3"; // your URL here
        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {

        }
        try {
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
        } catch (IOException e) {

        }

        //click listener on the play button
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //play the para

                mediaPlayer.start();

            }
        });

         pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });


    }
}
