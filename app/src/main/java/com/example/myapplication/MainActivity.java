package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("실행 성공");
    }
    public void onButton1Clicked(View v){//context 는 환경정보를 담음
        Toast.makeText(this,"버튼이 눌렸어요",Toast.LENGTH_LONG).show();
        System.out.println("실행 완료");
    }
    public void onButton3Clicked(View v){
        Toast.makeText(this,"검색이 눌렸어요",Toast.LENGTH_LONG).show();
    }
}