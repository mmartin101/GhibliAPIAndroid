package com.mmartin.ghibliapi.film;

import com.mmartin.ghibliapi.BasePresenter;
import com.mmartin.ghibliapi.BaseView;

/**
 * Created by mmartin on 8/12/17.
 */

public class FilmDetailContract {
    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);
        void showMissingFilm();
        void showTitle();
        void showDescription();
        void showDirector();
        void showPeople();
    }

    interface Presenter extends BasePresenter {

    }
}
