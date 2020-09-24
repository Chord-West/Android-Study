package com.example.adapterviewexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터 준비
        ArrayList<Weather> data = new ArrayList<>();
        data.add(new Weather("수원","25도","맑음"));
        data.add(new Weather("서울","26도","비"));
        data.add(new Weather("안양","24도","구름"));
        data.add(new Weather("부산","29도","구름"));
        data.add(new Weather("인천 ","23도","맑음"));
        data.add(new Weather("대구","28도","비"));
        data.add(new Weather("용인","25도","비"));


        // 어댑터 : View에 데이터를 표시해주는 역할을 함
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1,data);
        MyFirstAdapter adapter = new MyFirstAdapter(data);


        // 뷰 => 어뎁터를 적용
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter); // view 에다 adapter 적용

        //클릭 이벤트 등록
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,position+"번쨰 아이템 선택",Toast.LENGTH_SHORT).show();
            }
        });
    }
}