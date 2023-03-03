package com.markofsuccess.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //class variables/fields
    private TextView resultText;
    private Button calculateButton;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText ageEditText;
    private EditText weightEditText;

    //onCreate is like the main Main Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViews();

        setupButtonClickListener();


    }

    private void findViews () {

        //ctrl+alt + f för göra de till fields //eller refactor introduce fields.
         resultText = findViewById(R.id.text_view_result);

        maleButton = findViewById(R.id.radio_button_male);
        femaleButton = findViewById(R.id.radio_button_female);


        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        ageEditText = findViewById(R.id.edit_text_age);
        weightEditText = findViewById(R.id.edit_text_weight);

       calculateButton = findViewById(R.id.button_calculate);
    }
    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBmi();

            }
        });
    }

    private void calculateBmi() {
       String ageText = ageEditText.getText().toString();
        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        resultText.setText("Age: " + ageText + ", Feet: " + feetText + ", Inches: " + inchesText+ ", Weight: " + weightText);
    }

}