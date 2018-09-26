package edu.calvin.cs262.ril2.homework01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonMinus, buttonMulti, buttonDivide;
    TextView result;
    EditText inputFirstValue, inputSecondValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMulti = findViewById(R.id.buttonMulti);
        buttonDivide = findViewById(R.id.buttonDivide);
        inputFirstValue = findViewById(R.id.inputFirstValue);
        inputSecondValue = findViewById(R.id.inputSecondValue);
        result = findViewById(R.id.result);

        //buttonAdd.setOnClickListener(this);
        //buttonMinus.setOnClickListener(this);
        //buttonMulti.setOnClickListener(this);
        //buttonDivide.setOnClickListener(this);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstValue = inputFirstValue.getText().toString();
                String secondValue = inputSecondValue.getText().toString();
                float add = Integer.parseInt(firstValue) + Integer.parseInt(secondValue);
                result.setText(String.valueOf(add));
            }
        });

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



