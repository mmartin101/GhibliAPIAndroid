package com.mmartin.ghibliapi.data

import com.mmartin.ghibliapi.data.model.Person
import com.mmartin.ghibliapi.di.Local
import com.mmartin.ghibliapi.di.Remote
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by mmartin on 2/3/18.
 */
class PeopleRepository @Inject
constructor(@Remote val remoteDataSource: DataSource<Person>, @Local val localDataSource: DataSource<Person>) : DataSource<Person>() {
    override val allItems: Single<List<Person>>
        get() {
            return if (localDataSource.isEmpty) {
                remoteDataSource.allItems
                        .map {
                            localDataSource.store(it)
                            it
                        }
            } else {
                localDataSource.allItems
            }
        }

    override fun getItem(id: String): Single<Person> {
        return if (localDataSource.isEmpty) {
            remoteDataSource.getItem(id)
                    .map {
                        localDataSource.store(it)
                        it
                    }
        } else {
            localDataSource.getItem(id)
        }
    }
}