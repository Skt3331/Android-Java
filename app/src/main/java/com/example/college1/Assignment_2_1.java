// src/main/java/com/example/college1/Assignment_2_1.java
package com.example.college1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Assignment_2_1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment21);

        TextView textViewDisplay = findViewById(R.id.textViewDisplay);
        String userInput = getIntent().getStringExtra("USER_INPUT");

        textViewDisplay.setText(userInput);
    }
}
