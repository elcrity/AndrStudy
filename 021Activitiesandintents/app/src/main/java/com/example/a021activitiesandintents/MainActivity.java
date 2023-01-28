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
    private EditText mMessageEditText;
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    @Override//요청 코드, 결과 코드(RESULT_OK or Cancled), 인텐트 데이터를 입력값으로 받음
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TEXT_REQUEST){//텍스트 리퀘스트 값과 요청코드가 같고
            if(resultCode == RESULT_OK){//결과 코드가 RESULT_OK라면
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                //SecondActivity.EXTRA_REPLY의 값(reply)를 String형태의 데이터로 reply에 입력
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
                //그후 헤더 가시성을 visible, 텍스트 내용을 reply로 입력 후 가시성 visible로 변경
            }

        }
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();//mMessageEditTExt의 텍스트를 message에 입력
        intent.putExtra(EXTRA_MESSAGE, message);//인텐트에 EXTRA...를 키로 message를 값으로 추가
        startActivityForResult(intent,TEXT_REQUEST);

    }
}