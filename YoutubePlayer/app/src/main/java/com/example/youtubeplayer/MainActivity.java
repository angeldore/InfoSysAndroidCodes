package com.example.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private Button btnSingle;
    private  Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnSingle = (Button) findViewById(R.id.btnPlayVideo);
        btnNext= (Button) findViewById(R.id.next);
        btnSingle.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent= null;

        switch (v.getId()){
            case R.id.btnPlayVideo:
                intent = new Intent((MainActivity.this), YoutubeActivity.class);
                break;
            case R.id.next:
                intent = new Intent((MainActivity.this) , StandaloneActivity.class);
                break;
            default:
        }

        if(intent!= null){
            startActivity(intent);
        }

    }
}
