package com.carlos.popularmovies.themoviedb.model;

import android.content.Context;

import com.carlos.popularmovies.themoviedb.api.client.Constants;
import com.carlos.popularmovies.themoviedb.api.client.MyApplication;
import com.carlos.popularmovies.themoviedb.api.client.TheMovieDbService;
import com.carlos.popularmovies.themoviedb.api.model.Response;
import com.carlos.popularmovies.themoviedb.presenter.MoviesPresenter;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by Carlos on 22/07/2016.
 */
public class MoviesInteractor {

    TheMovieDbService mTheMovieDbService;
    MyApplication myApplication;

    public MoviesInteractor(Context context) {
        this.myApplication=MyApplication.get(context);
        mTheMovieDbService=myApplication.getmTheMovieDbService();

    }

    public void getMoviesByPopularity(InteractorCallback callback) {
        mTheMovieDbService.getMoviesByPopularityDesc(Constants.API_KEY,retrofitCallback(callback));
    }
    public void getMoviesByRate(InteractorCallback callback){
        mTheMovieDbService.getMoviesByAverageRate(Constants.API_KEY,retrofitCallback(callback));
    }

    public Callback retrofitCallback(final InteractorCallback callback){
        return new Callback() {
            @Override
            public void success(Object o, retrofit.client.Response response) {
                if(o instanceof Response) {
                    Response resp=(Response)o;
                    List<Response.Movie> moviesList=resp.getResults();
                    callback.onResponse(moviesList);
                }

            }

            @Override
            public void failure(RetrofitError error) {

            }
        };
    }


}
