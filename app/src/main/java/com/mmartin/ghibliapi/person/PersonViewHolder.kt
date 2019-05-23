package com.mmartin.ghibliapi.person

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_person.view.*

/**
 * Created by mmartin on 2/4/18.
 */
class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    /**
     * Sets the model for the view holder
     *
     * @param model is a pair of strings, person id and persons name
     */
    fun bind(model: Pair<String, String>) {
        itemView.person_text_view.personId = model.first
        itemView.person_text_view.text = model.second
    }
}