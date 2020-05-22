package com.rajesh.math_calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Math_Activity_Page extends AppCompatActivity implements View.OnClickListener {
    Button AdditionButton;
    Button SubtractionButton;
    Button MultiplicationButton;
    Button DivisionButton;
    TextView OptionMessage;
    String NameData;
    String AgeData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        AdditionButton=(Button) findViewById(R.id.Additionbtn);
        SubtractionButton =(Button) findViewById(R.id.Subtractionbtn);
        MultiplicationButton =(Button) findViewById(R.id.Multiplicationbtn);
        DivisionButton =(Button) findViewById(R.id.Divisionbtn);
        OptionMessage= (TextView) findViewById(R.id.Option);


        AdditionButton.setOnClickListener(this);
        SubtractionButton.setOnClickListener(this);
        MultiplicationButton.setOnClickListener(this);
        DivisionButton.setOnClickListener(this);

        getname();
        getage();
    }

    public void getname()
    {
        Intent nameintent=getIntent();
        NameData=nameintent.getStringExtra("nameValue");
        OptionMessage.setText("Select Your Option");
    }

    public void getage()
    {
        Intent nameintent=getIntent();
        AgeData=nameintent.getStringExtra("ageValue");
    }

    @Override
    public void onClick(View view) {

        String Value=null;

        if(view.getId()==R.id.Additionbtn)
        {
            Value="+";

        }
        if(view.getId()==R.id.Subtractionbtn)
        {
            Value="-";
        }
        if(view.getId()==R.id.Multiplicationbtn)
        {
            Value="*";
        }
        if(view.getId()==R.id.Divisionbtn)
        {
            Value="%";
        }
        getage();
        Intent intent= new Intent(Math_Activity_Page.this, Math_Problem_Page.class);
        intent.putExtra("OprationValue", Value);
        intent.putExtra("ageValue",AgeData);
        startActivityForResult(intent,1);

    }

}
