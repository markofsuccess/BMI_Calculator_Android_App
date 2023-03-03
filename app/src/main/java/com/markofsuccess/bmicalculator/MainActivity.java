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

        //parse is like analyze, so it will analyze its a string and convert it to an int
        //Converting the number 'Strings' into 'int' variables
       int age = Integer.parseInt(ageText);
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight= Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;

        //Height in meters is the inches multiplied by 0.0254
        double heightInMeters = totalInches * 0.0254;
        //BMI formula  weight in kg divided by height in meters squared
        double bmi = weight / (heightInMeters * heightInMeters);
        //we must convert the decdimal/double into a String for our TextView
        String bmiTextResult = String.valueOf(bmi);
        //display it to the viewer
        resultText.setText(bmiTextResult);
    }

}