package com.example.investmentideas;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.investmentideas.presentation.ExploreAcitivty;
import com.example.investmentideas.presentation.TopStockActivity;
import com.example.investmentideas.sector.BasicMaterials;
import com.example.investmentideas.sector.CommunicationServices;
import com.example.investmentideas.sector.ConsumerCyclical;
import com.example.investmentideas.sector.Energy;
import com.example.investmentideas.sector.FinancialServices;
import com.example.investmentideas.sector.HealthCareSector;
import com.example.investmentideas.sector.Industrials;
import com.example.investmentideas.sector.RealEstate;
import com.example.investmentideas.sector.Technology;
import com.example.investmentideas.sector.Utilities;

public class SwipeFeature extends GestureDetector.SimpleOnGestureListener {


    private Activity activity;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
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
                    switchJob();
            }
                else { //this is right
                    switchJob();
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


    public boolean switchJob() {
        String currentClass = (activity.getClass().getSimpleName());
        float rev16 = 16, rev17 = 17, rev18 = 18, rev19 = 19, rev20 = 20;
        float net16 = 16, net17 = 17, net18 = 18, net19 = 19, net20 = 20;
        String overview = "overview"; String ticker ="ticker"; String company = "company"; String sector = "sector"; String subSector = "subSector";

        switch (currentClass) {
            case "TopStockActivity": TopStockActivity.displayMessage( overview, ticker,company,sector,subSector, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                break;
            case "ExploreAcitivty":  ExploreAcitivty.displayMessage( overview, ticker,company,sector,subSector, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                break;
            case  "BasicMaterials": BasicMaterials.displayMessage( overview, ticker,company,sector,subSector, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                break;
            case  "CommunicationServices": CommunicationServices.displayMessage( overview, ticker,company,sector,subSector, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                break;
            case  "ConsumerCyclical": ConsumerCyclical.displayMessage( overview, ticker,company,sector,subSector, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                break;
            case  "Energy": Energy.displayMessage( overview, ticker,company,sector,subSector, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                break;
            case  "FinancialServices": FinancialServices.displayMessage( overview, ticker,company,sector,subSector, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                break;
            case  "HealthCareSector": HealthCareSector.displayMessage( overview, ticker,company,sector,subSector, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                break;
            case  "Industrials": Industrials.displayMessage( overview, ticker,company,sector,subSector, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                break;
            case  "RealEstate": RealEstate.displayMessage( overview, ticker,company,sector,subSector, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                break;
            case  "Technology": Technology.displayMessage( overview, ticker,company,sector,subSector, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                break;
            case "Utilities": Utilities.displayMessage( overview, ticker,company,sector,subSector, 16, 17, 18, 19, 20,16, 17, 18, 19, 20  );
                break;
        }
        return true;
    }

    }

