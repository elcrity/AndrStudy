package com.example.a012hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView sCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);//mainActivity에서 추가한 인텐트를 String으로 입력
        TextView textView = findViewById(R.id.count_Second);//textView에 text_message의 주소를 삽입
        textView.setText(message);//textView를 mainActivity에서 얻어온 추가 인텐트(message)값으로 설정
    }
}