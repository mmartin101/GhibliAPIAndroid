package com.mmartin.ghibliapi.film;

import com.mmartin.ghibliapi.BasePresenter;
import com.mmartin.ghibliapi.BaseView;

/**
 * Created by mmartin on 9/12/17.
 */

public interface FilmsContract {
    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {
    }
}
