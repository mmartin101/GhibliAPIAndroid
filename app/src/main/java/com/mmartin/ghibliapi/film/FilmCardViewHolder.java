package com.mmartin.ghibliapi.film;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mmartin.ghibliapi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * View holder for Film models
 * <p>
 * Created by mmartin on 4/10/17.
 */

public class FilmCardViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.film_title_text_view)
    TextView titleTextView;
    @BindView(R.id.film_description_text_view)
    TextView descriptionTextView;
    @BindView(R.id.film_release_date_text_view)
    TextView releaseDateTextView;

    public FilmCardViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindData(Film film) {
        titleTextView.setText(film.getTitle());
        descriptionTextView.setText(film.getDescription());
        releaseDateTextView.setText(film.getReleaseDate());
    }
}
