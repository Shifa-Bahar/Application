package com.example.lifepharmacy.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifepharmacy.ModelResponse.MyOrder.DatumOrder;
import com.example.lifepharmacy.ModelResponse.MyOrder.MyOrderResponse;
import com.example.lifepharmacy.R;
import com.example.lifepharmacy.data.RetrofitClient;
import com.example.lifepharmacy.helpers.MyOrderAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyOrder extends AppCompatActivity {
    private RecyclerView recyclerView;

    private String token = "957362|BCjqofWbk4dC4zM6nqmIwJZH5fFygYjBRUCfFq1x";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);


        recyclerView = findViewById(R.id.recycleView);
        Call<MyOrderResponse> call = RetrofitClient.getInstance().getApi().getOrder("Bearer "+token);
        call.enqueue(new Callback<MyOrderResponse>() {
            @Override
            public void onResponse(Call<MyOrderResponse> call, Response<MyOrderResponse> response) {
                if(response.isSuccessful()){
                    List<DatumOrder> arr1 = response.body().getData();
                    if(arr1 != null) {
                        recyclerView.setVisibility(View.VISIBLE);
                        MyOrderAdapter adapter = new MyOrderAdapter(arr1);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MyOrder.this));
                    }
                    else {
                        Toast.makeText(MyOrder.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(MyOrder.this, "response fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MyOrderResponse> call, Throwable t) {
                Toast.makeText(MyOrder.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}