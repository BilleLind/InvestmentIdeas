package com.example.investmentideas;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

public class ExploreAcitivty extends AppCompatActivity{

    TextView textView;

    private GestureDetectorCompat gestureDetectorCompat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploreactivity);

        textView = findViewById(R.id.textView2);

        SwipeFeature swipeFeature = new SwipeFeature();
        swipeFeature.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, swipeFeature);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    public void displayMessage(String message) {
        textView.setText(message);
    }




}
