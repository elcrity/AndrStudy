package com.example.a021activitiesandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE  =
            "com.example.android.twoactivities.extra.MESSAGE";
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override//요청 코드, 결과 코드(RESULT_OK or Cancled), 인텐트 데이터를 입력값으로 받음
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void firstSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = "abc";//mMessageEditTExt의 텍스트를 message에 삽입
        intent.putExtra(EXTRA_MESSAGE, message);//인텐트에 EXTRA...를 키로 message를 값으로 추가
        startActivityForResult(intent,TEXT_REQUEST);
    }

    public void secondSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = "123";//mMessageEditTExt의 텍스트를 message에 삽입
        intent.putExtra(EXTRA_MESSAGE, message);//인텐트에 EXTRA...를 키로 message를 값으로 추가
        startActivityForResult(intent,TEXT_REQUEST);

    }

    public void thirdSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = "ㄱㄴㄷ";//mMessageEditTExt의 텍스트를 message에 삽입
        intent.putExtra(EXTRA_MESSAGE, message);//인텐트에 EXTRA...를 키로 message를 값으로 추가
        startActivityForResult(intent,TEXT_REQUEST);

    }
}