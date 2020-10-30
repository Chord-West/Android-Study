package com.example.recyclerviewexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerAdapter.MyRecyclerViewClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this); // 리스트뷰랑 동일
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager); // 레이아웃 메니저를 선언해야 recyclerview 작동

        List<CardItem> dataList = new ArrayList<>();
        for(int i = 0; i<10; i++){
            dataList.add(new CardItem(i+"첫번째","설명"+i));
        }
        // 클릭이벤트는 보통 어댑터에 적용
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(dataList);
        recyclerView.setAdapter(adapter);

        adapter.setOnClickListener(this);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this,""+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShareButtonClicked(int position) {
        Toast.makeText(this,"share"+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLearnMoreButtonClicked(int position) {
        Toast.makeText(this,"more"+position,Toast.LENGTH_SHORT).show();
    }
}