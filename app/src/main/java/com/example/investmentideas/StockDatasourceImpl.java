package com.example.investmentideas;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

public class StockDatasourceImpl implements StockDatasource{
    private OkHttpClient client = new OkHttpClient();

    @Override
    public StockQuote getStockQuote(String id) {
        return null;
    }

    @Override
    public ArrayList<StockQuote> getStockQuoteList() {
        return null;
    }

    public String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try
        {
            response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException();
            }
            return response.body().string();
        } catch(Exception e) {
            throw new IOException();
        } finally {
            response.body().close();
        }
    }
}
