package com.carlos.popularmovies.themoviedb.presenter;

import android.view.View;

import com.carlos.popularmovies.themoviedb.api.client.Constants;
import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;
import com.carlos.popularmovies.themoviedb.api.model.Response;
import com.carlos.popularmovies.themoviedb.model.MoviesCallback;
import com.carlos.popularmovies.themoviedb.model.MoviesInteractor;
import com.carlos.popularmovies.themoviedb.view.MoviesMvpView;

import java.util.List;

/**
 * Created by Carlos on 22/07/2016.
 */
public class MoviesPresenter implements Presenter<MoviesMvpView>,MoviesCallback {

    private MoviesMvpView moviesMvpView;
    private MoviesInteractor mMoviesInteractor;

    public MoviesPresenter() {

    }

    @Override
    public void setView(MoviesMvpView view) {
        if (view == null) throw new IllegalArgumentException("You can't set a null view");
        moviesMvpView = view;
        mMoviesInteractor = new MoviesInteractor(moviesMvpView.getContext());

    }

    @Override
    public void detachView() {
        moviesMvpView = null;
    }

//    public void onLaunchMovieDetails(String movieId,View view) {
//        moviesMvpView.navigateToMovieDetails(movieId,view);
//    }

    public void loadMovies(@Constants.MovieType int movieType) {
        moviesMvpView.showLoading();
        if (movieType == Constants.MOVIES_BY_POPULARITY) {
            mMoviesInteractor.getMoviesByPopularity(this);
        } else {
            mMoviesInteractor.getMoviesByRate(this);
        }


    }

    public void onLoadFavorites() {
        moviesMvpView.showLoading();
        mMoviesInteractor.getFavoriteMovies(this);
    }

    @Override

    public void onResponse(List<Response.Movie> movies) {
        moviesMvpView.hideLoading();
        moviesMvpView.renderMovies(movies);
    }


    @Override
    public void onArtistNotFound() {

    }

    @Override
    public void onNetworkConnectionError() {

    }

    @Override
    public void onServerError(String error) {
        moviesMvpView.showServerError(error);
    }


}