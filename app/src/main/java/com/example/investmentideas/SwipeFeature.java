package com.example.investmentideas;

import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import java.util.List;

public class SwipeFeature extends GestureDetector.SimpleOnGestureListener {


    private Activity activity;
    public Activity getActivity() {
        return activity;
    }

    void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float VelocityX, float VelocityY) {
        String currentClass = (activity.getClass().getSimpleName());
        String explorere = "ExploreAcitivty";
        String topStocky = "TopStockActivity";


        float deltaX = e1.getX() - e2.getX();
        float deltaY = e1.getY() - e2.getY();

        float deltaXAbs = Math.abs(deltaX);
        float deltaYAbs = Math.abs(deltaY);

        int MAX_SWIPE_DISTANCE_X = 1000;
        int MIN_SWIPE_DISTANCE_X = 100;
        if (deltaXAbs >= MIN_SWIPE_DISTANCE_X && deltaXAbs <= MAX_SWIPE_DISTANCE_X) {
            if (deltaX > 0) { // this is left
                //TODO make method for going through every stock
                if (currentClass.equals(explorere)) {
                    ExploreAcitivty exploreAcitivty = new ExploreAcitivty();
                    exploreAcitivty.displayMessage();


                }
                if (currentClass.equals(topStocky)) {
                    //method for TopstopActivity
                    TopStockActivity.displayMessage(currentClass + "Works");
                }
            } else { // this is right
                if (currentClass.equals(explorere)) {


                }

                if (currentClass.equals(topStocky)) {
                    TopStockActivity.displayMessage("Swipe to right");
                }
            }
        }


        int MAX_SWIPE_DISTANCE_Y = 1000;
        int MIN_SWIPE_DISTANCE_Y = 100;
        if (deltaYAbs >= MIN_SWIPE_DISTANCE_Y && deltaYAbs <= MAX_SWIPE_DISTANCE_Y) {
            if (deltaY > 0) {
                //Stock stock = stockRepository.getTask(1); this is up but not work


            } else  {
                //ExploreAcitivty.displayMessage("Swipe to down");
            }
        }

        return true;
    }

    /*//TODO
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        this.activity.displayMessage("singe tap");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        this.activity.displayMessage("Double tap");
        return true;
    } */

    }

