package com.example.investmentideas.sector;

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

public class Utilities extends AppCompatActivity {
    static TextView overviewSec;
    static TextView tickerSec;
    static TextView companyNameSec;
    static TextView sectorSec;
    static TextView subSectorSec;
    static TextView rev16Sec;
    static TextView rev17Sec;
    static TextView rev18Sec;
    static TextView rev19Sec;
    static TextView rev20Sec;
    static TextView net16Sec;
    static TextView net17Sec;
    static TextView net18Sec;
    static TextView net19Sec;
    static TextView net20Sec;
    static ImageView imageSec;
    private boolean isEnable = false;

    private GestureDetectorCompat gestureDetectorCompat = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectoractivity);
        overviewSec = findViewById(R.id.SecOverview);
        tickerSec = findViewById(R.id.tickerSec);
        companyNameSec = findViewById(R.id.nameSec);
        sectorSec = findViewById(R.id.SectorSec);
        subSectorSec = findViewById(R.id.SubSectorSec);
        rev16Sec = findViewById(R.id.revenue2016Sec);
        rev17Sec = findViewById(R.id.revenue2017Sec);
        rev18Sec = findViewById(R.id.revenue2018Sec);
        rev19Sec = findViewById(R.id.revenue2019Sec);
        rev20Sec = findViewById(R.id.revenue2020Sec);
        net16Sec = findViewById(R.id.netIncome2016Sec);
        net17Sec = findViewById(R.id.netIncome2017Sec);
        net18Sec = findViewById(R.id.netIncome2018Sec);
        net19Sec = findViewById(R.id.netIncome2019Sec);
        net20Sec = findViewById(R.id.netIncome2020Sec);
        imageSec = findViewById(R.id.imageSec);


        SwipeFeature swipeFeature = new SwipeFeature();
        swipeFeature.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, swipeFeature);

        final ImageButton ButtonStar = (ImageButton) findViewById(R.id.starSec);
        ButtonStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEnable) { //adds / yellow star
                    ButtonStar.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), android.R.drawable.btn_star_big_off));
                    Toast.makeText(getApplicationContext(), "Removed from Favorite", Toast.LENGTH_SHORT).show();
                    //a method for setting it as favorite for the specific stock

                } else { // removes / blank star
                    ButtonStar.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), android.R.drawable.btn_star_big_on));
                    Toast.makeText(getApplicationContext(), "Added to Favorite", Toast.LENGTH_SHORT).show();
                    // a method for disabled it as favorite for the specific stock (mis-click?) and for resetting it at every new stock shown
                }
                isEnable = !isEnable;
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    public static boolean displayMessage(String overview, String ticker, String company, String sector, String subSector, float rev16, float rev17,
                                         float rev18, float rev19, float rev20, float net16, float net17, float net18, float net19, float net20) /* , ImageView image*/ {
        overviewSec.setText(overview);
        tickerSec.setText(ticker);
        companyNameSec.setText(company);
        sectorSec.setText(sector);
        subSectorSec.setText(subSector);
        rev16Sec.setText(String.valueOf(rev16));
        rev17Sec.setText(String.valueOf(rev17));
        rev18Sec.setText(String.valueOf(rev18));
        rev19Sec.setText(String.valueOf(rev19));
        rev20Sec.setText(String.valueOf(rev20));
        net16Sec.setText(String.valueOf(net16));
        net17Sec.setText(String.valueOf(net17));
        net18Sec.setText(String.valueOf(net18));
        net19Sec.setText(String.valueOf(net19));
        net20Sec.setText(String.valueOf(net20));

        return true;
    }
}
