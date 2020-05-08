package com.example.investmentideas.domain;

import java.io.IOException;
import java.util.ArrayList;

public interface StockDatasource {
    CompanyDetails getCompanyDetails(String id) throws IOException;

    ArrayList<Company> getCompanyList() throws IOException;





}

