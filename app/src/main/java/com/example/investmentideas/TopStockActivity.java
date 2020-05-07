package com.example.investmentideas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GestureDetectorCompat;


public class TopStockActivity extends AppCompatActivity {
   static TextView overviewTop;
    static  TextView tickerTop;
    static TextView companyNameTop;
    static     TextView sectorTop;
    static TextView subSectorTop;
    static TextView rev16Top;
    static TextView rev17Top;
    static TextView rev18Top;
    static TextView rev19Top;
    static TextView rev20Top;
    static TextView net16Top;
    static  TextView net17Top;
    static  TextView net18Top;
    static  TextView net19Top;
    static  TextView net20Top;
    static  ImageView imageTop;
    private boolean isEnable=false;

    private GestureDetectorCompat gestureDetectorCompat = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topstocksactivity);
        overviewTop = findViewById(R.id.TopOverview);
        tickerTop = findViewById(R.id.tickerTop);
        companyNameTop = findViewById(R.id.nameTop);
        sectorTop = findViewById(R.id.SectorTop);
        subSectorTop = findViewById(R.id.SubSectorTop);
        rev16Top = findViewById(R.id.revenue2016Top);
        rev17Top = findViewById(R.id.revenue2017Top);
        rev18Top = findViewById(R.id.revenue2018Top);
        rev19Top = findViewById(R.id.revenue2019Top);
        rev20Top = findViewById(R.id.revenue2020Top);
        net16Top = findViewById(R.id.netIncome2016Top);
        net17Top = findViewById(R.id.netIncome2017Top);
        net18Top = findViewById(R.id.netIncome2018Top);
        net19Top = findViewById(R.id.netIncome2019Top);
        net20Top = findViewById(R.id.netIncome2020Top);
        imageTop = findViewById(R.id.imageTop);



        SwipeFeature swipeFeature = new SwipeFeature();
        swipeFeature.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, swipeFeature);

        final ImageButton ButtonStar = (ImageButton) findViewById(R.id.starTop);
        ButtonStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEnable){ //adds / yellow star
                    ButtonStar.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_off));
                    Toast.makeText(getApplicationContext(),"Removed from Favorite",Toast.LENGTH_SHORT).show();
                    //a method for setting it as favorite for the specific stock

                }else{ // removes / blank star
                    ButtonStar.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),android.R.drawable.btn_star_big_on));
                    Toast.makeText(getApplicationContext(),"Added to Favorite", Toast.LENGTH_SHORT).show();
                    // a method for disabled it as favorite for the specific stock (mis-click?) and for resetting it at every new stock shown
                }
                isEnable = !isEnable;
            }
        });

        Stock stock = new Stock();


        //LoginActivity.myStockDatabase.myDao().addStock(stock);


        overviewTop.setText(stock.getAboutStock());


        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Stock stock1 = MainActivity.myStockDatabase.myDao().findByName(stock.getStockName());
                Handler refresh = new Handler(Looper.getMainLooper());
                refresh.post(new Runnable() {
                    @Override
                    public void run() {
                        String text = stock1.getAboutStock();
                        aboutTextView.setText(text);
                    }
                });
            }
        });
        thread.start();*/


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    public static boolean displayMessage(String overview, String ticker, String company, String sector, String subSector, float rev16, float rev17,
                                         float rev18, float rev19, float rev20, float net16, float net17, float net18, float net19, float net20) /* , ImageView image*/ {
        overviewTop.setText(overview);
        tickerTop.setText(ticker);
        companyNameTop.setText(company);
        sectorTop.setText(sector);
        subSectorTop.setText(subSector);
        rev16Top.setText(String.valueOf(rev16));
        rev17Top.setText(String.valueOf(rev17));
        rev18Top.setText(String.valueOf(rev18));
        rev19Top.setText(String.valueOf(rev19));
        rev20Top.setText(String.valueOf(rev20));
        net16Top.setText(String.valueOf(net16));
        net17Top.setText(String.valueOf(net17));
        net18Top.setText(String.valueOf(net18));
        net19Top.setText(String.valueOf(net19));
        net20Top.setText(String.valueOf(net20));

        return true;
    }


}
