package com.example.personalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.personalassignment.model.Product;

import java.util.ArrayList;

public class PayementAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payement);
        Intent intent =getIntent();
        ArrayList<Product> getdata = (ArrayList<Product>) intent.getSerializableExtra("conveydata");
        System.out.println(getdata);
    }
}