package com.mmartin.ghibliapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.mmartin.ghibliapi.film.Film;
import com.mmartin.ghibliapi.film.FilmDetailActivity;
import com.mmartin.ghibliapi.film.FilmRecyclerViewAdapter;
import com.mmartin.ghibliapi.retrofit.GhibliApiManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

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
    }

    @Override
    protected void onResume() {
        super.onResume();
        getFilms();
    }

    private void getFilms() {
        GhibliApiManager.getInstance().getFilmService().getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful()) {
                    adapter = new FilmRecyclerViewAdapter();
                    recyclerView.setAdapter(adapter);
                    adapter.addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                Timber.e(t, "Error getting films...");
            }
        });
    }
}
