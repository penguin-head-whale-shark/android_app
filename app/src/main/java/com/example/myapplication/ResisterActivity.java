package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class ResisterActivity extends Activity {

    public static String Name;

    public interface RetrofitService{
        @FormUrlEncoded
        @POST("/api/v1/user/sign-up")
        Call<PostResult> setPosts(@Field("id") String id
                , @Field("password") String password
                , @Field("name") String name
                , @Field("isTeacher") boolean teacher
                , @Field("school") String school);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resister);
        TextView id = findViewById(R.id.ID);
        TextView name = findViewById(R.id.name);
        TextView school = findViewById(R.id.school);
        TextView pw = findViewById(R.id.PW);
        TextView repw = findViewById(R.id.REPW);

        Button b = findViewById(R.id.Resisterbtn);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Id = id.getText().toString();
                String Pw = pw.getText().toString();
                Name = name.getText().toString();
                String School = school.getText().toString();

                Call<PostResult> p = ResisterActivity.RetrofitServiceImplFactory.Post().setPosts(Id,Pw,Name,false,School);

                p.enqueue(new Callback<PostResult>() {
                    @Override
                    public void onResponse(Call<PostResult> call, Response<PostResult> response) {
                                Log.d("성공", "성공");
                        if(repw.getText().toString().equals(Pw)) {
                                Log.d("성공", "패스워드");
                            if (response.isSuccessful()) {
                                Log.d("성공", "황지민");
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);
                                finish();
                            }else
                                Toast.makeText(getApplicationContext(),"작성 방식이 잘못 되었습니다.",Toast.LENGTH_SHORT).show();
                        }else
                            Toast.makeText(getApplicationContext(),"작성 방식이 잘못 되었습니다.",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<PostResult> call, Throwable t) {
                        t.printStackTrace();
                        Log.d("실패","서주영");
                    }
                });


            }
        });
    }

    static class RetrofitServiceImplFactory{
        private static Retrofit getretrofit(){
            return new Retrofit.Builder()
                    .baseUrl("https://f93e-58-238-74-139.ngrok.io/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        public static RetrofitService Post(){
            return getretrofit().create(RetrofitService.class);
        }
    }



}