package com.example.investmentideas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GestureDetectorCompat;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class ExploreAcitivty extends AppCompatActivity{

    private boolean isEnable=false; // https://stackoverflow.com/questions/8244252/star-button-in-android
    static TextView exploreTextview;
    static TextView tickerExplore;
    static TextView companyNameEx;
    static TextView sectorExplore;
    static TextView subSectorExplore;
    static TextView rev16Ex;
    static TextView rev17Ex;
    static TextView rev18Ex;
    static TextView rev19Ex;
    static TextView net16Ex;
    static TextView net17Ex;
    static TextView net18Ex;
    static TextView net19Ex;
    static ImageView imageExplore;

    private GestureDetectorCompat gestureDetectorCompat = null;

    BarChart barChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploreactivity);

        exploreTextview = findViewById(R.id.ExploreOverview);
        tickerExplore = findViewById(R.id.tickerExplore);
        companyNameEx = findViewById(R.id.nameExplore);
        sectorExplore = findViewById(R.id.SectorExplore);
        subSectorExplore = findViewById(R.id.SubSectorExplore);
        rev16Ex = findViewById(R.id.revenue2016Explore);
        rev17Ex = findViewById(R.id.revenue2017Explore);
        rev18Ex = findViewById(R.id.revenue2018Explore);
        rev19Ex = findViewById(R.id.revenue2019Explore);
        net16Ex = findViewById(R.id.netIncome2016Explore);
        net17Ex = findViewById(R.id.netIncome2017Explore);
        net18Ex = findViewById(R.id.netIncome2018Explore);
        net19Ex = findViewById(R.id.netIncome2019Explore);
        imageExplore = findViewById(R.id.imageExplore);

        SwipeFeature swipeFeature = new SwipeFeature();
        swipeFeature.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, swipeFeature);

        final ImageButton ButtonStar = (ImageButton) findViewById(R.id.star);
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

        barChart = (BarChart) findViewById(R.id.barChartExplore);
        //https://github.com/PhilJay/MPAndroidChart/wiki/Setting-Data#grouped-barchart

        float[] EPS = {1, 2, 3, 4};
        int[] NetIncome = {80, 90, 120, 160};
        int[] revenueBar = {200,240,260,320};

        List<BarEntry> entriesGroup1 = new ArrayList<>();
        List<BarEntry> entriesGroup2 = new ArrayList<>();
        List<BarEntry> entriesGroup3 = new ArrayList<>();

        for (int i = 0; i < EPS.length; i++) {
            entriesGroup1.add(new BarEntry(i, EPS[i]));
            entriesGroup1.add(new BarEntry(i, NetIncome[i]));
            entriesGroup1.add(new BarEntry(i, revenueBar[i]));
        }

        BarDataSet set1 = new BarDataSet(entriesGroup1, "EPS");
        BarDataSet set2 = new BarDataSet(entriesGroup2, "Net Income");
        BarDataSet set3 = new BarDataSet(entriesGroup3, "Revenue");


    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true; }

    public static void displayMessage(String message) {
        exploreTextview.setText(message); }



}
