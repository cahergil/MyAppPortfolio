package com.carlos.popularmovies.themoviedb.presenter;

import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

import com.carlos.popularmovies.themoviedb.api.client.Constants;
import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;
import com.carlos.popularmovies.themoviedb.api.model.Response;
import com.carlos.popularmovies.themoviedb.broadcastreceiver.FavoriteBroadcastReceiver;
import com.carlos.popularmovies.themoviedb.model.MoviesCallback;
import com.carlos.popularmovies.themoviedb.model.MoviesInteractor;
import com.carlos.popularmovies.themoviedb.observable.ObservableFavorites;
import com.carlos.popularmovies.themoviedb.view.MoviesMvpView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Carlos on 22/07/2016.
 */
public class MoviesPresenter implements Presenter<MoviesMvpView>,MoviesCallback,Observer{

    private MoviesMvpView moviesMvpView;
    private MoviesInteractor mMoviesInteractor;
    private FavoriteBroadcastReceiver broadcastReceiver=new FavoriteBroadcastReceiver();
    private ObservableFavorites observable=ObservableFavorites.getInstance();

    public MoviesPresenter() {

    }

    public void registerReceiver(){
        observable.addObserver(this);
        IntentFilter intentFilter=new IntentFilter("favorites");
        LocalBroadcastManager.getInstance(moviesMvpView.getContext()).registerReceiver(broadcastReceiver,intentFilter);
    //    moviesMvpView.getContext().registerReceiver(broadcastReceiver,intentFilter);
    }
    public void unregisterReceiver() {
        observable.deleteObserver(this);
        LocalBroadcastManager.getInstance(moviesMvpView.getContext()).unregisterReceiver(broadcastReceiver);
        //moviesMvpView.getContext().unregisterReceiver(broadcastReceiver);
    }
    @Override
    public void setView(MoviesMvpView view) {
        if (view == null) throw new IllegalArgumentException("You can't set a null view");
        moviesMvpView = view;
        mMoviesInteractor = new MoviesInteractor(moviesMvpView.getContext());
        registerReceiver();

    }

    @Override
    public void detachView() {
        unregisterReceiver();
        moviesMvpView = null;
    }

//    public void onLaunchMovieDetails(String movieId,View view) {
//        moviesMvpView.navigateToMovieDetails(movieId,view);
//    }

    public void loadMoviesFromApi(@Constants.MovieType int movieType) {
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


    @Override
    public void update(Observable observable, Object data) {
        List<MovieDetail> tempList=(List<MovieDetail>)data;
        List<Response.Movie> tempList2=new ArrayList<Response.Movie>();
        Response.Movie tempMovie;
        if (tempList!=null) {
            for (MovieDetail movieDetail : tempList) {
                tempMovie = new Response.Movie();
                tempMovie.setId(movieDetail.getId());
                tempMovie.setPoster_path(movieDetail.getPoster_path());
                tempMovie.setTitle(movieDetail.getTitle());
                tempList2.add(tempMovie);
            }
            moviesMvpView.renderMovies(tempList2);

        }
        moviesMvpView.removeDetailFragment();


    }
}