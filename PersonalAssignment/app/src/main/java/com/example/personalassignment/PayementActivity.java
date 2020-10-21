package com.example.personalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.personalassignment.adapter.PaymentAdapter;
import com.example.personalassignment.adapter.ProductAdapter;
import com.example.personalassignment.model.Product;

import java.util.ArrayList;

public class PayementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payement);
        TextView displayPrice = findViewById(R.id.sumofprice);
        Button decide_btn=findViewById(R.id.decide_purchase);
        Button cancle_btn=findViewById(R.id.cancle_purchase);
        final EditText address = findViewById(R.id.address_info);
        final EditText phonenumber = findViewById(R.id.Phonenumber_info);
        final Intent intent =getIntent();
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
        decide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phonenumber.getText().toString();
                String ad = address.getText().toString();
                if(phone.getBytes().length<=0||ad.getBytes().length<=0){
                    Toast.makeText(PayementActivity.this,"정보를 채워주세요", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(PayementActivity.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });
        cancle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PayementActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}