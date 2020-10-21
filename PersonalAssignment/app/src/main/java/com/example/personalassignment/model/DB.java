package com.example.personalassignment.model;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ObjectStreamException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabase=database.getReference();
    public Map<String,Object> result = new HashMap<>();
    public void addCartData(String title, String price, String category){
        String key = mDatabase.child("data").push().getKey();
        Product product = new Product(title,price,category);
        Map<String,Object> postValues = product.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/data/" + key, postValues);
        mDatabase.updateChildren(childUpdates);
    }

}
