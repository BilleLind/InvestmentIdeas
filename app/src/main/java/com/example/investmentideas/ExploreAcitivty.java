package com.example.investmentideas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;



public class ExploreAcitivty extends AppCompatActivity{

    static TextView exploreTextview;
    static TextView tickerExplore;
    static TextView companyNameEx;
    static TextView sectorExplore;
    static TextView subSectorExplore;
    static TextView rev16Ex;
    static TextView rev17Ex;
    static TextView rev18Ex;
    static TextView rec19Ex;
    static TextView net16Ex;
    static TextView net17Ex;
    static TextView net18Ex;
    static TextView net19Ex;

    private GestureDetectorCompat gestureDetectorCompat = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploreactivity);

        exploreTextview = findViewById(R.id.ExploreOverview);
        tickerExplore = findViewById(R.id.tickerExplore);
        companyNameEx = findViewById(R.id.nameExplore);

        SwipeFeature swipeFeature = new SwipeFeature();
        swipeFeature.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, swipeFeature);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true; }

    public static void displayMessage(String message) {
        exploreTextview.setText(message); }







}
