package com.example.personalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Product> data = new ArrayList<>();
//        database에 저장된 내용 for문으로 list에 뿌리기
//        for(int i=0; i< databaseList().length;i++){
//            data.add(new Product("상의","23000","top"));
//        }
        data.add(new Product("겉옷","80000","outer"));
        data.add(new Product("상의","40000","top"));
        data.add(new Product("바지","35000","bottom"));
        ProductAdapter adapter = new ProductAdapter(data);

        ListView listView = findViewById(R.id.product_select_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,position+"아이템선택",Toast.LENGTH_SHORT).show();
            }
        });
    }
}