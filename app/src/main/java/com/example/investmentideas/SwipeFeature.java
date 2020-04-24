package com.example.investmentideas;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class SwipeFeature extends GestureDetector.SimpleOnGestureListener {



    private ExploreAcitivty activity;

    public ExploreAcitivty getActivity(){
        return activity;
    }

    void setActivity(ExploreAcitivty activity) {
        this.activity = activity;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float VelocityX, float VelocityY) {
        float deltaX = e1.getX()-e2.getX();
        float deltaY = e1.getY()-e2.getY();

        float deltaXAbs = Math.abs(deltaX);
        float deltaYAbs = Math.abs(deltaY);

        int MAX_SWIPE_DISTANCE_X = 1000;
        int MIN_SWIPE_DISTANCE_X = 100;
        if (deltaXAbs >= MIN_SWIPE_DISTANCE_X && deltaXAbs <= MAX_SWIPE_DISTANCE_X) {
            if (deltaX > 0) {
                this.activity.displayMessage("Swipe to left");
            } else  {
                this.activity.displayMessage("Swipe to right");
            }
        }

        int MAX_SWIPE_DISTANCE_Y = 1000;
        int MIN_SWIPE_DISTANCE_Y = 100;
        if (deltaYAbs >= MIN_SWIPE_DISTANCE_Y && deltaYAbs <= MAX_SWIPE_DISTANCE_Y) {
            if (deltaY > 0) {
                this.activity.displayMessage("Swipe to up");
            } else  {
                this.activity.displayMessage("Swipe to down");
            }
        }

        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        this.activity.displayMessage("singe tap");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        this.activity.displayMessage("Double tap");
        return true;
    }

}
