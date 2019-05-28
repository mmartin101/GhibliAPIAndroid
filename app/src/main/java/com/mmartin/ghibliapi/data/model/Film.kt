package com.mmartin.ghibliapi.data.model

import androidx.room.*
import com.mmartin.ghibliapi.network.moshi.UrlsWithId
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * Model for Film objects
 *
 * Created by mmartin on 4/10/17.
 */
@Entity
data class Film(
        @PrimaryKey var id: String,
        var title: String? = null,
        var description: String? = null,
        var director: String? = null,
        var producer: String? = null,
        var release_date: String? = null,
        var rtScore: Int? = null,
        var url: String? = null,
        var expirationDate: Long
) {
    @UrlsWithId
    @Ignore
    var people: List<String>? = null
    @UrlsWithId
    @Ignore
    var species: List<String>? = null
    @UrlsWithId
    @Ignore
    var locations: List<String>? = null
    @UrlsWithId
    @Ignore
    var vehicles: List<String>? = null
}

@Dao
interface FilmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilms(vararg films: Film): Completable

    @Query("SELECT * FROM film")
    fun loadAllFilms(): Flowable<List<Film>>

    @Query("SELECT * FROM film WHERE film.id IS :id LIMIT 1")
    fun getFilm(id: String): Flowable<Film>
}
