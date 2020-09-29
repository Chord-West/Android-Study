package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class AppListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);
        ListView listView = findViewById(R.id.list_view);

        PackageManager pm = getPackageManager();
        List<ApplicationInfo> infos =pm.getInstalledApplications(PackageManager.GET_META_DATA);
        //기기에 설치된 모든 목록을 가져옴

        AppInfoAdapter adapter = new AppInfoAdapter(infos);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ApplicationInfo info = (ApplicationInfo) parent.getAdapter().getItem(position);
                Intent intent = new Intent(); // 데이터를 담기위해 Intent
                intent.putExtra("info",info);
                setResult(RESULT_OK,intent);
                finish(); // 화면 닫기
            }
        });
    }
}