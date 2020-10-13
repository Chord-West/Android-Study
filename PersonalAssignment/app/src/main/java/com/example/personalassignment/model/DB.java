package com.example.personalassignment.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class DB {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabase=database.getReference();
    public void addCartData(String title, String price, String category){
//
//        mDatabase.child("data").push().setValue(product);
        String key = mDatabase.child("data").push().getKey();
        Product product = new Product(title,price,category);
        Map<String, Object> childUpdates = new HashMap<>();

        childUpdates.put("/data/" + key, product);
        mDatabase.updateChildren(childUpdates);
    }
}
