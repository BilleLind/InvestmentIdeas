package com.example.investmentideas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;


public class TopStockActivity extends AppCompatActivity {

    static TextView nameTextView;
    TextView aboutTextView;
    EditText editme;
    Button clickme;
    private GestureDetectorCompat gestureDetectorCompat = null;

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

        Stock stock = new Stock();


        //LoginActivity.myStockDatabase.myDao().addStock(stock);


        aboutTextView.setText(stock.getAboutStock());


        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Stock stock1 = MainActivity.myStockDatabase.myDao().findByName(stock.getStockName());
                Handler refresh = new Handler(Looper.getMainLooper());
                refresh.post(new Runnable() {
                    @Override
                    public void run() {
                        String text = stock1.getAboutStock();
                        aboutTextView.setText(text);
                    }
                });
            }
        });
        thread.start();*/


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
