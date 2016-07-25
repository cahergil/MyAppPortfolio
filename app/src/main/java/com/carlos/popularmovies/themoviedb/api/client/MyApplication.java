package com.carlos.popularmovies.themoviedb.api.client;

import android.app.Application;
import android.content.Context;

/**
 * Created by Carlos on 22/07/2016.
 */
public class MyApplication extends Application {

    TheMovieDbService mTheMovieDbService;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
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
