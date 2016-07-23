package com.carlos.popularmovies.themoviedb.api.client;

import android.app.Application;
import android.content.Context;

/**
 * Created by Carlos on 22/07/2016.
 */
public class MyApplication extends Application {

    TheMovieDbService mTheMovieDbService;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    public TheMovieDbService getmTheMovieDbService() {
        if(mTheMovieDbService==null) {
            mTheMovieDbService=FactoryTheMovieDb.create();
        }
        return mTheMovieDbService;
    }
}
