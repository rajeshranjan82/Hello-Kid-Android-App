package com.rajesh.math_calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Read_Olympiad_Paper extends AppCompatActivity {

    PDFView read_oly_paper;

    String olypaperlist[]={"Grade-3-Olympiad", "Grade-4-Olympiad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read__olympiad__paper);


        read_oly_paper= findViewById(R.id.pdfolyview);
        String papername=getIntent().getStringExtra("olypdf");


        for(int i=0; i<olypaperlist.length;i++)
        {
            if(papername.equals(olypaperlist[i]))
            {
                read_oly_paper.fromAsset("Olympiad/"+olypaperlist[i]+".pdf").load();
            }

        }
    }
}
