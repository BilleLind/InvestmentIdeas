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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button technology = findViewById(R.id.tech);
        Button health = findViewById(R.id.healthCare);
        Button financial = findViewById(R.id.financial);
        Button cyclical = findViewById(R.id.ConsumerCyclical);
        Button basic = findViewById(R.id.BasicMaterials);
        Button defensive = findViewById(R.id.ConsumerDefensive);
        Button utilities = findViewById(R.id.Utilities);
        Button communication = findViewById(R.id.Communication);
        Button energy = findViewById(R.id.Energy);
        Button industrial = findViewById(R.id.Industrials);
        Button real = findViewById(R.id.RealEstate);
        Button stock = findViewById(R.id.stockSelector);

        technology.setOnClickListener(this);
        health.setOnClickListener(this);
        financial.setOnClickListener(this);
        cyclical.setOnClickListener(this);
        basic.setOnClickListener(this);
        defensive.setOnClickListener(this);
        utilities.setOnClickListener(this);
        communication.setOnClickListener(this);
        energy.setOnClickListener(this);
        industrial.setOnClickListener(this);
        real.setOnClickListener(this);
        stock.setOnClickListener(this);
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
            case R.id.stockSelector:
                startActivity(new Intent(MainActivity.this, StockSelector.class));
        }
    }

    public void onTopStockClick(View v) {
        startActivity(new Intent(MainActivity.this, TopStockActivity.class));



    }

    public void onExploreClick(View v) {
        startActivity(new Intent(MainActivity.this, ExploreAcitivty.class));
    }


}
