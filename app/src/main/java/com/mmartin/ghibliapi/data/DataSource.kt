package com.mmartin.ghibliapi.data

import io.reactivex.Single

/**
 * Created by mmartin on 2/3/18.
 */
abstract class DataSource<T> {
    open val isEmpty: Boolean
        get() = false

    abstract val allItems: Single<List<T>>

    abstract fun getItem(id: String): Single<T>

    internal open fun store(itemList: List<T>) {}

    internal open fun store(item: T) {}
}