package com.example.investmentideas;

import android.widget.ImageView;

public class StockSelector  {


    public static boolean selectTop() {

        ImageView imageViewEx;
        String overview="hello", sector="there", subSector="dirt", name="apple", ticker="abc";
        float rev16=16, rev17=17, rev18=18, rev19=19, rev20=20, net16=16, net17=17, net18=18, net19=19, net20=20;

        boolean moreTopStocks = true;


        while (moreTopStocks) {
            int count=1;

            for (int i = 0; i ==count-1; i++) {
               TopStockActivity.displayMessage(overview, ticker, name, sector, subSector, rev16+i, rev17, rev18, rev19,rev20,net16,net17,net18,net19,net20);
            }




            count++;
        }





        return true;
    }
}
