package com.example.a021activitiesandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    private EditText mReply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);//mainActivity에서 추가한 인텐트를 String으로 입력
        TextView textView = findViewById(R.id.text_message);//textView에 text_message의 주소를 삽입
        textView.setText(message);//textView를 mainActivity에서 얻어온 추가 인텐트(message)값으로 설정
        mReply = findViewById(R.id.editText_second);
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }
}