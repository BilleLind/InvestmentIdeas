package com.example.investmentideas;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class StockRepository {

    private String DB_NAME = "db_task";

    private StockDatabase stockDatabase;
    public StockRepository(Context context) {
        stockDatabase = Room.databaseBuilder(context, StockDatabase.class, DB_NAME).build();
    }

    //public void insertTask(String companyName, String overview, String sector, String subSector, String tickerCode, int year, int revenue, int netIncome ) {
     //   insertTask(companyName, overview, sector, subSector, tickerCode, year, revenue, netIncome); }
    public void  insertTask(String companyName, String overview) {
       Stock stock = new Stock();
       stock.setCompanyName(companyName);
        stock.setOverview(overview);
    }

   /* public void insertTask(String companyName, String overview, String sector, String subSector, String tickerCode, int year, int revenue, int netIncome) {
        Stock stock = new Stock();
        stock.setCompanyName(companyName);
        stock.setOverview(overview);
        stock.setSector(sector);
        stock.setSubSector(subSector);
        stock.setTickerCode(tickerCode);
        stock.setYear(year);
        stock.setRevenue(revenue);
        stock.setNetIncome(netIncome);
    } */

    public void insertTask(final Stock stock) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void...voids) {
                stockDatabase.daoAccess().insertTask(stock);
                return null;
            }
        }.execute();
    }
    public void updateTask(final Stock stock) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void...voids) {
                stockDatabase.daoAccess().updateTask(stock);
                return null;
            }
        }.execute();
    }

    public void deleteTask(final int id) {
        final LiveData<Stock> task = getTask(id);
        if (task !=null) {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void...voids) {

                    stockDatabase.daoAccess().deleteTask(task.getValue());
                    return null;
                }
            }.execute();
        }
    }

    public void deleteTask(final Stock stock) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void...voids) {
                stockDatabase.daoAccess().deleteTask(stock);
                return null;
            }
        }.execute();
    }

    public LiveData<Stock> getTask(int id) {
        return stockDatabase.daoAccess().getTask(id);
    }
    public LiveData<List<Stock>> getTasks() {
        return stockDatabase.daoAccess().fetchAllTask();
    }
}
