// src/main/java/com/example/college1/Assignment_2.java
package com.example.college1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Assignment_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_assignment2);

        EditText editTextUserInput = findViewById(R.id.editTextUserInput);
        Button buttonForward = findViewById(R.id.buttonForward);

        buttonForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editTextUserInput.getText().toString();
                Intent intent = new Intent(Assignment_2.this, Assignment_2_1.class);
                intent.putExtra("USER_INPUT", userInput);
                startActivity(intent);
            }
        });
    }
}
