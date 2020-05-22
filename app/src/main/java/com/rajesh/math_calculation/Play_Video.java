package com.rajesh.math_calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class Play_Video extends AppCompatActivity {


    String video_List[]={"Four Friends","Moral Stories","Panchtantra Stories","Short Stories","Hind Story","English Stories"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__video);
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        final String videoname=getIntent().getStringExtra("videoname");
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {


                if(videoname.equals("Four Friends")) {

                    String videoId = "zTk7G73kbHo";
                    youTubePlayer.loadVideo(videoId, 0);
                }

                if(videoname.equals("Moral Stories")) {
                    String videoId = "vLuRjSeLGy8";
                    youTubePlayer.loadVideo(videoId, 0);
                }

                if(videoname.equals("Panchtantra Stories")) {
                    String videoId = "yKM2kVKiMZg";
                    youTubePlayer.loadVideo(videoId, 0);
                }

                if(videoname.equals("Short Stories")) {
                    String videoId = "wZq2tyLNPRU";
                    youTubePlayer.loadVideo(videoId, 0);
                }

                if(videoname.equals("Hind Story")) {
                    String videoId = "gu6DgzoiyK0";
                    youTubePlayer.loadVideo(videoId, 0);
                }

                if(videoname.equals("English Stories")) {
                    String videoId = "Uw6EDTR9i_k";
                    youTubePlayer.loadVideo(videoId, 0);
                }
            }
        });

    }

}
