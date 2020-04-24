package com.example.investmentideas;

import android.app.Activity;
import android.content.Intent;
import android.os.UserHandle;
import android.widget.TextView;

public class StockSelector extends ExploreAcitivty{



    public static boolean select() {

        ExploreAcitivty.tickerExplore.setText("ABC");
        ExploreAcitivty.companyNameEx.setText("this works");
        ExploreAcitivty.exploreTextview.setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADD");
        return true;
    }
}
