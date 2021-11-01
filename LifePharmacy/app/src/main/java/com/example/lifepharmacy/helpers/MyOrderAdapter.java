package com.example.lifepharmacy.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lifepharmacy.ModelResponse.MyOrder.DatumOrder;
import com.example.lifepharmacy.R;

import java.util.List;

public class MyOrderAdapter extends
        RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    private List<DatumOrder> mdata;

    public MyOrderAdapter(List<DatumOrder> data) {
        mdata = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView orderNumber;
        public TextView orderStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            orderNumber = (TextView) itemView.findViewById(R.id.orderNumber);
            orderStatus = (TextView) itemView.findViewById(R.id.orderStatus);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.order_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyOrderAdapter.ViewHolder holder, int position) {
        DatumOrder data = mdata.get(position);

        TextView orderNumber = holder.orderNumber;
        orderNumber.setText(data.getOrderNumber());

        TextView orderStatus = holder.orderStatus;
        orderStatus.setText(data.getStatusLabel());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

}
