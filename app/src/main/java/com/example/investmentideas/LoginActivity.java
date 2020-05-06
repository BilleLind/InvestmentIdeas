package com.example.investmentideas;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class LoginActivity extends AppCompatActivity {

    LoginDatabaseHelper db;
    EditText e1, e2;
    Button login;
    public static MyStockDatabase myStockDatabase;
    IntrinoAPI intrinoAPI;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        db = new LoginDatabaseHelper(this);
        myStockDatabase = Room.databaseBuilder(getApplicationContext(), MyStockDatabase.class, "stocks").build();

        e1 = findViewById(R.id.email);
        e2 = findViewById(R.id.password);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                boolean checkMailPass = db.checkMailPass(email, password);
                if (checkMailPass) {
                    Toast.makeText(getApplicationContext(), "Login Succesfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        intrinoAPI = new IntrinoAPI();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                intrinoAPI.getStock();
            }
        });
    }

    public void onRegisterClick(View v) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
}
