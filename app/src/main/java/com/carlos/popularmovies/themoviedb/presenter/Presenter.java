package com.carlos.popularmovies.themoviedb.presenter;

/**
 * Created by Carlos on 22/07/2016.
 */
public interface Presenter<V> {


        void setView(V view);

        void detachView();


}
