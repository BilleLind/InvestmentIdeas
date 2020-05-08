package com.example.investmentideas.data;

import com.example.investmentideas.domain.Company;

import java.util.ArrayList;

public class CompanyList {
    private ArrayList<Company> companies;

    CompanyList() {};

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<Company> companies) {
        this.companies = companies;
    }
}
