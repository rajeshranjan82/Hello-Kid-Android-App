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

public class Video_List_Page extends AppCompatActivity {

    ListView videolist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video__list__page);

        videolist= (ListView) findViewById(R.id.Video_list_view);

        AssetManager assetManager= getAssets();


        String video_List[]={"Four Friends","Moral Stories","Panchtantra Stories","Short Stories","Hind Stories","English Stories"};

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,video_List){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view= super.getView(position, convertView, parent);
                TextView mytext= (TextView) view.findViewById(android.R.id.text1);
                return view;
            }
        };

        videolist.setAdapter(adapter);

        videolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item= videolist.getItemAtPosition(position).toString();
                Intent videolist= new Intent(getApplicationContext(),Play_Video.class);
                videolist.putExtra("videoname",item);
                startActivity(videolist);
            }
        }

        );



    }
}
