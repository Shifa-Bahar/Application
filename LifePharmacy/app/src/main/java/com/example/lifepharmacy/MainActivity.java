package com.example.lifepharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lifepharmacy.Activity.CreatePrescription;
import com.example.lifepharmacy.Activity.MyOrder;
import com.example.lifepharmacy.Activity.SearchProduct;

public class MainActivity extends AppCompatActivity {
    Button searchProduct,myOrder,createPrescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchProduct = findViewById(R.id.searchProduct);
        myOrder=findViewById(R.id.myOrder);
        createPrescription = findViewById(R.id.createPrescription);

        searchProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchProduct();
            }
        });
        myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOrder();
            }
        });
        createPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPrescription();
            }
        });
    }
    private void searchProduct() {
        Intent intent = new Intent(this, SearchProduct.class);
        startActivity(intent);
    }
    private void myOrder() {
        Intent intent = new Intent(this, MyOrder.class);
        startActivity(intent);
    }
    private void createPrescription() {
        Intent intent = new Intent(this, CreatePrescription.class);
        startActivity(intent);
    }
}