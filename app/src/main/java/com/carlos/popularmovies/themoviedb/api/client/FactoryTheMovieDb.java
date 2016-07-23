package com.carlos.popularmovies.themoviedb.api.client;

import retrofit.RestAdapter;

/**
 * Created by Carlos on 22/07/2016.
 */
public class FactoryTheMovieDb {
    public FactoryTheMovieDb(){

    }
    public static TheMovieDbService create() {
        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("http://api.themoviedb.org/")
                .build();
        return restAdapter.create(TheMovieDbService.class);
    }

}
