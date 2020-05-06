package com.example.investmentideas;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Stock.class}, version = 1, exportSchema = false)
public abstract class MyStockDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}
