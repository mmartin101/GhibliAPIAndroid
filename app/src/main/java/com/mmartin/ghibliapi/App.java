package com.mmartin.ghibliapi;

import android.app.Application;

/**
 * Created by mmartin on 10/11/17.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
    }
}
