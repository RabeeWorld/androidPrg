package com.example.validation;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etDob, etPassword, etConfirmPassword;
    Spinner spinnerCountry,spinnerplace;
    CheckBox cbReading, cbTraveling, cbGaming;
    Button btnSubmit;
    RadioGroup rgGender;

    String[] state = {"Select DISTRICT", "MALAPPURAM", "KOZHIKODE", "PALAKKAD", "ERNAKULAM"};
    String[] place ={"Select Place","vengara","areekode"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etDob = findViewById(R.id.etDob);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerplace =findViewById(R.id.spinnerplace);
        
        cbReading = findViewById(R.id.cbReading);
        cbTraveling = findViewById(R.id.cbTraveling);
        cbGaming = findViewById(R.id.cbGaming);
        btnSubmit = findViewById(R.id.btnSubmit);
        rgGender = findViewById(R.id.rgGender);


        // Set up spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, state);
        spinnerCountry.setAdapter(adapter);
        
        ArrayAdapter<String> adapter1 =new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,place);
        spinnerplace.setAdapter(adapter1);

        // Handle submit
        btnSubmit.setOnClickListener(v -> {
            if (validateForm()) {
                Toast.makeText(this, "Form submitted successfully!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validateForm() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String dob = etDob.getText().toString().trim();
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();
        String country = spinnerCountry.getSelectedItem().toString();

        // Name validation
        if (TextUtils.isEmpty(name)) {
            etName.setError("Name is required");
            return false;
        }

        // Email validation
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Valid email is required");
            return false;
        }

        // Phone validation
        if (TextUtils.isEmpty(phone) || phone.length() != 10) {
            etPhone.setError("Enter valid 10-digit phone number");
            return false;
        }

        // DOB validation
        if (TextUtils.isEmpty(dob) || !dob.matches("\\d{2}/\\d{2}/\\d{4}")) {
            etDob.setError("Enter DOB in dd/mm/yyyy format");
            return false;
        }

        // Password validation
        if (TextUtils.isEmpty(password) || password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            return false;
        }

        // Gender
        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Confirm password validation
        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Passwords do not match");
            return false;
        }

        // Country validation
        if (country.equals("Select Country")) {
            Toast.makeText(this, "Please select a country", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Hobbies validation
        if (!cbReading.isChecked() && !cbTraveling.isChecked() && !cbGaming.isChecked()) {
            Toast.makeText(this, "Please select at least one hobby", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}