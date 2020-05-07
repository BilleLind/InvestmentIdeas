package com.example.investmentideas;

import android.widget.ImageView;

public class StockSelector extends ExploreAcitivty{
        ImageView imageView = findViewById(R.id.imageExplore);


    public static void select() {


        ExploreAcitivty.tickerExplore.setText("ABC");
        ExploreAcitivty.companyNameExplore.setText("this works");
        ExploreAcitivty.overviewExplore.setText("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADD");

        ExploreAcitivty.imageExplore.setImageResource(R.drawable.note);
        //boolean exploreRunning = true;
        //while (exploreRunning) {
        //    int i = 0; }


    }
}
