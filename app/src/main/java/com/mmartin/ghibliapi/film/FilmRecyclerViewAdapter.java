package com.mmartin.ghibliapi.film;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mmartin.ghibliapi.R;
import com.mmartin.ghibliapi.data.model.Film;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView Adapter for Film objects
 * <p>
 * Created by mmartin on 4/10/17.
 */

public class FilmRecyclerViewAdapter extends RecyclerView.Adapter<FilmCardViewHolder> {
    private List<Film> data;

    @Override
    public FilmCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_film_list_item, parent, false);
        FilmCardViewHolder viewHolder = new FilmCardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FilmCardViewHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void addAll(List<Film> list) {
        data = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    public Film getItemAt(int position) {
        if (data != null && position < data.size()) {
            return data.get(position);
        }

        return null;
    }
}
