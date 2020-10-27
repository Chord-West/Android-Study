package com.example.callbackexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ColorFragment colorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_color);

    }
}