package com.mmartin.ghibliapi;

import com.mmartin.ghibliapi.data.GhibliFilmsRepositoryModule;
import com.mmartin.ghibliapi.network.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by mmartin on 10/11/17.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class, GhibliFilmsRepositoryModule.class})
public interface AppComponent {
    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(App application);

        AppComponent build();
    }
}
