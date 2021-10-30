package com.example.lifepharmacy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
//import android.widget.SearchView;
import androidx.appcompat.widget.SearchView;

import android.widget.TextView;

import android.widget.Toast;
//import android.widget.SearchView;

import com.example.lifepharmacy.ModelResponse.Datum;
import com.example.lifepharmacy.ModelResponse.SearchProductResponse;
import com.example.lifepharmacy.data.RetrofitClient;
import com.example.lifepharmacy.helpers.ContactsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchProduct extends AppCompatActivity {
    private SearchView searchView;
    private TextView textView;
    private RecyclerView recyclerView;
    String [] arr= {"item 1" ,"item2" ,"item 3"};
    private String token = "957362|BCjqofWbk4dC4zM6nqmIwJZH5fFygYjBRUCfFq1x";
    String str1 = "Panadol";
    String str2 = "panadol";

    private ArrayList<Datum> date = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        searchView = findViewById(R.id.searchProduct);
//        textView = findViewById(R.id.textView);
        recyclerView = findViewById(R.id.recycleView);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query.equals(str1) || query.equals(str2)){
                    productfilter();
                }
                else {
                    Toast.makeText(SearchProduct.this, "product not fount", Toast.LENGTH_SHORT).show();
                }
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.equals(str1) || newText.equals(str2)){
                    productfilter();
                }

                return false;
            }
        });


    }

    private void productfilter() {
        Call<SearchProductResponse> call = RetrofitClient.getInstance().getApi().getProducts("Panadol","Bearer "+token);
        call.enqueue(new Callback<SearchProductResponse>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<SearchProductResponse> call, Response<SearchProductResponse> response) {

                if(response.isSuccessful()) {
                    List<Datum> arr1 = response.body().getData();
                    if(arr1 != null) {
                        recyclerView.setVisibility(View.VISIBLE);
                        ContactsAdapter adapter = new ContactsAdapter(arr1);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(SearchProduct.this));
                    }
                    else {
                        Toast.makeText(SearchProduct.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(SearchProduct.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchProductResponse> call, Throwable t) {
                Toast.makeText(SearchProduct.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}