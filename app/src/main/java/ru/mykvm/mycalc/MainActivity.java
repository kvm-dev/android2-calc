package ru.mykvm.mycalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    int n1 = 0;
    int n2 = 0;
    String additionFunc = "addition";
    String subtractionFunc = "subtraction";
    String multiplicationFunc = "multiplication";
    String divisionFunc = "division";
    String operation = null;

    private TextView result;
    private EditText calculation;

    Calculate calc = new Calculate();

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

     private void initView(){

       result = (TextView) findViewById(R.id.result);
       calculation =  (EditText) findViewById(R.id.numbers);

        Button b1 = (Button) findViewById(R.id.number1);
        Button b2 = (Button) findViewById(R.id.number2);
        Button b3 = (Button) findViewById(R.id.number3);
        Button b4 = (Button) findViewById(R.id.number4);
        Button b5 = (Button) findViewById(R.id.number5);
        Button b6 = (Button) findViewById(R.id.number6);
        Button b7 = (Button) findViewById(R.id.number7);
        Button b8 = (Button) findViewById(R.id.number8);
        Button b9 = (Button) findViewById(R.id.number9);
        Button b0 = (Button) findViewById(R.id.number10);

        Button refresh = (Button) findViewById(R.id.f1);
        Button equally = (Button) findViewById(R.id.f2);
        Button addition = (Button) findViewById(R.id.f3);
        Button subtraction = (Button) findViewById(R.id.f4);
        Button multiplication = (Button) findViewById(R.id.f5);
        Button division = (Button) findViewById(R.id.f6);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "0");
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Integer.parseInt(calculation.getText().toString());
                operation = additionFunc;
                calculation.setText("");
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Integer.parseInt(calculation.getText().toString());
                operation = subtractionFunc;
                calculation.setText("");
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Integer.parseInt(calculation.getText().toString());
                operation = multiplicationFunc;
                calculation.setText("");
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Integer.parseInt(calculation.getText().toString());
                operation = divisionFunc;
                calculation.setText("");
            }
        });

        equally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n2 = Integer.parseInt(calculation.getText().toString());
                calculation.setText("");
                if(n1!=0 && n2!=0)
                {
                    calc.gainResult(n1,n2,operation);
                    result.setText(String.valueOf(calc.getResult()));

                }

            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = 0;
                n2 = 0;
                calculation.setText("");
                result.setText("Результат");
            }
        });

    }



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calc = (Calculate) savedInstanceState.getSerializable("CALC");
        result.setText(String.valueOf(calc.getResult()));

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("CALC", calc);
    }
}