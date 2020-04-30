package com.example.investmentideas;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Stock.class}, version = 1, exportSchema = false)
public abstract class StockDatabase extends RoomDatabase {

    public abstract DaoAccess daoAccess();

}
