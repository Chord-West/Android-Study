package com.example.personalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Product> data = new ArrayList<>();
//        database에 저장된 내용 for문으로 list에 뿌리기
//        for(int i=0; i< databaseList().length;i++){
//
//            data.add(new Weather("수원","25도","맑음"));
//        }


    }
}