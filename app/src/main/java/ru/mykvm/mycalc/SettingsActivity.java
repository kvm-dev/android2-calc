package ru.mykvm.mycalc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SettingsActivity extends AppCompatActivity {

    String theme = "default";
    static String key = "theme";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ToggleButton backToCalc = findViewById(R.id.toggleButton);
        backToCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(theme.equals("default"))
                {
                    theme="alter";
                }
                else if(theme.equals("alter")) {
                    theme="default";
                }
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToggleButton changeTheme = findViewById(R.id.toggleButton);
                Intent myIntent = new Intent(SettingsActivity.this.getApplicationContext(), MainActivity.class);
                myIntent.putExtra(key, theme);
                SettingsActivity.this.startActivity(myIntent);
                finish();
            }
        });
    }

}