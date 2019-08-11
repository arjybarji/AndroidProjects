package com.example.arjun.musicplayer;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
mp = MediaPlayer.create(this,R.raw.fav);
    }

    public void onClick(View v){
        mp.start();
    }

    public void pause(View v){
        mp.pause();
    }
}
