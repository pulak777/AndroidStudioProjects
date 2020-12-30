package com.pulakdeyashi.ocrapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText input_name, input_age;
    private String name, age, gender;
    private Spinner spinner;
    private TextView display;
 //   int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.submit);
        input_name = findViewById(R.id.input_name);
        input_age = findViewById(R.id.input_age);
        spinner = findViewById(R.id.spinner_gender);
        display = findViewById(R.id.show_details);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = input_name.getText().toString();
                age = input_age.getText().toString();
                gender = spinner.getSelectedItem().toString();

                display.setText("Hi " + name + " age " + age + " gender " + gender);
            }
        });

    }
}