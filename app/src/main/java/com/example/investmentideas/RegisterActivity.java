package com.example.investmentideas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    LoginDatabaseHelper db;
    EditText e1, e2, e3;
    Button b1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeractivity);
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
                
            }
        });
    }
}
