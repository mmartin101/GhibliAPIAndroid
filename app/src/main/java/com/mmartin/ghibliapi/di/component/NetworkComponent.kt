package com.mmartin.ghibliapi.di.component

import com.mmartin.ghibliapi.network.GhibliApi
import com.mmartin.ghibliapi.di.module.NetworkModule
import dagger.Component

/**
 * Created by mmartin on 10/22/17.
 */
@Component(modules = arrayOf(NetworkModule::class))
interface NetworkComponent {
    fun ghibliApi(): GhibliApi
}