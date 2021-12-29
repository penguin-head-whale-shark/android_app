package com.example.myapplication;

public class UserGet {
    private String success;

    private int code;

    private String msg;

    private String data;

    public UserGet(String success, int code, String msg, String data) {

        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
