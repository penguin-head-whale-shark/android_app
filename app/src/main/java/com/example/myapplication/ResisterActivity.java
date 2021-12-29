package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

public class ResisterActivity extends AppCompatActivity {
    TextInputEditText name,school,id,pwd,repwd;
    Button res_btn;
    String Name,School,Id,Pwd,RePwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resister);
        name =findViewById(R.id.name);
        school =findViewById(R.id.school);
        id = findViewById(R.id.ID);
        pwd = findViewById(R.id.PW);
        repwd = findViewById(R.id.REPW);
        res_btn = findViewById(R.id.Resisterbtn);
        res_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name = name.getText().toString();
                School=school.getText().toString();
                Id=id.getText().toString();
                Pwd=pwd.getText().toString();

            }
        });

    }
}