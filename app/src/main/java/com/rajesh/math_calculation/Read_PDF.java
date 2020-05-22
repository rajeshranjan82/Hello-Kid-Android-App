package com.rajesh.math_calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Read_PDF extends AppCompatActivity {


    PDFView read_book;
    String booknamelist[]={"BAD-BAD-BUNNY","Lets-Be-Friends-Again","childrens-stories-with-a-moral-by-sergey-nikolov","The-Case-of-the-Missing-Banana"
            ,"Ten-Little-Bunnies", "Never-Lonely-Again", "The-Witches-Daughter", "Grade-3-Olympiad", "Grade-4-Olympiad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read__p_d_f);


        read_book= findViewById(R.id.pdfviewbook1);
        String bookname=getIntent().getStringExtra("pdffilename");


        for(int i=0; i<booknamelist.length;i++)
        {
            if(bookname.equals(booknamelist[i]))
            {
                read_book.fromAsset("Story_Book/"+booknamelist[i]+".pdf").load();
            }

        }


    }
}
