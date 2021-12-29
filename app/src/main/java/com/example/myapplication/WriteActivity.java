package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public class WriteActivity extends AppCompatActivity {

    public static String Title;
    public static String Content;

    Toolbar toolbar;

    Fragment fragment1;
    Fragment fragment2;

    TextView title;
    TextView main;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);


        String name = ResisterActivity.Name;
        String Token = MainActivity.st;

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        fragment1 = new Fragment();
        fragment2 = new Fragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("건의 사항"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("WriteActivity","선택 : " + position);

                Fragment selected = null;
                if(position == 0){
                    selected = fragment1;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        Button write = findViewById(R.id.write);

        main = findViewById(R.id.write_main);
        title = findViewById(R.id.write_title);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginResultActivity.class);

                Title = title.getText().toString();
                Content = main.getText().toString();


                Call<WriteResult> call = WriteActivity.RetrofitServiceImplFactory.Post().setPost(Title,Content,MainActivity.Id);

                call.enqueue(new Callback<WriteResult>() {
                    @Override
                    public void onResponse(Call<WriteResult> call, Response<WriteResult> response) {
                        if(response.isSuccessful()){
                            Log.d("성공","성공입니당");
                            LoginResultActivity.iscreated = true;
                            startActivity(i);
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(), "알 수 없는 오류", Toast.LENGTH_SHORT).show();
                            Log.d("서주영", "실패");
                        }
                    }

                    @Override
                    public void onFailure(Call<WriteResult> call, Throwable t) {

                    }
                });

            }
        });

    }

    public interface Service{
        @FormUrlEncoded
        @POST("/api/v1/suggestion/add-suggestion")
        Call<WriteResult> setPost(@Field("title") String title
                , @Field("content") String content
                , @Field("writerId") String writerId);

        @GET("/api/v1/user")
        Call<UserGet> user(@Field("Token") String Token);

    }

    static class RetrofitServiceImplFactory{
        private static Retrofit getretrofit(){
            return new Retrofit.Builder()
                    .baseUrl("https://f93e-58-238-74-139.ngrok.io/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        public static WriteActivity.Service Post(){
            return getretrofit().create(Service.class);
        }
    }
}
