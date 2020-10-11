package com.example.personalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button paymentBtn=findViewById(R.id.payment_btn);
        Button cartBtn=findViewById(R.id.cart_btn);
        final ArrayList<Product> data = new ArrayList<>();
//        database에 저장된 내용 for문으로 list에 뿌리기
//        for(int i=0; i< databaseList().length;i++){
//            data.add(new Product("상의","23000","top"));
//        }
        data.add(new Product("겉옷", "80000", "outer"));
        data.add(new Product("상의", "40000", "top"));
        data.add(new Product("바지", "35000", "bottom"));

        final ProductAdapter adapter = new ProductAdapter(data);

        final ListView listView = findViewById(R.id.product_select_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, position + "아이템선택", Toast.LENGTH_SHORT).show();
                System.out.println(position);
            }
        });
        paymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Product i : data){
                    System.out.println(i.isCheck());
                    Toast.makeText(MainActivity.this, i.isCheck() + "아이템선택", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}