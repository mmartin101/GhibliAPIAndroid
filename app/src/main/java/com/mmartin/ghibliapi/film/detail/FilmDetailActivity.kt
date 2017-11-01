package com.mmartin.ghibliapi.film.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.mmartin.ghibliapi.App
import com.mmartin.ghibliapi.R
import com.mmartin.ghibliapi.di.component.DaggerFilmDetailComponent
import kotlinx.android.synthetic.main.content_film_detail.*
import javax.inject.Inject

class FilmDetailActivity : AppCompatActivity(), FilmDetailContract.View {
    @Inject
    lateinit var presenter: FilmDetailPresenter
    var filmId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFilmDetailComponent.builder().repositoryComponent(App.getApp(this).repositoryComponent).build().inject(this)
        setContentView(R.layout.activity_film_detail)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        filmId = intent?.getStringExtra("film")
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
        presenter.filmId = filmId
        presenter.start()
        setLoadingIndicator(true)
    }


    override fun setLoadingIndicator(active: Boolean) {

    }

    override fun showMissingFilm() {

    }

    override fun showTitle(title: String) {
        film_title_text_view.text = title
    }

    override fun showDescription(description: String) {
        film_description_text_view.text = description
    }

    override fun showDirector(director: String) {
        film_director.text = getString(R.string.director, director)
    }

    override fun showProducer(producer: String) {
        film_producer.text = getString(R.string.producer, producer)
    }

    override fun showPeople() {

    }

    companion object {
        fun newIntent(c: Context, filmId: String): Intent {
            val intent = Intent(c, FilmDetailActivity::class.java)
            intent.putExtra("film", filmId)
            return intent
        }
    }
}
