package com.rajesh.math_calculation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Olympiad_Grade_Page extends AppCompatActivity {

    ListView OlympiadPaper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olympiad__grade__page);

        OlympiadPaper=(ListView) findViewById(R.id.Olympiad_Paper);

        AssetManager assetManager= getAssets();


        String filelist[]={"Grade-3-Olympiad","Grade-4-Olympiad"};

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,filelist){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view= super.getView(position, convertView, parent);
                TextView mytext= (TextView) view.findViewById(android.R.id.text1);
                return view;
            }
        };

        OlympiadPaper.setAdapter(adapter);

        OlympiadPaper.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String item= OlympiadPaper.getItemAtPosition(position).toString();
             Intent olyBook= new Intent(getApplicationContext(),Read_Olympiad_Paper.class);
             olyBook.putExtra("olypdf",item);
             startActivity(olyBook);
                                            }
                                        }

        );


    }
}
