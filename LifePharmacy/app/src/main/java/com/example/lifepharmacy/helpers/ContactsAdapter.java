package com.example.lifepharmacy.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lifepharmacy.ModelResponse.Datum;
import com.example.lifepharmacy.R;

import java.util.List;


public class ContactsAdapter extends
        RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    private List<Datum> mdata;

    public ContactsAdapter(List<Datum> data) {
        mdata = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView price;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.productName);
            price = (TextView) itemView.findViewById(R.id.price);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);


        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.product_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder holder, int position) {
        Datum data = mdata.get(position);

        TextView textView = holder.nameTextView;
        textView.setText(data.getTitle());

        TextView price = holder.price;
        String s = String.valueOf(data.getPrice());
        price.setText(s);

        ImageView imageView = holder.imageView;


        Glide.with(holder.imageView.getContext())
                .load(data.getImage())
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

}