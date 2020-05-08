package com.example.investmentideas;

import java.io.IOException;
import java.util.ArrayList;

public interface StockDatasource {
    CompanyDetails getCompanyDetails(String id) throws IOException;

    ArrayList<Company> getCompanyList() throws IOException;





}

