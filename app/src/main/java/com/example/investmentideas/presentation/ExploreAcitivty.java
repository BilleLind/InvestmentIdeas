package com.example.investmentideas.presentation;

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

import com.example.investmentideas.R;
import com.example.investmentideas.SwipeFeature;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;


public class ExploreAcitivty extends AppCompatActivity{

    private boolean isEnable=false; // https://stackoverflow.com/questions/8244252/star-button-in-android
    static TextView overviewExplore; private String overviewEx;
    static TextView tickerExplore; private String tickerEx;
    static  TextView companyNameExplore; private String companyEx;
    static TextView sectorExplore; private String sectorEx;
    static  TextView subSectorExplore; private String subSectorEx;
    static  TextView rev16Explore; private double rev16; public void setRev16(double rev16) { this.rev16 = rev16; }  public double getRev16() { return rev16; }
    static   TextView rev17Explore; private double rev17; public void setRev17(double rev17) { this.rev17 = rev17; }  public double getRev17() { return rev17; }
    static   TextView rev18Explore; private double rev18; public void setRev18(double rev18) { this.rev18 = rev18; }  public double getRev18() { return rev18; }
    static   TextView rev19Explore; private double rev19; public void setRev19(double rev19) { this.rev19 = rev19; }  public double getRev19() { return rev19; }
    static   TextView rev20Explore;
    static   TextView net16Explore; private double net16; public void setNet16(double net16) { this.net16 = net16; } public double getNet16() { return net16; }
    static   TextView net17Explore; private double net17; public void setNet17(double net17) { this.net17 = net17; } public double getNet17() { return net17; }
    static   TextView net18Explore; private double net18; public void setNet18(double net18) { this.net18 = net18; } public double getNet18() { return net18; }
    static   TextView net19Explore; private double net19; public void setNet19(double net19) { this.net19 = net19; } public double getNet19() { return net19; }
    static   TextView net20Explore;
    static   ImageView imageExplore;

    private GestureDetectorCompat gestureDetectorCompat = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploreactivity);
        overviewExplore = findViewById(R.id.ExploreOverview);
        tickerExplore = findViewById(R.id.tickerExplore);
        companyNameExplore = findViewById(R.id.nameExplore);
        sectorExplore = findViewById(R.id.SectorExplore);
        subSectorExplore = findViewById(R.id.SubSectorExplore);
        rev16Explore = findViewById(R.id.revenue2016Explore);
        rev17Explore = findViewById(R.id.revenue2017Explore);
        rev18Explore = findViewById(R.id.revenue2018Explore);
        rev19Explore = findViewById(R.id.revenue2019Explore);
        rev20Explore = findViewById(R.id.revenue2020Explore);
        net16Explore = findViewById(R.id.netIncome2016Explore);
        net17Explore = findViewById(R.id.netIncome2017Explore);
        net18Explore = findViewById(R.id.netIncome2018Explore);
        net19Explore = findViewById(R.id.netIncome2019Explore);
        net20Explore = findViewById(R.id.netIncome2020Explore);
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
        barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupSpace, barSpace)*5);
        //barChart.getAxisLeft().setAxisMinimum(0);

        barChart.groupBars(0, groupSpace, barSpace);

        barChart.invalidate();

    }
    private ArrayList<BarEntry> NetIncome() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 60));
        barEntries.add(new BarEntry(2, 88));
        barEntries.add(new BarEntry(3, 80));
        barEntries.add(new BarEntry(4, 110));
        barEntries.add(new BarEntry(5, 120));
        return barEntries; }

    private ArrayList<BarEntry> Revenue() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 320));
        barEntries.add(new BarEntry(2, 340));
        barEntries.add(new BarEntry(3, 460));
        barEntries.add(new BarEntry(4, 580));
        barEntries.add(new BarEntry(5, 600));
        return barEntries; }

    private ArrayList<BarEntry> EPS() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 1));
        barEntries.add(new BarEntry(2, 2));
        barEntries.add(new BarEntry(3, 4));
        barEntries.add(new BarEntry(4, 5));
        barEntries.add(new BarEntry(5, 8));
        return barEntries; }

    private ArrayList<BarEntry> Dividend() {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, 10));
        barEntries.add(new BarEntry(2, 5));
        barEntries.add(new BarEntry(3, 12));
        barEntries.add(new BarEntry(4, 15));
        barEntries.add(new BarEntry(5, 20));
        return barEntries;                  }





    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true; }

    public static boolean displayMessage(String overview, String ticker, String company, String sector, String subSector, float rev16, float rev17,
                                         float rev18, float rev19, float rev20, float net16, float net17, float net18, float net19, float net20) /* , ImageView image*/ {
        overviewExplore.setText(overview);
        tickerExplore.setText(ticker);
        companyNameExplore.setText(company);
        sectorExplore.setText(sector);
        subSectorExplore.setText(subSector);
        rev16Explore.setText(String.valueOf(rev16));
        rev17Explore.setText(String.valueOf(rev17));
        rev18Explore.setText(String.valueOf(rev18));
        rev19Explore.setText(String.valueOf(rev19));
        rev20Explore.setText(String.valueOf(rev20));
        net16Explore.setText(String.valueOf(net16));
        net17Explore.setText(String.valueOf(net17));
        net18Explore.setText(String.valueOf(net18));
        net19Explore.setText(String.valueOf(net19));
        net20Explore.setText(String.valueOf(net20));
        ExploreAcitivty exploreAcitivty = new ExploreAcitivty();
        exploreAcitivty.setNet16(net16); exploreAcitivty.setRev16(rev16);
        exploreAcitivty.setNet17(net17); exploreAcitivty.setRev17(rev17);
        exploreAcitivty.setNet18(net18); exploreAcitivty.setRev18(rev18);
        exploreAcitivty.setNet19(net19); exploreAcitivty.setRev19(rev19);
       return true;
    }



}
