package com.mmartin.ghibliapi

import android.content.Context
import android.support.multidex.MultiDexApplication
import com.mmartin.ghibliapi.di.component.AppComponent
import com.mmartin.ghibliapi.di.component.DaggerAppComponent
import com.mmartin.ghibliapi.di.component.DaggerRepositoryComponent
import com.mmartin.ghibliapi.di.component.RepositoryComponent
import com.mmartin.ghibliapi.di.module.ApplicationModule
import timber.log.Timber

/**
 * Application class for this app
 * init dagger components and other important libraries here
 *
 * Created by mmartin on 10/11/17.
 */

class App : MultiDexApplication() {
    lateinit var appComponent: AppComponent
        internal set
    lateinit var repositoryComponent: RepositoryComponent
        internal set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().applicationModule(ApplicationModule(this)).build()
        repositoryComponent = DaggerRepositoryComponent.builder().appComponent(appComponent).build()
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        fun getApp(context: Context): App {
            return context.applicationContext as App
        }
    }
}
