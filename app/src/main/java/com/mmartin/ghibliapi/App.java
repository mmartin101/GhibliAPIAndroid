package com.mmartin.ghibliapi;

import android.app.Application;
import android.content.Context;

import com.mmartin.ghibliapi.di.component.AppComponent;
import com.mmartin.ghibliapi.di.component.DaggerAppComponent;
import com.mmartin.ghibliapi.di.component.DaggerRepositoryComponent;
import com.mmartin.ghibliapi.di.component.RepositoryComponent;
import com.mmartin.ghibliapi.di.module.ApplicationModule;

import timber.log.Timber;

/**
 * Created by mmartin on 10/11/17.
 */

public class App extends Application {
    AppComponent appComponent;
    RepositoryComponent repositoryComponent;

    public static App getApp(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().applicationModule(new ApplicationModule(this)).build();

        repositoryComponent = DaggerRepositoryComponent.builder().appComponent(appComponent).build();
        Timber.plant(new Timber.DebugTree());
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public RepositoryComponent getRepositoryComponent() {
        return repositoryComponent;
    }
}
