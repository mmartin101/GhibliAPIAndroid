package com.mmartin.ghibliapi.person

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mmartin.ghibliapi.R

/**
 * Created by mmartin on 2/4/18.
 */
class PersonAdapter : RecyclerView.Adapter<PersonViewHolder>() {
    private val list = mutableListOf<Pair<String, String>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_person, null)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun addAll(peopleList: List<Pair<String, String>>) {
        list.clear()
        list.addAll(peopleList)
        notifyDataSetChanged()
    }
}