package com.carlos.popularmovies.themoviedb.view;

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

    void showServerError();

    void renderMovies(List<Response.Movie> list);
    void launchMovieDetail(MovieDetail movie);
}
