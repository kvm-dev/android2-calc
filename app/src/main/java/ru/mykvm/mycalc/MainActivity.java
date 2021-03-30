package ru.mykvm.mycalc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    static String key = "theme";
    int number1 = 0;
    int number2 = 0;
    final static String additionFunc = "addition";
    final static String subtractionFunc = "subtraction";
    final static String multiplicationFunc = "multiplication";
    final static String divisionFunc = "division";
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
        String theme;
        Intent settings= getIntent();
        Bundle b = settings.getExtras();

        if(b!=null) {
            theme = (String) b.get(key);
                if (theme.equals("default")) {
                setTheme(R.style.Default);
                super.setContentView(R.layout.activity_main);

            } else if (theme.equals("alter")) {
                setTheme(R.style.ButtonChangeTheme);
                super.setContentView(R.layout.activity_main);
            }
        }
    }
     private void initView(){
        result = findViewById(R.id.result);
        calculation =  findViewById(R.id.numbers);
        Button button1 = findViewById(R.id.number1);
        Button button2 = findViewById(R.id.number2);
        Button button3 = findViewById(R.id.number3);
        Button button4 = findViewById(R.id.number4);
        Button button5 = findViewById(R.id.number5);
        Button button6 = findViewById(R.id.number6);
        Button button7 = findViewById(R.id.number7);
        Button button8 =  findViewById(R.id.number8);
        Button button9 =  findViewById(R.id.number9);
        Button button0 = findViewById(R.id.number0);
        Button refresh = findViewById(R.id.refresh);
        Button equally = findViewById(R.id.equally);
        Button addition = findViewById(R.id.addition);
        Button subtraction = findViewById(R.id.subtraction);
        Button multiplication = findViewById(R.id.multiplication);
        Button division = findViewById(R.id.division);

         FloatingActionButton fab = findViewById(R.id.fab);
         fab.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
               Intent myIntent = new Intent(MainActivity.this.getApplicationContext(), SettingsActivity.class);
                 MainActivity.this.startActivity(myIntent);
                 finish();
             }
         });
         button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "1");
            }
        });

         button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "3");
            }
        });

         button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "4");
            }
        });

         button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "5");
            }
        });

         button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "6");
            }
        });

         button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "7");
            }
        });

         button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "8");
            }
        });

         button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "9");
            }
        });

         button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText(calculation.getText() + "0");
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calculation.length()>0) {
                    number1 = Integer.parseInt(calculation.getText().toString());
                    operation = additionFunc;
                    calculation.setText("");
                }
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calculation.length()>0) {
                    number1 = Integer.parseInt(calculation.getText().toString());
                    operation = subtractionFunc;
                    calculation.setText("");
                }
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calculation.length()>0) {
                    number1 = Integer.parseInt(calculation.getText().toString());
                    operation = multiplicationFunc;
                    calculation.setText("");
                }
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(calculation.length()>0) {
                    number1 = Integer.parseInt(calculation.getText().toString());
                    operation = divisionFunc;
                    calculation.setText("");
                }
            }
        });

        equally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(calculation.length()>0)
                {
                    number2 = Integer.parseInt(calculation.getText().toString());
                    calculation.setText("");
                    calc.gainResult(number1,number2,operation);
                    result.setText(String.valueOf(calc.getResult()));
                }
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1 = 0;
                number2 = 0;
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