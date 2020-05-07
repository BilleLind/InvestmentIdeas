package com.example.investmentideas;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;

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
        ExploreAcitivty exploreAcitivty = new ExploreAcitivty();
        StockSelector stockSelector = new StockSelector();

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
                    String h = "Hello"; String a ="a"; String b = "b"; String c = "c"; String d = "d";
                            ExploreAcitivty.displayMessage( h, a,b,c,d, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                    //method for ExploreAcitivty
                }
                if (currentClass.equals(topStocky)) { //TODO make hand off, the data from database into the display Message, could have a method that gets and it would refresh
                    //method for TopstopActivity
                    String h = "Hello"; String a ="dos"; String b = "dos"; String c = "dos"; String d = "dos";
                   TopStockActivity.displayMessage( h, a,b,c,d, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                }
            } else {
                if (currentClass.equals(explorere)) {
                    String h = "Hello"; String a ="ados"; String b = "dos"; String c = "dos"; String d = "dos";
                    ExploreAcitivty.displayMessage( h, a,b,c,d, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );

                }

                if (currentClass.equals(topStocky)) {
                    String h = "Hello"; String a ="a"; String b = "b"; String c = "c"; String d = "d";

                    TopStockActivity.displayMessage( h, a,b,c,d, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );

                }
            }
        }

        /* TODO do we need down or up? method for it here
        int MAX_SWIPE_DISTANCE_Y = 1000;
        int MIN_SWIPE_DISTANCE_Y = 100;
        if (deltaYAbs >= MIN_SWIPE_DISTANCE_Y && deltaYAbs <= MAX_SWIPE_DISTANCE_Y) {
            if (deltaY > 0) {
                ExploreAcitivty.displayMessage("Swipe to up");
            } else  {
                ExploreAcitivty.displayMessage("Swipe to down");
            }
        }
        */
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

