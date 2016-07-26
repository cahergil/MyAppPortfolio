package com.carlos.popularmovies.themoviedb.model;

import android.content.Context;
import android.util.Log;

import com.carlos.popularmovies.themoviedb.SharedPreferenceManager;
import com.carlos.popularmovies.themoviedb.api.client.Constants;
import com.carlos.popularmovies.themoviedb.api.client.MyApplication;
import com.carlos.popularmovies.themoviedb.api.client.TheMovieDbService;
import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;
import com.carlos.popularmovies.themoviedb.api.model.Response;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


/**
 * Created by Carlos on 22/07/2016.
 */
public class MoviesInteractor {

    private static final String LOG_TAG = MoviesInteractor.class.getSimpleName();
    private TheMovieDbService mTheMovieDbService;
    private MyApplication myApplication;
    private Context context;

    public MoviesInteractor(Context context) {
        this.myApplication = MyApplication.get(context);
        mTheMovieDbService = myApplication.getmTheMovieDbService();
        this.context = context;
    }

    public void getMoviesByPopularity(MoviesCallback callback) {
        Call call= mTheMovieDbService.getMoviesByPopularityDesc(Constants.API_KEY);
        call.enqueue(retrofitCallback(callback));
    }

    public void getMoviesByRate(MoviesCallback callback) {
        Call call=mTheMovieDbService.getMoviesByAverageRate(Constants.API_KEY);
        call.enqueue(retrofitCallback(callback));
    }

    public void getFavoriteMovies(MoviesCallback callback) {
        List<MovieDetail> tempListDetail;
        ArrayList<Response.Movie> tempList = new ArrayList<Response.Movie>();
        SharedPreferenceManager sharedPreferenceManager = new SharedPreferenceManager(context);
        tempListDetail = sharedPreferenceManager.getFavoritesList();
        Response.Movie tempMovie;
        if (tempListDetail != null) {
            for (MovieDetail movieDetail : tempListDetail) {
                tempMovie = new Response.Movie();
                tempMovie.setId(movieDetail.getId());
                tempMovie.setPoster_path(movieDetail.getPoster_path());
                tempMovie.setTitle(movieDetail.getTitle());
                tempList.add(tempMovie);
            }
            callback.onResponse(tempList);
            return;
        }
        callback.onResponse(new ArrayList<Response.Movie>());

    }

    public Callback retrofitCallback(final MoviesCallback callback) {
        return new Callback() {
            @Override
            public void onResponse(Call call, retrofit2.Response response) {
                if (response.isSuccessful()) {
                    Object o = response.body();
                    if (o instanceof Response) {
                        Response resp = (Response) o;
                        List<Response.Movie> moviesList = resp.getResults();
                        callback.onResponse(moviesList);
                    }
                } else {
                    String err =""+ response.code();
                    Log.d(LOG_TAG, "error:" + err);
                    callback.onServerError(err);
                }
            }


            @Override
            public void onFailure(Call call, Throwable t) {
                String err = t.getMessage();
                Log.d(LOG_TAG, "error:" + err);
                callback.onServerError(err);
            }
        };
    }


}