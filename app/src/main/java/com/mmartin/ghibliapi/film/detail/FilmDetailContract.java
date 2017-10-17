package com.mmartin.ghibliapi.film.detail;

import com.mmartin.ghibliapi.BasePresenter;
import com.mmartin.ghibliapi.BaseView;

/**
 * Created by mmartin on 8/12/17.
 */

public interface FilmDetailContract {
    interface View extends BaseView {
        void showMissingFilm();
        void showTitle(String title);
        void showDescription(String description);
        void showDirector(String director);
        void showProducer(String producer);
        void showPeople(); //List of string/People??
    }

    interface Presenter extends BasePresenter<View> {
        void setFilmId(String filmId);
    }
}
