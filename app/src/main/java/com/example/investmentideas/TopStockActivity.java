package com.example.investmentideas;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import java.io.IOException;


public class TopStockActivity extends AppCompatActivity {

    static TextView nameTextView;
    TextView aboutTextView;
    EditText editme;
    Button clickme;
    private GestureDetectorCompat gestureDetectorCompat = null;
    StockDatasourceImpl stockDatasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topstocksactivity);
        nameTextView = findViewById(R.id.nameTextView);
        aboutTextView = findViewById(R.id.aboutTextView);
        editme = findViewById(R.id.write_in_me);
        clickme = findViewById(R.id.click_me);

        SwipeFeature swipeFeature = new SwipeFeature();
        swipeFeature.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, swipeFeature);


        stockDatasource = new StockDatasourceImpl();

        /*AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    aboutTextView.setText(stockDatasource.run("https://api-v2.intrinio.com/companies/AAPL?api_key=OjU4YTg3NWY5NDExZmEzMzkxMTlhMzU1YjAwYzNkNDM5"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    public static void displayMessage(String message) {
        nameTextView.setText(message);
    }


}
