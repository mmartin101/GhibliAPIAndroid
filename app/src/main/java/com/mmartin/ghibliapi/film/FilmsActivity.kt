package com.mmartin.ghibliapi.film

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import com.mmartin.ghibliapi.App
import com.mmartin.ghibliapi.R
import com.mmartin.ghibliapi.data.model.Film
import com.mmartin.ghibliapi.di.component.DaggerFilmsComponent
import com.mmartin.ghibliapi.film.detail.FilmDetailActivity
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * Created by mmartin on 10/13/17.
 */
class FilmsActivity : AppCompatActivity(), FilmsContract.View {
    lateinit var adapter: FilmRecyclerViewAdapter
    @Inject
    lateinit var presenter: FilmsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFilmsComponent.builder().repositoryComponent(App.getApp(this).repositoryComponent).build().inject(this)
        setContentView(R.layout.activity_main)

        val gestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                val child = recycler_view.findChildViewUnder(e.x, e.y)
                if (child != null) {
                    val film = adapter.getItemAt(recycler_view.getChildAdapterPosition(child))
                    if (film != null) {
                        startActivity(FilmDetailActivity.newIntent(baseContext, film.id))
                        return true
                    }
                }

                return false
            }
        })
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {

            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                gestureDetector.onTouchEvent(e)
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
        })
        adapter = FilmRecyclerViewAdapter()
        val alphaAdapter = AlphaInAnimationAdapter(adapter)
        alphaAdapter.setDuration(1000)
        recycler_view.adapter = alphaAdapter
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
        presenter.start()
        setLoadingIndicator(true)
    }

    override fun setLoadingIndicator(active: Boolean) {
        progressBar.visibility = if (active) View.VISIBLE else View.GONE
    }

    override fun showFilms(filmList: List<Film>) {
        adapter.addAll(filmList)
        setLoadingIndicator(false)
    }

    override fun showError() {
        Snackbar.make(recycler_view, "unable to load data :(", Snackbar.LENGTH_LONG).show()
    }
}
