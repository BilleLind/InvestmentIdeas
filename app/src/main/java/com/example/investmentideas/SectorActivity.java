package com.example.investmentideas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SectorActivity extends AppCompatActivity {

Button button1;
Button button2;
TextView textView1;
TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectoractivity);
        final StockRepository stockRepository = new StockRepository(getApplicationContext());

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        textView1 = findViewById(R.id.textView_sector);
        textView2 = findViewById(R.id.textView2_sector);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StockRepository stockRepository = new StockRepository(getApplicationContext());
                String overview = "this is the overview";
                String companyName = "Microsoft";
                stockRepository.insertTask(companyName,overview);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Stock stock = stockRepository.getTask(2);
                textView1.setText(stock.getCompanyName());
                textView2.setText(stock.getOverview());
            }
        });
    }


}
