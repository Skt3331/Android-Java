package Assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.college1.R;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button addUserButton = findViewById(R.id.addUserButton);
        Button editUserButton = findViewById(R.id.editUserButton);
        Button listUsersButton = findViewById(R.id.listUsersButton);

        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(intent);
            }
        });

        editUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // You would typically get the user ID to edit from somewhere (e.g., user selection)
                // For simplicity, we'll just edit the first user in the list
                if (!userList.isEmpty()) {
                    int userId = userList.get(0).getId();
                    Intent intent = new Intent(MainActivity.this, EditUserActivity.class);
                    intent.putExtra("userId", userId);
                    startActivity(intent);
                }
            }
        });

        listUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserListActivity.class);
                startActivity(intent);
            }
        });
    }
}
