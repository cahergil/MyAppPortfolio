package com.carlos.popularmovies.themoviedb.model;

import com.carlos.popularmovies.themoviedb.api.model.Response;

import java.util.List;

/**
 * Created by Carlos on 22/07/2016.
 */
public interface InteractorCallback {
    void onResponse(List<Response.Movie> artists);

    void onArtistNotFound();

    void onNetworkConnectionError();

    void onServerError();
}




