package com.mmartin.ghibliapi.film.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mmartin.ghibliapi.R;
import com.mmartin.ghibliapi.film.Film;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmDetailActivity extends AppCompatActivity implements FilmDetailContract.View {
    @BindView(R.id.film_title_text_view)
    TextView titleTextView;
    @BindView(R.id.film_description_text_view)
    TextView descriptionTextView;
    @BindView(R.id.film_director)
    TextView directorTextView;
    @BindView(R.id.film_producer)
    TextView producerTextView;
    @BindView(R.id.content)
    LinearLayout content;

    @Inject
    FilmDetailPresenter presenter;

    public static Intent newIntent(Context c, Film film) {
        Intent intent = new Intent(c, FilmDetailActivity.class);
        intent.putExtra("film", film);
        return intent;
    }

    @Inject
    public FilmDetailActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_film_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showMissingFilm() {

    }

    @Override
    public void showTitle(String title) {
        titleTextView.setText(title);
    }

    @Override
    public void showDescription(String description) {
        descriptionTextView.setText(description);
    }

    @Override
    public void showDirector(String director) {
        directorTextView.setText(getString(R.string.director, director));
    }

    @Override
    public void showProducer(String producer) {
        producerTextView.setText(getString(R.string.producer, producer));
    }

    @Override
    public void showPeople() {

    }
}
