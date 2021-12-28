package com.example.myapplication;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;
import android.widget.LinearLayout;

import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import android.widget.LinearLayout;

import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText TextInputEditText_id, TextInputEditText_password;
    LinearLayout Login_Button;//변수로 만듬
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView t = findViewById(R.id.resisterText);

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ResisterActivity.class);
                startActivity(i);
            }
        });


        LinearLayout login = findViewById(R.id.Login_Button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginResultActivity.class);
                startActivity(i);
            }
        });

        setContentView(R.layout.activity_login);


        setContentView(R.layout.activity_login);

    }

}