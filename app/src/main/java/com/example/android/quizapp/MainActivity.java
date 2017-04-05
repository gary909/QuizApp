package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.quizapp.R.id.Q1A3;

public class MainActivity extends AppCompatActivity {

    int points = 0;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("Q1A3", points);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            points = savedInstanceState.getInt("Q1A3");
        }
    }



    // Question 1
    public int question1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case Q1A3:
                if (checked)
                    points += 1;
        }
        return points;
    }

    // Displays Toast with Name and Score
    public int results(View View) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        Toast.makeText(getApplicationContext(), name + "! You got " + points + " points!", Toast.LENGTH_LONG).show();
        points = 0;
        return points;
    }
}
