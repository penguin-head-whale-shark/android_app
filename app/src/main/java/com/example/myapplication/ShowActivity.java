package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.GET;

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
        TextView name = findViewById(R.id.name_write);


        title.setText(WriteActivity.Title);
        main.setText(WriteActivity.Content);
        name.setText(MainActivity.Id);

        if(LoginResultActivity.ischange){
            title.setText(Changectivity.Title);
            main.setText(Changectivity.Content);
            LoginResultActivity.ischange = false;
        }


        delete = findViewById(R.id.delete_show);
        change = findViewById(R.id.change_show);
        l = (LinearLayout) findViewById(R.id.linearLayout);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Changectivity.class);
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

    public interface Service{
        @GET("/api/v1/user")
        Call<UserGet> call(@Field("Token") String Token);
    }

    static class RetrofitServiceImplFactory{
        private static Retrofit getretrofit(){
            return new Retrofit.Builder()
                    .baseUrl("https://f93e-58-238-74-139.ngrok.io/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        public static ShowActivity.Service Post(){
            return getretrofit().create(Service.class);
        }
    }
}
