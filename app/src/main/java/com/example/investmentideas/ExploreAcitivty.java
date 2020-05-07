package com.example.investmentideas;

import android.graphics.Color;
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

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;


public class ExploreAcitivty extends AppCompatActivity{

    private boolean isEnable=false; // https://stackoverflow.com/questions/8244252/star-button-in-android
    static TextView overviewExplore;
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





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploreactivity);

        overviewExplore = findViewById(R.id.ExploreOverview);
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

        barChartMakerMethod();

    }
    public void barChartMakerMethod() { //https://www.youtube.com/watch?v=Bd76zMHdrDE
        BarChart barChart = findViewById(R.id.barChartExplore);
        BarDataSet barDataSet1 = new BarDataSet(NetIncome(), "Net");
        barDataSet1.setColor(Color.RED);
        BarDataSet barDataSet2 = new BarDataSet(Revenue(), "Rev");
        barDataSet2.setColor(Color.GREEN);
        BarDataSet barDataSet3 = new BarDataSet(EPS(), "EPS");
        barDataSet3.setColor(Color.BLUE);
        BarDataSet barDataSet4 = new BarDataSet(Dividend(), "DIV");
        barDataSet4.setColor(Color.YELLOW);

        BarData data = new BarData(barDataSet1, barDataSet2, barDataSet3, barDataSet4);
        barChart.setData(data);

        String[] years = new String[] {"2016", "2017", "2018", "2019", "2020"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(years));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.TOP_INSIDE);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        //customize
        barChart.getDescription().setEnabled(false); // disabled the bottom right corner description
        barChart.setAutoScaleMinMaxEnabled(true);
        barChart.setDrawValueAboveBar(true);
        //TODO add more here

        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(3);

        float barSpace = 0.08f;
        float groupSpace = 0.38f;
        data.setBarWidth(0.10f);  // these values * the number of columns have to equal 1

        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupSpace, barSpace)*(NetIncome().size()));
        //barChart.getAxisLeft().setAxisMinimum(0);

        barChart.groupBars(0, groupSpace, barSpace);

        barChart.invalidate();



    }
    private ArrayList<BarEntry> NetIncome() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1,  120));
        barEntries.add(new BarEntry(2, 140));
        barEntries.add(new BarEntry(3, 160));
        barEntries.add(new BarEntry(4, 180));
        barEntries.add(new BarEntry(5, 200));
        return barEntries;
    }
    private ArrayList<BarEntry> Revenue() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 320));
        barEntries.add(new BarEntry(2, 340));
        barEntries.add(new BarEntry(3, 460));
        barEntries.add(new BarEntry(4, 580));
        barEntries.add(new BarEntry(5, 600));
        return barEntries;
    }
    private ArrayList<BarEntry> EPS() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 1));
        barEntries.add(new BarEntry(2, 2));
        barEntries.add(new BarEntry(3, 4));
        barEntries.add(new BarEntry(4, 5));
        barEntries.add(new BarEntry(5, 8));
        return barEntries;
    }
    private ArrayList<BarEntry> Dividend() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 10));
        barEntries.add(new BarEntry(2, 5));
        barEntries.add(new BarEntry(3, 12));
        barEntries.add(new BarEntry(4, 15));
        barEntries.add(new BarEntry(5, 20));
        return barEntries;
    }





    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true; }

    public static void displayMessage(String overview, String ticker, String company, String sector, String subSector, double rev16, double rev17, double rev18, double rev19,
                                      double net16, double net17, double net18, double net19, ImageView image) {
        overviewExplore.setText(overview);
        tickerExplore.setText(ticker);
        companyNameEx.setText(company);
        sectorExplore.setText(sector);
        subSectorExplore.setText(subSector);
        rev16Ex.setText((int) rev16);
        rev17Ex.setText((int) rev17);
        rev18Ex.setText((int) rev18);
        rev19Ex.setText((int) rev19);
        net16Ex.setText((int) net16);
        net17Ex.setText((int) net17);
        net18Ex.setText((int) net18);
        net19Ex.setText((int) net19);





    }



}
