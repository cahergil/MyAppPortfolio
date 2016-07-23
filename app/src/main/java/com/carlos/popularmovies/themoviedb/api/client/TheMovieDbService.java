package com.carlos.popularmovies.themoviedb.api.client;

import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;
import com.carlos.popularmovies.themoviedb.api.model.MovieImages;
import com.carlos.popularmovies.themoviedb.api.model.Response;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Carlos on 22/07/2016.
 */
public interface TheMovieDbService {
    @GET("/3/discover/movie?sort_by=popularity.desc")
    void getMoviesByPopularityDesc(@Query("api_key") String apikey, retrofit.Callback<Response> cb );
    @GET("/3/discover/movie?certification_country=US&certification=R&sort_by=vote_average.desc")
    void getMoviesByAverageRate(@Query("api_key") String apikey, retrofit.Callback<Response> cb);

    @GET("/3/movie/{id}?append_to_response=trailers,reviews,images")
    void getMovieDetails(@Path("id")String id, @Query("api_key") String apikey, retrofit.Callback<MovieDetail> cb);

    @GET("/3/movie{movie_id}/images")
    void getImages(@Path("movie_id") String movie_id, @Query("api_key") String apikey, retrofit.Callback<MovieImages> cb);

}
