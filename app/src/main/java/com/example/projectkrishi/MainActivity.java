package com.example.projectkrishi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Random;

public class MainActivity extends YouTubeBaseActivity {
String[] videos  = new String[]{"IEF6mw7eK4s", "8CEJoCr_9UI", "344u6uK9qeQ" ,"3-nM3yNi3wg", "VOLKJJvfAbg", "nB7nGcW9TyE"};
    String api_key = "AIzaSyA0B2bA216L1ZsAbrDOIT_Q7MB_3fiJRUA";
    YouTubePlayerView youTubePlayerView;
    Random random = new Random();
    private int video = random.nextInt(6);

    @Override
    protected void
    onCreate(@Nullable Bundle savedInstanceState)
    {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView shuffleBtn = findViewById(R.id.shuffleBtn);
TextView NextScreen = findViewById(R.id.NextScreen);
NextScreen.setOnClickListener(view -> {
    Intent intent = new Intent(MainActivity.this,UserScreen.class);
    startActivity(intent);
});
        // Get reference to the view of Video player
         youTubePlayerView = findViewById(R.id.ytPlayer);

        YouTubePlayer.OnInitializedListener listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(videos[video]);
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(),"Initialization Failure", Toast.LENGTH_SHORT).show();
            }
        };
        youTubePlayerView.initialize("AIzaSyA0B2bA216L1ZsAbrDOIT_Q7MB_3fiJRUA",listener);
        Toast.makeText(getApplicationContext(),"Playing a youtube video enjoy...",Toast.LENGTH_LONG).show();
        int id = random.nextInt(6);

        YouTubePlayer.OnInitializedListener listener1 = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(videos[id]);
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(),"Initialization Failure", Toast.LENGTH_SHORT).show();
            }
        };
shuffleBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        youTubePlayerView.initialize("AIzaSyA0B2bA216L1ZsAbrDOIT_Q7MB_3fiJRUA",listener1);
    }
});

    }



}
