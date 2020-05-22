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

public class Story_Book_List_Page extends AppCompatActivity {

    ListView pdf_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story__book__list__page);


        pdf_list=findViewById(R.id.Video_list_view);



        AssetManager assetManager= getAssets();


        String filelist[]={"BAD-BAD-BUNNY","Lets-Be-Friends-Again","childrens-stories-with-a-moral-by-sergey-nikolov","The-Case-of-the-Missing-Banana"
        ,"Ten-Little-Bunnies", "Never-Lonely-Again", "The-Witches-Daughter"};

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,filelist){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view= super.getView(position, convertView, parent);
                TextView mytext= (TextView) view.findViewById(android.R.id.text1);
                return view;
            }
        };

        pdf_list.setAdapter(adapter);

        pdf_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item= pdf_list.getItemAtPosition(position).toString();
                Intent firstbookintent= new Intent(getApplicationContext(),Read_PDF.class);
                firstbookintent.putExtra("pdffilename",item);
                startActivity(firstbookintent);
            }
        }

        );
    }
}
