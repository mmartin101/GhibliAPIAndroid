package com.mmartin.ghibliapi.person

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.AttributeSet
import android.widget.TextView

/**
 * Text view that displays a person's name, but has the added functionality of
 * when clicked it displays the detailed view of that person
 *
 * Created by mmartin on 2/3/18.
 */
class PersonTextView : TextView {
    constructor(context: Context?) : super(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs, 0)
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr, 0)

    var personId: String = ""
        set(id) {
            field = id
            setOnClickListener { _ ->
                val intent = Intent(context, PersonDetailActivity::class.java)
                intent.putExtra("person_id", field)
                context.startActivity(intent)
            }
        }
}