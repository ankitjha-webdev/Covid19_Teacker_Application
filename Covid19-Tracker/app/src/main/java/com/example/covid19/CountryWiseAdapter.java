package com.example.covid19;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryWiseAdapter extends RecyclerView.Adapter {
    public CountryWiseAdapter(CountryWiseDataActivity countryWiseDataActivity, ArrayList<Constants.CountryWiseModel> countryWiseModelArrayList) {

    }

    public void filterList(ArrayList<Constants.CountryWiseModel> filteredList, String text) {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void notifyDataSetChanged() {
    }
}
