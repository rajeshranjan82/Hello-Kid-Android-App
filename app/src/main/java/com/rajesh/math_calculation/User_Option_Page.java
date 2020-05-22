package com.rajesh.math_calculation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class User_Option_Page extends AppCompatActivity {

    ListView user_option;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__option__page);

        user_option=(ListView) findViewById(R.id.user_Option);

        String optionlist[]={"Math Problem","Story Book", "Kids Video", "Math Olympiad Test Paper", "Games", "School Near me"};

        ArrayAdapter<String> optionadapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,optionlist)
        {
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view= super.getView(position, convertView, parent);
                TextView mytext= (TextView) view.findViewById(android.R.id.text1);
                return view;
            }

        };

        user_option.setAdapter(optionadapter);

        user_option.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item= user_option.getItemAtPosition(position).toString();

                if(item.equals("Math Problem"))
                {
                    Intent Math_problem= new Intent(getApplicationContext(),Math_Activity_Page.class);
                    startActivity(Math_problem);
                }

                if(item.equals("Story Book"))
                {
                    Intent Story_Book= new Intent(getApplicationContext(),Story_Book_List_Page.class);
                    startActivity(Story_Book);
                }

                if(item.equals("Kids Video"))
                {
                    Intent Kisd_Video= new Intent(getApplicationContext(),Video_List_Page.class);
                    startActivity(Kisd_Video);
                }

                if(item.equals("Math Olympiad Test Paper"))
                {
                    Intent Kisd_Video= new Intent(getApplicationContext(),Olympiad_Grade_Page.class);
                    startActivity(Kisd_Video);
                }

                if(item.equals("Games"))
                {
                    Intent Kisd_Video= new Intent(getApplicationContext(),Running_Boy_Game_Home_Page.class);
                    startActivity(Kisd_Video);
                }

                if(item.equals("School Near me"))
                {
                    Intent Kisd_Video= new Intent(getApplicationContext(),School_Near_Me.class);
                    startActivity(Kisd_Video);
                }


            }
        });


    }
}
