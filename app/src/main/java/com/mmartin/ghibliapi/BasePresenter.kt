package com.mmartin.ghibliapi

/**
 * Created by mmartin on 8/12/17.
 */

interface BasePresenter<in BaseView> {
    fun start()
    fun attachView(view: BaseView)
}
