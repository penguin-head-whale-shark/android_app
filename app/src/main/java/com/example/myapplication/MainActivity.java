package com.example.myapplication;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    public static String st;
    public static String Id;

    TextInputEditText TextInputEditText_password;
    TextInputEditText TextInputEditText_id;
    LinearLayout t;
    TextView res;

    String pw, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        TextInputEditText_id = findViewById(R.id.TextInputEditText_id);
        t  = findViewById(R.id.Login_Button);
        res = findViewById(R.id.resister);
        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pw = TextInputEditText_password.getText().toString();
                id = TextInputEditText_id.getText().toString();
                Intent i =new Intent(getApplicationContext(), ResisterActivity.class);
                startActivity(i);
            }
        });


        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginResultActivity.class);
                Id = TextInputEditText_id.getText().toString();
                String password = TextInputEditText_password.getText().toString();

                Call<LoginResult> call = MainActivity.RetrofitServiceImplFactory.Post().setPost(Id,password);

                call.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                            Log.d("성공","성공");
                        if(response.isSuccessful()){
                            st = response.body().getData().toString();
                            Log.d("성공","황지민");
                            startActivity(i);
                            finish();
                        }else
                            Toast.makeText(getApplicationContext(),"비밀번호 혹은 아이디가 다릅니다",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        t.printStackTrace();
                        Log.d("실패","서주영");
                    }
                });
            }
        });

    }

    public interface Service{
        @FormUrlEncoded
        @POST("/api/v1/user/sign-in")
        Call<LoginResult> setPost(@Field("id") String id
                ,@Field("password") String pw);

    }

    static class RetrofitServiceImplFactory{
        private static Retrofit getretrofit(){
            return new Retrofit.Builder()
                    .baseUrl("https://f93e-58-238-74-139.ngrok.io/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        public static MainActivity.Service Post(){
            return getretrofit().create(Service.class);
        }
    }



}