package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText TextInputEditText_email, TextInputEditText_password;
    LinearLayout Login_Button;//변수로 만듬
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextInputEditText_email = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        Login_Button = findViewById(R.id.Login_Button);//변수에 뷰에서 찾아온 컴포넌트와 연결

        //값을 가져온다 -> 클릭을 감지한다 ->  가져온 값을 다른 액티비티로 넘김
        Login_Button.setClickable(true);//이 컴포넌트는 클릭을 가능하다고 설정
        Login_Button.setOnClickListener(new View.OnClickListener() { //새로운 리스너 달아줌
            @Override
            public void onClick(View v){
                String email = TextInputEditText_email.getText().toString();//입력한 값을 문자열로 반환
                String password = TextInputEditText_password.getText().toString();//입력한 값을 문자열로 반환
                Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }
}