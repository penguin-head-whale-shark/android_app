package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class PostResult {
    @SerializedName("id")
    private String id;
    @SerializedName("password")
    private String password;

    // @SerializedName으로 일치시켜 주지않을 경우엔 클래스 변수명이 일치해야함

    @SerializedName("name")
    private String name;
    // @SerializedName()로 변수명을 입치시켜주면 클래스 변수명이 달라도 알아서 매핑시켜줌

    @SerializedName("isTeacher")
    private boolean isteacher;

    @SerializedName("school")
    private String school;

}
