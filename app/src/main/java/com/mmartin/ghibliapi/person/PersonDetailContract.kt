package com.mmartin.ghibliapi.person

import com.mmartin.ghibliapi.BasePresenter
import com.mmartin.ghibliapi.BaseView
import com.mmartin.ghibliapi.data.model.Person

/**
 * Created by mmartin on 2/3/18.
 */
interface PersonDetailContract {
    interface View : BaseView {
        fun showEmpty()
        fun showPerson(person: Person)
    }

    interface Presenter : BasePresenter<View> {

    }
}