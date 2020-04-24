package com.example.investmentideas;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

public class TopStockActivity extends AppCompatActivity {

    static TextView textView;

    private GestureDetectorCompat gestureDetectorCompat = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topstocksactivity);

        textView = findViewById(R.id.nameTextView);

    SwipeFeature swipeFeature = new SwipeFeature();
        swipeFeature.setActivity(this);
    gestureDetectorCompat = new GestureDetectorCompat(this, swipeFeature);
}

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    public static void displayMessage(String message) {
        textView.setText(message);
    }


}
