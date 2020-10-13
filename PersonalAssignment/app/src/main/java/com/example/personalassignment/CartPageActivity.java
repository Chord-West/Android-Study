package com.example.personalassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.personalassignment.model.DB;
import com.example.personalassignment.model.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartPageActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference cartDBRef = database.getReference().child("data");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        final Map<String,Object> object=new HashMap<>();
        final ArrayList<Product> data = new ArrayList<>();
        cartDBRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot datasnapshot : snapshot.getChildren()) {
                    object.put(datasnapshot.getKey(), datasnapshot.getValue());
                    Product product = datasnapshot.getValue(Product.class);
                    System.out.println(product);
//                    data.add(new Product(datasnapshot.getChildren().toString()));
                }
                for(Product product : data){

                }


                //System.out.println(data);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        System.out.println(data);
    }

}