package com.rajesh.math_calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Running_Boy_Game_Home_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running__boy__game__home__page);

        Thread thread= new Thread()
        {
            @Override
            public void run() {

                try {

                    sleep(5000);

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {

                    Intent intent=new Intent(Running_Boy_Game_Home_Page.this,Play_Game_Page.class);
                    startActivity(intent);

                }

            }
        };

        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
