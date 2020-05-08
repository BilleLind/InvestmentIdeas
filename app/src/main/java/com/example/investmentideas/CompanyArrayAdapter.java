package com.example.investmentideas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.investmentideas.Company;
import com.example.investmentideas.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CompanyArrayAdapter extends ArrayAdapter<Company> {
    public CompanyArrayAdapter(Context context, ArrayList<Company> companies) {
        super(context,0, companies);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Company company = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.company, parent, false);

        }
        TextView companyId = (TextView) convertView.findViewById(R.id.companyId);
        TextView companyName = (TextView) convertView.findViewById(R.id.companyName);

        companyId.setText(company.getId());
        companyName.setText(company.getName());

        return convertView;

    }
}
