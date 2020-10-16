package com.example.personalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.personalassignment.adapter.PaymentAdapter;
import com.example.personalassignment.adapter.ProductAdapter;
import com.example.personalassignment.model.Product;

import java.util.ArrayList;

public class PayementAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payement);
        TextView displayPrice = findViewById(R.id.sumofprice);
        Intent intent =getIntent();
        int sumofprice = 0;
        ArrayList<Product> getdata = (ArrayList<Product>) intent.getSerializableExtra("conveydata");
        System.out.println(getdata);
        for(Product product :getdata){
            sumofprice+=Integer.parseInt(product.getPrice()); // 총 값
        }
        PaymentAdapter adapter = new PaymentAdapter(getdata);
        ListView listView = findViewById(R.id.payment_list);
        listView.setAdapter(adapter);
        displayPrice.setText(Integer.toString(sumofprice));
    }
}