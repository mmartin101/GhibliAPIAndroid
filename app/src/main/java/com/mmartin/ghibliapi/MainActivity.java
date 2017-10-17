package com.mmartin.ghibliapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.mmartin.ghibliapi.film.Film;
import com.mmartin.ghibliapi.film.detail.FilmDetailActivity;
import com.mmartin.ghibliapi.film.FilmRecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private Unbinder unbinder;
    private FilmRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null) {
                    Film film = adapter.getItemAt(recyclerView.getChildAdapterPosition(child));
                    if (film != null) {
                        startActivity(FilmDetailActivity.newIntent(getBaseContext(), film));
                        return true;
                    }
                }

                return false;
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                gestureDetector.onTouchEvent(e);
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            }
        });
        adapter = new FilmRecyclerViewAdapter();
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        alphaAdapter.setDuration(1000);
        recyclerView.setAdapter(alphaAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getFilms();
    }

    private void getFilms() {
//        GhibliApi.getInstance().getFilmService().getFilms().enqueue(new Callback<List<Film>>() {
//            @Override
//            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
//                if (response.isSuccessful()) {
//                    adapter.addAll(response.body());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Film>> call, Throwable t) {
//                Timber.e(t, "Error getting films...");
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }
}
