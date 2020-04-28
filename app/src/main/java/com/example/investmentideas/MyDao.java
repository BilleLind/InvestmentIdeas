package com.example.investmentideas;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MyDao {

    @Insert
    public void addStock(Stock stock);

    @Query("SELECT * FROM stocks WHERE stockName LIKE :stockName")
    public Stock findByName(String stockName);


}
