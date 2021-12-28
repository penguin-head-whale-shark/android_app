package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        TextInputEditText TextInputEditText_id = findViewById(R.id.TextInputEditText_id);
        LinearLayout t = findViewById(R.id.Login_Button);
        TextView res = findViewById(R.id.resister);

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(), ResisterActivity.class);
                startActivity(i);
            }
        });


        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginResultActivity.class);
                String id = TextInputEditText_id.getText().toString();
                String password = TextInputEditText_password.getText().toString();

                startActivity(i);
            }
        });

    }
}