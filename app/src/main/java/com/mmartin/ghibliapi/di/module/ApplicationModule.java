package com.mmartin.ghibliapi.di.module;

import com.mmartin.ghibliapi.App;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mmartin on 10/11/17.
 */
@Module
public class ApplicationModule {
    App app;

    public ApplicationModule(App app) {
        this.app = app;
    }

    @Provides
    public App provideApp() {
        return app;
    }
}
