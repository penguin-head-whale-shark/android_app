package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    TextView delete;
    TextView change;
    LinearLayout l;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_write);

        TextView title = findViewById(R.id.title_show);
        TextView main = findViewById(R.id.main_show);
        Intent b = getIntent();

        title.setText(b.getStringExtra("제목"));
        main.setText(b.getStringExtra("내용"));



        delete = findViewById(R.id.delete_show);
        change = findViewById(R.id.change_show);
        l = (LinearLayout) findViewById(R.id.linearLayout);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Changectivity.class);
                i.putExtras(b.getExtras());
                startActivity(i);
                finish();
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginResultActivity.class);
                i.putExtra("삭제",1);
                startActivity(i);
                finish();
            }
        });
    }
}
