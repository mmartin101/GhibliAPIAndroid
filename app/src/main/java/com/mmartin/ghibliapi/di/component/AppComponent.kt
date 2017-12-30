package com.mmartin.ghibliapi.di.component

import com.mmartin.ghibliapi.App
import com.mmartin.ghibliapi.di.module.ApplicationModule
import dagger.Component

/**
 * Created by mmartin on 10/11/17.
 */
@Component(modules = arrayOf(ApplicationModule::class))
interface AppComponent {
    fun getApp(): App
}
