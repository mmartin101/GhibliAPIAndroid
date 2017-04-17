package com.mmartin.ghibliapi.film;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.mmartin.ghibliapi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmDetailActivity extends AppCompatActivity {
    @BindView(R.id.film_title_text_view)
    TextView titleTextView;
    @BindView(R.id.film_description_text_view)
    TextView descriptionTextView;

    private Film film;

    public static Intent newIntent(Context c, Film film) {
        Intent intent = new Intent(c, FilmDetailActivity.class);
        intent.putExtra("film", film);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);
        ButterKnife.bind(this);
        if (getIntent() != null && getIntent().hasExtra("film")) {
            film = getIntent().getParcelableExtra("film");
            titleTextView.setText(film.getTitle());
            descriptionTextView.setText(film.getDescription());
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
