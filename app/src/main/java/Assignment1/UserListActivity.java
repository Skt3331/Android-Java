package Assignment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.college1.R;

import java.util.List;

public class UserListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        RecyclerView recyclerView = findViewById(R.id.userRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        UserAdapter adapter = new UserAdapter(MainActivity.userList);
        recyclerView.setAdapter(adapter);
    }

    // Inner class for the UserAdapter
    public static class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

        private List<User> userList;

        public UserAdapter(List<User> userList) {
            this.userList = userList;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView fullNameTextView;
            public TextView emailTextView;
            // ... Add other TextViews for contact number, etc.

            public ViewHolder(View itemView) {
                super(itemView);
                fullNameTextView = itemView.findViewById(R.id.fullNameEditText);
                emailTextView = itemView.findViewById(R.id.emailEditText);
                // ...
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.user_list_item, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            User user = userList.get(position);
            holder.fullNameTextView.setText(user.getFullName());
            holder.emailTextView.setText(user.getEmail());
            // ... Set values for other TextViews
        }

        @Override
        public int getItemCount() {
            return userList.size();
        }
    }
}
