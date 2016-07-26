package com.carlos.popularmovies.themoviedb.api.client;

import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;
import com.carlos.popularmovies.themoviedb.api.model.MovieImages;
import com.carlos.popularmovies.themoviedb.api.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by Carlos on 22/07/2016.
 */
public interface TheMovieDbService {
    @GET("/3/discover/movie?sort_by=popularity.desc")
    Call<Response> getMoviesByPopularityDesc(@Query("api_key") String apikey);
    @GET("/3/discover/movie?certification_country=US&certification=R&sort_by=vote_average.desc")
    Call<Response> getMoviesByAverageRate(@Query("api_key") String apikey);

    @GET("/3/movie/{id}?append_to_response=trailers,reviews,images")
    Call<MovieDetail> getMovieDetails(@Path("id")String id, @Query("api_key") String apikey);

    @GET("/3/movie{movie_id}/images")
    Call<MovieImages> getImages(@Path("movie_id") String movie_id, @Query("api_key") String apikey);

}
