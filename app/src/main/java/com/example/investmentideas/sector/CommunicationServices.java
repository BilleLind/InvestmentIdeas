package com.example.investmentideas.sector;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.investmentideas.R;

public class CommunicationServices extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sectoractivity);

        textView = findViewById(R.id.SectorActivityText);

        textView.setText(getString(R.string.communications_services));

    }
}
