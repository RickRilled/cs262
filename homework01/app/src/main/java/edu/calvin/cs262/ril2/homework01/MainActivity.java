//This code creates  simple Calculator that can computer the 4 major operators with floating points.
//Written by Royce Lloyd for CS 262 at Calvin College
//Turned in Sept. 28th, 2018

package edu.calvin.cs262.ril2.homework01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Initialize public variables
    Button buttonAdd, buttonMinus, buttonMulti, buttonDivide;
    TextView result;
    EditText inputFirstValue, inputSecondValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect the variables to their IDs in main_activity.xml
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMulti = findViewById(R.id.buttonMulti);
        buttonDivide = findViewById(R.id.buttonDivide);
        inputFirstValue = findViewById(R.id.inputFirstValue);
        inputSecondValue = findViewById(R.id.inputSecondValue);
        result = findViewById(R.id.result);


        //Use the onClickListener method to determine what happens when a button is pressed
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Take each input value and initialize to a string
                String firstValue = inputFirstValue.getText().toString();
                String secondValue = inputSecondValue.getText().toString();
                //Parse the input string into an integer and complete necessary calculation
                float add = Integer.parseInt(firstValue) + Integer.parseInt(secondValue);
                //Display calculated value as a string in the result TextView
                result.setText(String.valueOf(add));
            }
        });

        //Repeat for each operation
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstValue = inputFirstValue.getText().toString();
                String secondValue = inputSecondValue.getText().toString();
                float minus = Integer.parseInt(firstValue) - Integer.parseInt(secondValue);
                result.setText(String.valueOf(minus));
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstValue = inputFirstValue.getText().toString();
                String secondValue = inputSecondValue.getText().toString();
                float multi = Integer.parseInt(firstValue) * Integer.parseInt(secondValue);
                result.setText(String.valueOf(multi));
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstValue = inputFirstValue.getText().toString();
                String secondValue = inputSecondValue.getText().toString();
                //Catch any divide by zero attempts
                try {
                    float divide = Integer.parseInt(firstValue) / Integer.parseInt(secondValue);
                    result.setText(String.valueOf(divide));
                } catch (ArithmeticException e) {
                    result.setText("Cannot Divide By Zero");
                }
            }
        });

    }

}