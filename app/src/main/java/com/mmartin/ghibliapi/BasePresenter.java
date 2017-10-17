package com.mmartin.ghibliapi;

/**
 * Created by mmartin on 8/12/17.
 */

public interface BasePresenter<T> {
    void start();
    void setView(T view);
}
