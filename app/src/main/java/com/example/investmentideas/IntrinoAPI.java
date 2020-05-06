package com.example.investmentideas;

import android.os.AsyncTask;

import com.intrinio.api.SecurityApi;
import com.intrinio.invoker.ApiClient;
import com.intrinio.invoker.ApiException;
import com.intrinio.invoker.Configuration;
import com.intrinio.invoker.auth.ApiKeyAuth;
import com.intrinio.models.ApiResponseSecurityStockPrices;

import org.threeten.bp.LocalDate;

public class IntrinoAPI {
    private ApiClient defaultClient;
    private ApiKeyAuth auth;
    private SecurityApi securityApi;

    public IntrinoAPI() {
         defaultClient = Configuration.getDefaultApiClient();
         securityApi = new SecurityApi();
         auth = (ApiKeyAuth) defaultClient.getAuthentication("ApiKeyAuth");

    }

    public void getStock() {
        auth.setApiKey("OjU4YTg3NWY5NDExZmEzMzkxMTlhMzU1YjAwYzNkNDM5");
        String identifier = "AAPL";
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now();
        String frequency = "daily";
        Integer pagesize = 100;
        //String nextPage = null;
        try {
            ApiResponseSecurityStockPrices result = securityApi.getSecurityStockPrices(identifier, startDate, endDate, frequency, pagesize, null);
            System.out.println(result);

        } catch (ApiException e) {
            System.err.println("Exception when calling SecurityApi#getSecurityStockPrices");
            e.printStackTrace();
        }
    }
}
