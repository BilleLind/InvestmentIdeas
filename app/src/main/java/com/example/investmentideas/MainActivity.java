package com.example.investmentideas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.investmentideas.sector.BasicMaterials;
import com.example.investmentideas.sector.CommunicationServices;
import com.example.investmentideas.sector.ConsumerCyclical;
import com.example.investmentideas.sector.ConsumerDefensive;
import com.example.investmentideas.sector.Energy;
import com.example.investmentideas.sector.FinancialServices;
import com.example.investmentideas.sector.HealthCareSector;
import com.example.investmentideas.sector.Industrials;
import com.example.investmentideas.sector.RealEstate;
import com.example.investmentideas.sector.Technology;
import com.example.investmentideas.sector.Utilities;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button technology, health, finacial, cyclical, basic, defensive, utilities, communication, energy, industrial, real;

<<<<<<< HEAD

public class MainActivity extends AppCompatActivity {
=======
>>>>>>> master

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD


=======
        technology = findViewById(R.id.tech);
        health = findViewById(R.id.healthCare);
        finacial = findViewById(R.id.financial);
        cyclical = findViewById(R.id.ConsumerCyclical);
        basic = findViewById(R.id.BasicMaterials);
        defensive = findViewById(R.id.ConsumerDefensive);
        utilities = findViewById(R.id.Utilities);
        communication = findViewById(R.id.Communication);
        energy = findViewById(R.id.Energy);
        industrial = findViewById(R.id.Industrials);
        real = findViewById(R.id.RealEstate);


        technology.setOnClickListener(this);
        health.setOnClickListener(this);
        finacial.setOnClickListener(this);
        cyclical.setOnClickListener(this);
        basic.setOnClickListener(this);
        defensive.setOnClickListener(this);
        utilities.setOnClickListener(this);
        communication.setOnClickListener(this);
        energy.setOnClickListener(this);
        industrial.setOnClickListener(this);
        real.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tech:
                startActivity(new Intent(MainActivity.this, Technology.class));
                break;
            case R.id.healthCare:
                startActivity(new Intent(MainActivity.this, HealthCareSector.class));
                break;
            case R.id.RealEstate:
                startActivity(new Intent(MainActivity.this, RealEstate.class));
                break;
            case R.id.financial:
                startActivity(new Intent(MainActivity.this, FinancialServices.class));
                break;
            case R.id.ConsumerCyclical:
                startActivity(new Intent(MainActivity.this, ConsumerCyclical.class));
                break;
            case R.id.BasicMaterials:
                startActivity(new Intent(MainActivity.this, BasicMaterials.class));
                break;
            case R.id.ConsumerDefensive:
                startActivity(new Intent(MainActivity.this, ConsumerDefensive.class));
                break;
            case R.id.Utilities:
                startActivity(new Intent(MainActivity.this, Utilities.class));
                break;
            case R.id.Communication:
                startActivity(new Intent(MainActivity.this, CommunicationServices.class));
                break;
            case R.id.Energy:
                startActivity(new Intent(MainActivity.this, Energy.class));
                break;
            case R.id.Industrials:
                startActivity(new Intent(MainActivity.this, Industrials.class));
                break;
        }
>>>>>>> master
    }

    public void onTopStockClick(View v) {
        startActivity(new Intent(MainActivity.this, TopStockActivity.class));



    }

    public void onExploreClick(View v) {
        startActivity(new Intent(MainActivity.this, ExploreAcitivty.class));
    }


}
