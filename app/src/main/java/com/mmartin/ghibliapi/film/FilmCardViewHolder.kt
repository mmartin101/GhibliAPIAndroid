package com.mmartin.ghibliapi.film

import android.support.v7.widget.RecyclerView
import android.view.View
import com.mmartin.ghibliapi.data.model.Film
import kotlinx.android.synthetic.main.view_film_list_item.view.*

/**
 * View holder for Film models
 *
 *
 * Created by mmartin on 4/10/17.
 */

class FilmCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindData(film: Film) {
        itemView.film_title_text_view.text = film.title
        itemView.film_description_text_view.text = film.description
        itemView.film_release_date_text_view.text = film.releaseDate
    }
}
