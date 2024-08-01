package Assignment1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String password; // Store securely (hashing is recommended)
    private String contactNumber;
    private String registrationDate;

    // Constructor
    public User(int id, String fullName, String email, String password, String contactNumber) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
        // Get the current date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        this.registrationDate = dateFormat.format(new Date());
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    // Setters (You may not need setters for all fields, especially id and registrationDate)
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
