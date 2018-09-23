package edu.calvin.cs262.ril2.homework01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonAdd;
    private Button buttonMinus;
    private Button buttonMulti;
    private Button buttonDivide;
    private TextView result;
    private EditText inputFirstValue, inputSecondValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMulti = findViewById(R.id.buttonMulti);
        buttonDivide = findViewById(R.id.buttonDivide);
        inputFirstValue = findViewById(R.id.inputFirstValue);
        inputSecondValue = findViewById(R.id.inputSecondValue);
        result = findViewById(R.id.result);

        buttonAdd.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMulti.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String firstValue = inputFirstValue.getText().toString();
        String secondValue = inputSecondValue.getText().toString();
        switch(v.getId()){
            case R.id.buttonAdd:
                int add = Integer.parseInt(firstValue) + Integer.parseInt(secondValue);
                result.setText(String.valueOf(add));
                break;
            case R.id.buttonMinus:
                int minus = Integer.parseInt(firstValue) - Integer.parseInt(secondValue);
                result.setText(String.valueOf(minus));
                break;
            case R.id.buttonMulti:
                int multi = Integer.parseInt(firstValue) * Integer.parseInt(secondValue);
                result.setText(String.valueOf(multi));
                break;
            case R.id.buttonDivide:
                try{
                    int divide = Integer.parseInt(firstValue) / Integer.parseInt(secondValue);
                    result.setText(String.valueOf(divide));
                }catch (Exception e) {
                    result.setText("Cannot Divide");
                }
                break;
        }

    }
}
