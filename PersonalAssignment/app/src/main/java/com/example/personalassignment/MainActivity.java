package com.example.personalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.personalassignment.adapter.ProductAdapter;
import com.example.personalassignment.model.DB;
import com.example.personalassignment.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DB db = new DB();
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
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Product product : data){
                    if(product.isCheck()) {
                        Toast.makeText(MainActivity.this, product.isCheck() + "아이템선택", Toast.LENGTH_SHORT).show();
                        db.addCartData(product.getTitle(),product.getPrice(),product.getCategory());
                    }
                }
                Intent intent = new Intent(MainActivity.this,CartPageActivity.class);
                startActivity(intent);
            }
        });
        paymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Product> conveydata= new ArrayList<>();
                for (Product product : data) {
                    if (product.isCheck()) {
                        conveydata.add(product);
                    }
                }
                if(conveydata.isEmpty()){
                    Toast.makeText(MainActivity.this,"제품을 선택해주세요", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(getApplicationContext(), PayementActivity.class);
                    intent.putExtra("conveydata",conveydata);
                    startActivity(intent);
                }

            }
        });
    }

}