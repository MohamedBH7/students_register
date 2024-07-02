package com.example.students_register;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etConfirmEmail, etFirstName, etLastName, etMobile, etPassword, etConfirmPassword;
    private Spinner spSalutation, spNationality;
    private Button btnArabic, btnEnglish, btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etEmail = findViewById(R.id.et_email);
        etConfirmEmail = findViewById(R.id.et_confirm_email);
        etFirstName = findViewById(R.id.et_first_name);
        etLastName = findViewById(R.id.et_last_name);
        etMobile = findViewById(R.id.et_mobile);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        spSalutation = findViewById(R.id.sp_salutation);
        spNationality = findViewById(R.id.sp_nationality);
        btnArabic = findViewById(R.id.btn_arabic);
        btnEnglish = findViewById(R.id.btn_english);
        btnSubmit = findViewById(R.id.btn_submit);

        // Set click listeners
        btnArabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchLanguage("ar");
            }
        });

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchLanguage("en");
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSubmit();
            }
        });
    }

    private void switchLanguage(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        // Restart activity to apply language change
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void validateAndSubmit() {
        // Implement validation logic for form fields and submit action
        // Example: Validate email format
        String email = etEmail.getText().toString().trim();
        String confirmEmail = etConfirmEmail.getText().toString().trim();

        if (!email.isEmpty() && !confirmEmail.isEmpty() && email.equals(confirmEmail)) {
            // Email is valid, proceed with submission
            Toast.makeText(this, "Form submitted successfully", Toast.LENGTH_SHORT).show();
            // Add logic to handle form submission
        } else {
            // Show error if emails don't match
            Toast.makeText(this, "Emails do not match", Toast.LENGTH_SHORT).show();
        }
    }
}