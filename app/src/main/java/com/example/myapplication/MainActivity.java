package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE = 1000;

    private EditText mNameEditText;
    private EditText mAgeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText =findViewById(R.id.name_edit);
        mAgeEditText = findViewById(R.id.age_edit);

        findViewById(R.id.submit_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,DisplayMessageActivity.class);

        intent.putExtra("name",mNameEditText.getText().toString());
        intent.putExtra("age",mAgeEditText.getText().toString());

        startActivityForResult(intent,REQUEST_CODE);
    }

//    반환받는 메소드
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK && data!=null){
            String result = data.getStringExtra("result");
            Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
        }
    }

}