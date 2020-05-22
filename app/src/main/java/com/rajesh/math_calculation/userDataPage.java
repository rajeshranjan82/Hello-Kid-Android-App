package com.rajesh.math_calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class userDataPage extends AppCompatActivity implements View.OnClickListener {

    EditText userName;
    EditText userAge;
    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_page);
        userName= (EditText)findViewById(R.id.userNameValue);
        userAge =(EditText)findViewById(R.id.userAgeValue);
        startButton= (Button) findViewById(R.id.Startbtn);
        startButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String getNameValue=userName.getText().toString();
        String getAgeValue=userAge.getText().toString();
        Intent intent = new Intent(userDataPage.this, User_Option_Page.class);
        intent.putExtra("nameValue", getNameValue);
        intent.putExtra("ageValue", getAgeValue);
        startActivityForResult(intent, 1);

    }
}
