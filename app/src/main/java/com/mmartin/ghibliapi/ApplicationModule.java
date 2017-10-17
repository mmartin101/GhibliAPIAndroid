package com.mmartin.ghibliapi;

import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by mmartin on 10/11/17.
 */
@Module
public abstract class ApplicationModule {
    @Binds
    abstract Context bindContext(App application);
}
