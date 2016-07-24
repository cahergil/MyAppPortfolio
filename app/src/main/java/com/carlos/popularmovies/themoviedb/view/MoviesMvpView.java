package com.carlos.popularmovies.themoviedb.view;

import android.view.View;

import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;
import com.carlos.popularmovies.themoviedb.api.model.Response;

import java.util.List;

/**
 * Created by Carlos on 22/07/2016.
 */
public interface MoviesMvpView extends MvpView{

    void showLoading();

    void hideLoading();

    void showConnectionErrorMessage();

    void showServerError(String error);

    void renderMovies(List<Response.Movie> list);


}
