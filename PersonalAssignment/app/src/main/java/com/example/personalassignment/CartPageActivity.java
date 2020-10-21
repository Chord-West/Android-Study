package com.example.personalassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.personalassignment.adapter.CartAdapter;
import com.example.personalassignment.model.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CartPageActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference cartDBRef = database.getReference().child("data");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        final ArrayList<Product> data = new ArrayList<>();

        final ListView listView = findViewById(R.id.product_cart_view);
        final Button deleteBtn = findViewById(R.id.cart_delete_btn);
        final Button mvhomeBtn = findViewById(R.id.cart_backhome_btn);
        final Button mvpayBtn = findViewById(R.id.cart_payment_btn);
        ValueEventListener mValueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data.clear();
                for (DataSnapshot datasnapshot : snapshot.getChildren()) {
                    Product product = datasnapshot.getValue(Product.class);
                    product.setKey(datasnapshot.getKey());
                    data.add(product);
                }
                CartAdapter adapter = new CartAdapter(data);
                listView.setAdapter(adapter);
                deleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (Product product : data) {
                            if (product.isCheck()) {
                                cartDBRef.child(product.getKey()).removeValue();
                            }
                        }
                    }
                });
                mvpayBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<Product> conveydata= new ArrayList<>();
                        for (Product product : data) {
                            if (product.isCheck()) {
                                conveydata.add(product);
                            }
                        }
                        if(conveydata.isEmpty()){
                            Toast.makeText(CartPageActivity.this,"제품을 선택해주세요", Toast.LENGTH_SHORT).show();
                        }else{
                            Intent intent = new Intent(getApplicationContext(), PayementActivity.class);
                            intent.putExtra("conveydata",conveydata);
                            startActivity(intent);
                        }
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("error");
            }
        };
        cartDBRef.addValueEventListener(mValueEventListener);
        mvhomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartPageActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }


}