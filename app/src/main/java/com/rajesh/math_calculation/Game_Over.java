package com.rajesh.math_calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game_Over extends AppCompatActivity {

    Button gameover, mainmenw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__over);
        gameover=(Button) findViewById(R.id.play_againbtn);
        mainmenw= (Button) findViewById(R.id.main_menubtn);

        gameover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playagain= new Intent(getApplicationContext(),Running_Boy_Game_Home_Page.class);
                startActivity(playagain);

            }
        });


        mainmenw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mainmenupage= new Intent(getApplicationContext(),User_Option_Page.class);
                startActivity(mainmenupage);
            }
        });


    }
}
