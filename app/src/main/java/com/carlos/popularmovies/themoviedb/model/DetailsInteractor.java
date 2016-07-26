package com.carlos.popularmovies.themoviedb.model;

import android.content.Context;
import android.util.Log;

import com.carlos.popularmovies.themoviedb.api.client.Constants;
import com.carlos.popularmovies.themoviedb.api.client.MyApplication;
import com.carlos.popularmovies.themoviedb.api.client.TheMovieDbService;
import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;
import com.carlos.popularmovies.themoviedb.api.model.Response;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Carlos on 23/07/2016.
 */
public class DetailsInteractor {

    private static final String LOG_TAG=DetailsInteractor.class.getSimpleName();

    TheMovieDbService mTheMovieDbService;
    MyApplication myApplication;

    public DetailsInteractor(Context context){
        this.myApplication = MyApplication.get(context);
        mTheMovieDbService = myApplication.getmTheMovieDbService();
    }

    public void getMovieDetails(String movieId,DetailsCallback callback){
        Call call=mTheMovieDbService.getMovieDetails(movieId, Constants.API_KEY);
        call.enqueue(retrofitCallback(callback));
    }

    public Callback retrofitCallback(final DetailsCallback callback) {
        return new Callback() {
            @Override
            public void onResponse(Call call, retrofit2.Response response) {
                if(response.isSuccessful()) {
                    Object o = response.body();
                    if (o instanceof MovieDetail) {
                        MovieDetail movieDetail = (MovieDetail) o;
                        callback.onResponse(movieDetail);
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
