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
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        title = findViewById(R.id.write_title);
        main = findViewById(R.id.write_main);

        Intent b = getIntent();
        title.setText(b.getStringExtra("제목"));
        main.setText(b.getStringExtra("내용"));

        Button w = findViewById(R.id.write);

        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginResultActivity.class);
                i.putExtra("제목",title.getText().toString());
                i.putExtra("내용",main.getText().toString());

                startActivity(i);
                finish();
            }
        });



    }
}
