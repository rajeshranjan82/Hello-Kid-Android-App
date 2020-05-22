package com.rajesh.math_calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.google.android.material.textfield.TextInputEditText;

public class Math_Problem_Page extends AppCompatActivity implements View.OnClickListener {
    TextView FirstValue;
    TextView MathSign;
    TextView SecondValue;
    TextView Result;
    TextInputEditText Answer;
    Button ValidationBtn;
    int firstNumber;
    int secondNumber;
    String oprator;
    int systemGenratedvalue;
    int userEnterValue;
    String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirstValue= (TextView)findViewById(R.id.FirstValue);
        MathSign = (TextView) findViewById(R.id.MathSign);
        SecondValue =(TextView)findViewById(R.id.SecondValue);
        Answer =(TextInputEditText) findViewById(R.id.Answer);
        ValidationBtn = (Button)findViewById(R.id.ValidationBtn);
        Result=(TextView)findViewById(R.id.Result);
        getOpratorAndAge();
        ValidationBtn.setOnClickListener(this);
        randomeNumberGenaratedValue();

    }



    public void randomeNumberGenaratedValue()
    {
        //getage();
        numberGenration numberGenration=new numberGenration();
        firstNumber=numberGenration.numbervalue().get(0);
        secondNumber=numberGenration.numbervalue().get(1);
        if(firstNumber>secondNumber && firstNumber!=0 && secondNumber!=0) {
            FirstValue.setText(String.valueOf(firstNumber));
            SecondValue.setText(String.valueOf(secondNumber));
        }
        else if(firstNumber!=0 && secondNumber!=0)
        {
            FirstValue.setText(String.valueOf(secondNumber));
            SecondValue.setText(String.valueOf(firstNumber));
        }
        Result.setText("");
    }

    public void getOpratorAndAge()
    {
        Intent intent=getIntent();
        oprator=intent.getStringExtra("OprationValue");
        MathSign.setText(oprator);
    }



    public void userAnswerValidation()
    {
        userEnterValue=Integer.parseInt(Answer.getText().toString());
        if (systemGenratedvalue == userEnterValue)
        {
            Toast.makeText(Math_Problem_Page.this,"Your Answer is correct. Try another one",Toast.LENGTH_SHORT).show();
            Answer.setText("");
            randomeNumberGenaratedValue();
        }
        else
        {
            Toast.makeText(Math_Problem_Page.this,"Your Answer is worng. Please try again",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {

        if(oprator.equals("+"))
        {
            systemGenratedvalue=Integer.parseInt(FirstValue.getText().toString())+ Integer.parseInt(SecondValue.getText().toString());
            userAnswerValidation();
        }

        if(oprator.equals("-"))
        {
            systemGenratedvalue=Integer.parseInt(FirstValue.getText().toString())- Integer.parseInt(SecondValue.getText().toString());
            userAnswerValidation();
        }

        if(oprator.equals("*"))
        {
            systemGenratedvalue=Integer.parseInt(FirstValue.getText().toString())*Integer.parseInt(SecondValue.getText().toString());
            userAnswerValidation();
        }

        if(oprator.equals("%"))
        {
            systemGenratedvalue = Integer.parseInt(FirstValue.getText().toString())/Integer.parseInt(SecondValue.getText().toString());
            userAnswerValidation();
        }
    }
}
