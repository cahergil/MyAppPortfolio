package com.carlos.popularmovies.themoviedb.presenter;

import com.carlos.popularmovies.themoviedb.api.client.Constants;
import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;
import com.carlos.popularmovies.themoviedb.api.model.Response;
import com.carlos.popularmovies.themoviedb.model.InteractorCallback;
import com.carlos.popularmovies.themoviedb.model.MoviesInteractor;
import com.carlos.popularmovies.themoviedb.view.MoviesMvpView;

import java.util.List;

/**
 * Created by Carlos on 22/07/2016.
 */
public class MoviesPresenter implements Presenter<MoviesMvpView>,InteractorCallback {

    private MoviesMvpView moviesMvpView;
    private MoviesInteractor mMoviesInteractor;
    public MoviesPresenter() {

    }

    @Override
    public void setView(MoviesMvpView view) {
        if (view == null) throw new IllegalArgumentException("You can't set a null view");
        moviesMvpView=view;
        mMoviesInteractor=new MoviesInteractor(moviesMvpView.getContext());

    }

    @Override
    public void detachView() {
        moviesMvpView=null;
    }

    public void launchMovieDetails(MovieDetail movieDetail) {
        moviesMvpView.launchMovieDetail(movieDetail);
    }

    public void loadMovies(@Constants.MovieType int movieType){
        moviesMvpView.showLoading();
        if(movieType==Constants.MOVIES_BY_POPULARITY) {
            mMoviesInteractor.getMoviesByPopularity(this);
        } else {
            mMoviesInteractor.getMoviesByRate(this);
        }


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
    public void onServerError() {

    }
}
