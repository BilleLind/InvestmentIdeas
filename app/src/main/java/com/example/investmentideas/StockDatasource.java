package com.example.investmentideas;

import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;

public interface StockDatasource {
    StockQuote getStockQuote(String id);
    ArrayList<StockQuote> getStockQuoteList();





}

