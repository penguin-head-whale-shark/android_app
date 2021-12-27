   package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginResultActivity extends AppCompatActivity {

    TextView TextView_get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String email = bundle.getString("id");
        String password = bundle.getString("password");

        TextView_get.setText(email + " + "+password);
    }
}