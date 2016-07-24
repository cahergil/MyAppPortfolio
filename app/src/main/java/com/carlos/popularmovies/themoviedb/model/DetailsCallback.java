package com.carlos.popularmovies.themoviedb.model;

import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;
import com.carlos.popularmovies.themoviedb.api.model.Response;
import com.carlos.popularmovies.themoviedb.api.model.Reviews;
import com.carlos.popularmovies.themoviedb.api.model.Trailers;

import java.util.List;

/**
 * Created by Carlos on 23/07/2016.
 */
public interface DetailsCallback {
    void onResponse(MovieDetail movieList);

    void onServerError(String error);
}
