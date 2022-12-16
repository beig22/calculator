package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView resultTextView;

    int operand;
    String operation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.textResult);
        resultTextView.setText("0");
    }

    public void numberClicked(View view) {
        String tag = (String) view.getTag();
        int number = Integer.parseInt(tag);

        operand = (operand * 10) + number;

        resultTextView.setText(String.valueOf(operand));
    }


    public void operatorClicked(View view) {
        operation = view.getTag().toString();
        resultTextView.setText(String.valueOf(performCalculation()));
    }

    public void clear(View view) {
        operand = 0;
        result = 0;
        operation = "";
        resultTextView.setText("0");
    }

    public void equalClicked(View view) {
        resultTextView.setText(String.valueOf(performCalculation()));
    }

    private int performCalculation() {

        if (operation.equals("+")) {
            result = result + operand;
        } else if (operation.equals("-")) {
            if (result == 0) {
                result = operand;
            } else {
                result = result - operand;
            }
        } else if (operation.equals("*")) {
            result = result * operand;
        } else if (operation.equals("/")) {
            if (result != 0 && operand != 0) {
                result = result / operand;
            } else {
                result = operand + result;
            }
        }

        operand = 0;

        return result;
    }
}
