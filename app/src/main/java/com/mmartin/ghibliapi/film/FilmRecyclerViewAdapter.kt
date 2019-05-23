package com.mmartin.ghibliapi.film

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mmartin.ghibliapi.R
import com.mmartin.ghibliapi.data.model.Film
import java.util.*

/**
 * RecyclerView Adapter for Film objects
 *
 *
 * Created by mmartin on 4/10/17.
 */

class FilmRecyclerViewAdapter : RecyclerView.Adapter<FilmCardViewHolder>() {
    private var data: List<Film>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_film_list_item, parent, false)
        return FilmCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmCardViewHolder, position: Int) {
        holder.bindData(data!![position])
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data!!.size
    }

    fun addAll(list: List<Film>) {
        data = ArrayList(list)
        notifyDataSetChanged()
    }

    fun getItemAt(position: Int): Film? {
        return if (data != null && position < data!!.size) {
            data!![position]
        } else null

    }
}
