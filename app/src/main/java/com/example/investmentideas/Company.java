package com.example.investmentideas;

import androidx.annotation.NonNull;

public class Company {
    private String id;
    private String ticker;
    private String name;
    private String lei;
    private String cik;

    public Company(){};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }

    public String getCik() {
        return cik;
    }

    public void setCik(String cik) {
        this.cik = cik;
    }

    @NonNull
    @Override
    public String toString() {
        return "Name: " + this.name + " ID: " + this.id;
    }
}
