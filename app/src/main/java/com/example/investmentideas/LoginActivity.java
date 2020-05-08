package com.example.investmentideas;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.io.IOException;
import java.util.ArrayList;
public class LoginActivity extends AppCompatActivity {

    private LoginDatabaseHelper db;
    public static MyStockDatabase myStockDatabase;
    private EditText e1, e2;
    private Button login;
    private StockDatasourceImpl stockDatasource;
    private ListView loginListView;
    private ArrayList<Company> companies;
    private CompanyArrayAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginactivity);
        db = new LoginDatabaseHelper(this);
        myStockDatabase = Room.databaseBuilder(getApplicationContext(), MyStockDatabase.class, "stocks").build();
        loginListView = findViewById(R.id.login_listview);
        stockDatasource = new StockDatasourceImpl();

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

        adapter = new CompanyArrayAdapter(LoginActivity.this, new ArrayList<Company>());
        loginListView.setAdapter(adapter);
        new CompanyListTask(adapter).execute(stockDatasource);

        /*AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    adapter.addAll(stockDatasource.getCompanyList());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });*/




        /*AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(stockDatasource.getCompanyList().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/

        /*intrinoAPI =  new IntrinoAPI();
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                intrinoAPI.getStock();
            }
        });*/
    }

    public void onRegisterClick(View v) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
}
