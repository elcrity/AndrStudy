package com.example.a012hellotoast;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE  =
            "com.example.android.twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if(mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        mCount++;
        String message = Integer.toString(mCount);//mMessageEditTExt의 텍스트를 message에 삽입
        intent.putExtra(EXTRA_MESSAGE, message);//인텐트에 EXTRA...를 키로 message를 값으로 추가
        startActivityForResult(intent,TEXT_REQUEST);

    }
}