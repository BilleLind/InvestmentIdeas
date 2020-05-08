package com.example.investmentideas.presentation;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GestureDetectorCompat;

import com.example.investmentideas.R;
import com.example.investmentideas.Stock;
import com.example.investmentideas.data.StockDatasourceImpl;
import com.example.investmentideas.SwipeFeature;


public class TopStockActivity extends AppCompatActivity {
    static TextView overviewTop;
    static TextView tickerTop;
    static TextView companyNameTop;
    static TextView sectorTop;
    static TextView subSectorTop;
    static TextView rev16Top;
    static TextView rev17Top;
    static TextView rev18Top;
    static TextView rev19Top;
    static TextView rev20Top;
    static TextView net16Top;
    static TextView net17Top;
    static TextView net18Top;
    static TextView net19Top;
    static TextView net20Top;
    static ImageView imageTop;
    private boolean isEnable=false;

    private GestureDetectorCompat gestureDetectorCompat = null;
    StockDatasourceImpl stockDatasource;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topstocksactivity);
        overviewTop = findViewById(R.id.SecOverview);
        tickerTop = findViewById(R.id.tickerSec);
        companyNameTop = findViewById(R.id.nameSec);
        sectorTop = findViewById(R.id.SectorTop);
        subSectorTop = findViewById(R.id.SubSectorSec);
        rev16Top = findViewById(R.id.revenue2016Sec);
        rev17Top = findViewById(R.id.revenue2017Sec);
        rev18Top = findViewById(R.id.revenue2018Sec);
        rev19Top = findViewById(R.id.revenue2019Sec);
        rev20Top = findViewById(R.id.revenue2020Sec);
        net16Top = findViewById(R.id.netIncome2016Sec);
        net17Top = findViewById(R.id.netIncome2017Sec);
        net18Top = findViewById(R.id.netIncome2018Sec);
        net19Top = findViewById(R.id.netIncome2019Sec);
        net20Top = findViewById(R.id.netIncome2020Sec);
        imageTop = findViewById(R.id.imageSec);



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


        stockDatasource = new StockDatasourceImpl();

        /*AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    aboutTextView.setText(stockDatasource.run("https://api-v2.intrinio.com/companies/AAPL?api_key=OjU4YTg3NWY5NDExZmEzMzkxMTlhMzU1YjAwYzNkNDM5"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });*/


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
