package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Changectivity extends AppCompatActivity {

    TextView title;
    TextView main;

    public static String Title,Content;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        title = findViewById(R.id.write_title);
        main = findViewById(R.id.write_main);


        title.setText(WriteActivity.Title);
        main.setText(WriteActivity.Content);

        if(LoginResultActivity.ga == 1){
            title.setText(Changectivity.Title);
            main.setText(Changectivity.Content);
            LoginResultActivity.ga = 0;
        }

        Button w = findViewById(R.id.write);


        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginResultActivity.class);
            LoginResultActivity.ischange = true;
                Title = title.getText().toString();
                Content = main.getText().toString();
                startActivity(i);
                finish();
            }
        });



    }
}
