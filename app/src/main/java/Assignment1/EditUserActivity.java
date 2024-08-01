package Assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.college1.R;

public class EditUserActivity extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private EditText contactNumberEditText;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_user);



        // Initialize EditTexts

        fullNameEditText = findViewById(R.id.fullNameEditText);

        emailEditText = findViewById(R.id.emailEditText);

        passwordEditText = findViewById(R.id.passwordEditText);

        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);

        contactNumberEditText = findViewById(R.id.contactNumberEditText);



        Intent intent = getIntent();

        userId = intent.getIntExtra("userId", -1);



        if (userId != -1) {

            User user = MainActivity.userList.get(userId);

            fullNameEditText.setText(user.getFullName());

            emailEditText.setText(user.getEmail());

            // Consider not pre-filling or masking the password for security

            // passwordEditText.setText(user.getPassword());

            // confirmPasswordEditText.setText(user.getPassword());

            contactNumberEditText.setText(user.getContactNumber());

        }



        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                if (isValidInput()) {

                    User updatedUser = new User(userId,

                            fullNameEditText.getText().toString(),

                            emailEditText.getText().toString(),

                            passwordEditText.getText().toString(), // You should hash the password before storing

                            contactNumberEditText.getText().toString()

                    );



                    MainActivity.userList.set(userId, updatedUser);

                    Toast.makeText(EditUserActivity.this, "User updated successfully!", Toast.LENGTH_SHORT).show();

                    finish();

                }

            }

        });

    }

    private boolean isValidInput() {
        String fullName = fullNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();
        String contactNumber = contactNumberEditText.getText().toString().trim();

        // Full Name Validation
        if (TextUtils.isEmpty(fullName)) {
            fullNameEditText.setError("Please enter your full name");
            return false;
        }

        if (!fullName.matches("^[a-zA-Z\\s]+$")) {
            fullNameEditText.setError("Full name should only contain letters and spaces");
            return false;
        }

        // Email Validation
        if (TextUtils.isEmpty(email)) {
            emailEditText.setError("Please enter your email");
            return false;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Please enter a valid email address");
            return false;
        }

        // Password Validation
        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Please enter a password");
            return false;
        }

        if (password.length() < 8) {
            passwordEditText.setError("Password should be at least 8 characters long");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            confirmPasswordEditText.setError("Passwords do not match");
            return false;
        }

        // Contact Number Validation (optional)
        if (!TextUtils.isEmpty(contactNumber) && !Patterns.PHONE.matcher(contactNumber).matches()) {
            contactNumberEditText.setError("Please enter a valid phone number");
            return false;
        }

        return true;
    }

}
