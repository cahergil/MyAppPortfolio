package com.carlos.popularmovies.themoviedb.api.client;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Carlos on 22/07/2016.
 */
public class FactoryTheMovieDb {
    public FactoryTheMovieDb(){

    }
    public static TheMovieDbService create() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(TheMovieDbService.class);
    }

}
