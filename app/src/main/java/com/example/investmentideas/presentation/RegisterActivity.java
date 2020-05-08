package com.example.investmentideas.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.investmentideas.data.LoginDatabaseHelper;
import com.example.investmentideas.R;

public class RegisterActivity extends AppCompatActivity {
    LoginDatabaseHelper db;
    EditText e1, e2, e3;
    Button b1;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeractivity);
        db = new LoginDatabaseHelper(this);
        e1 = findViewById(R.id.remail);
        e2 = findViewById(R.id.rpassword);
        e3 = findViewById(R.id.rcpassword);
        b1 = findViewById(R.id.rregister);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                String confirmPassword = e3.getText().toString();

                if (email.equals("") || password.equals("") || confirmPassword.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirmPassword)) {
                        boolean checkMail = db.checkMail(email);
                        if (checkMail) {
                            boolean insert = db.insert(email, password);
                            if (insert) {
                                Toast.makeText(getApplicationContext(), "Register was succesfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Email is already registered", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
