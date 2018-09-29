package com.example.haitao.myapplication;

import android.app.Application;

import com.example.haitao.myapplication.util.Density;

public class TestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Density.setDensity(this, 540);
    }
}
