package com.example.lifepharmacy.helpers;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lifepharmacy.ModelResponse.SearchProduct.Datum;
import com.example.lifepharmacy.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private List<Datum> mdata;

    public CustomAdapter(List<Datum> data) {
        mdata = data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
         TextView productName;


        public ViewHolder(View view) {
            super(view);
            productName = (TextView) view.findViewById(R.id.productName);
        }

        public TextView getTextView() {
            return productName;
        }
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_list, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Datum data = mdata.get(position);
        viewHolder.getTextView().setText((CharSequence) mdata.get(position));
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

}
