package com.example.investmentideas.data;

import com.example.investmentideas.domain.Company;
import com.example.investmentideas.domain.CompanyDetails;
import com.example.investmentideas.domain.StockDatasource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;

public class StockDatasourceImpl implements StockDatasource {
    private OkHttpClient client = new OkHttpClient();
    private String idUrl = "https://api-v2.intrinio.com/companies/";
    private String url = "https://api-v2.intrinio.com/companies?api_key=OjU4YTg3NWY5NDExZmEzMzkxMTlhMzU1YjAwYzNkNDM5";
    private static ArrayList<Company> companiesList;

    @Override
    public CompanyDetails getCompanyDetails(String id) throws IOException {
        // Create url to single company
        Request request = new Request.Builder().url(idUrl + id + "?api_key=OjU4YTg3NWY5NDExZmEzMzkxMTlhMzU1YjAwYzNkNDM5").build();
        Response response = client.newCall(request).execute();
        try {
            if (!response.isSuccessful()) {
                throw new IOException();
            }
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(response.body().string(), CompanyDetails.class);
        } catch(Exception e){
            throw new IOException();
        } finally {
            response.body().close();
        }
    }
    @Override
    public ArrayList<Company> getCompanyList() throws IOException {
        //URL for all companies
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        try {
            if (!response.isSuccessful()) {
                throw new IOException();
            }
            Gson gson = new GsonBuilder().create();
            companiesList = gson.fromJson(response.body().string(), CompanyList.class).getCompanies();
            return companiesList;
        } catch(Exception e){
            throw new IOException();
        } finally {
            response.body().close();
        }
    }

    /*public String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response =  client.newCall(request).execute();
        Gson gson = new GsonBuilder().create();
        StockQuote stockQuote = gson.fromJson(response.body().string(), StockQuote.class);
        try
        {
            if (!response.isSuccessful()) {
                throw new IOException();
            }
            System.out.println(stockQuote.getShort_description());
            return stockQuote.getShort_description();

        } catch(Exception e) {
            throw new IOException();
        } finally {
            response.body().close();
        }
    }*/
}
