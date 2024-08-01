package Assignment1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.college1.R;  // Update this import if your package name is different

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView fullNameTextView;
        public TextView emailTextView;
        public TextView contactTextView;
        public TextView registrationDateTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            fullNameTextView = itemView.findViewById(R.id.fullNameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            contactTextView = itemView.findViewById(R.id.contactNumberTextView);
            registrationDateTextView = itemView.findViewById(R.id.registrationDateTextView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_item, parent, false); // Make sure the layout file is correct
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.fullNameTextView.setText(user.getFullName());
        holder.emailTextView.setText(user.getEmail());
        holder.contactTextView.setText(user.getContactNumber());
        holder.registrationDateTextView.setText(user.getRegistrationDate());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
