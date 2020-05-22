package com.rajesh.math_calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class Play_Game_Page extends AppCompatActivity {

    private JumpingBoyView gameview;
    private Handler handler =new Handler();
    private final static long Interval=30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play__game__page);

        gameview= new JumpingBoyView(this);
        setContentView(gameview);

        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameview.invalidate();
                    }
                });

            }
        },0, Interval);
    }
}
