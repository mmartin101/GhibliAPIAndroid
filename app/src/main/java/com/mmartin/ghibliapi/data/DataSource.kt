package com.mmartin.ghibliapi.data

import io.reactivex.Flowable

/**
 * Created by mmartin on 2/3/18.
 */
abstract class DataSource<T> {
    open val isEmpty: Boolean
        get() = false

    abstract val allItems: Flowable<List<T>>

    abstract fun getItem(id: String): Flowable<T>

    internal open fun store(itemList: List<T>) {}

    internal open fun store(item: T) {}
}