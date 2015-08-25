package com.carlos.myappportfolio.themoviedb;

import com.carlos.myappportfolio.themoviedb.model.MovieDetail;
import com.carlos.myappportfolio.themoviedb.model.Response;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Carlos on 19/08/2015.
 */
public class ApiClient {

    private static MyApi myApi;

    public interface MyApi {
        @GET("/3/discover/movie?sort_by=popularity.desc")
        void getMoviesByPopularityDesc(@Query("api_key") String apikey,retrofit.Callback<Response> cb );

        @GET("/3/discover/movie?certification_country=US&certification=R&sort_by=vote_average.desc")
        void getMoviesByAverageRate(@Query("api_key") String apikey, retrofit.Callback<Response> cb);

        @GET("/3/movie/{id}?append_to_response=credits,releases,images")
        void getMovieDetails(@Path("id")String id,@Query("api_key") String apikey,retrofit.Callback<MovieDetail> cb);
    }

    public static  MyApi getMyApiClient(){
        if(myApi==null){
            RestAdapter restAdapter=new RestAdapter.Builder()
                    .setEndpoint("http://api.themoviedb.org/")
                    .build();
            myApi=restAdapter.create(MyApi.class);
            return myApi;
        } else
            return myApi;

    }
}