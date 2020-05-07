package com.example.investmentideas;

import java.io.IOException;

public interface StockDatasource {
    CompanyDetails getCompanyDetails(String id) throws IOException;

    Company[] getCompanyList() throws IOException;





}

