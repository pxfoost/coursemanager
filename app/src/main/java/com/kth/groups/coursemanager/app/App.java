package com.kth.groups.coursemanager.app;

import android.app.Application;

import com.kth.groups.coursemanager.database.AppDatabase;

public class App extends Application {

    public void onCreate(){
        super.onCreate();
        AppDatabase.init(this);
    }
}
