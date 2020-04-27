package com.example.investmentideas;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StockDatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase db = this.getReadableDatabase();
    private static final String DATABASE_NAME = "stock.db";
    private static final int VERSION = 1;

    public StockDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE stock(id INTEGER PRIMARY KEY AUTOINCREMENT, stockName TEXT NOT NULL, aboutStock TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new SQLException("i am spassing out");
    }

    public void insert(String stockName, String aboutStock) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("stockName", stockName);
        contentValues.put("aboutStock", aboutStock);
        db.insert("stock", null, contentValues);

    }
}
