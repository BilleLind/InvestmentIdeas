package com.example.investmentideas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Stock implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private int id;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    private String companyName;
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    private String overview;
    public String getOverview() { return overview; }
    public void setOverview(String overview) { this.overview = overview; }

    private String sector;
    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }

    private String subSector;
    public void setSubSector(String subSector) { this.subSector = subSector; }
    public String getSubSector() { return subSector; }

    private String tickerCode;
    public String getTickerCode() { return tickerCode; }
    public void setTickerCode(String tickerCode) { this.tickerCode = tickerCode; }

    private int year;
    public void setYear(int year) { this.year = year; }
    public int getYear() { return year; }

    private int revenue;
    public int getRevenue() { return revenue; }
    public void setRevenue(int revenue) { this.revenue = revenue; }

    private int netIncome;
    public int getNetIncome() { return netIncome; }
    public void setNetIncome(int netIncome) { this.netIncome = netIncome; }
}
