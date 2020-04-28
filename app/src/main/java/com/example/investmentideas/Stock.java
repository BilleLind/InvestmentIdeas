package com.example.investmentideas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stocks")
public class Stock {

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "stockName")
    private String stockName;

    @ColumnInfo(name = "aboutStock")
    private String aboutStock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getAboutStock() {
        return aboutStock;
    }

    public void setAboutStock(String aboutStock) {
        this.aboutStock = aboutStock;
    }
}
