package com.carlos.popularmovies.themoviedb;

import android.content.Context;
import android.content.SharedPreferences;

import com.carlos.popularmovies.themoviedb.models.MovieDetail;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Carlos on 01/09/2015.
 */
public class SharedPreferenceManager {
    private Context mContext;
    private SharedPreferences mSharedPreferences;
    private static final String PREF_FILE_NAME="sp_file";
    private static final String FAVORITES_KEY="favorites";
    private static final String FROM_REVIEW_DETAILS="fromReviewDetails";

    public SharedPreferenceManager(Context context){
        this.mContext=context;
        mSharedPreferences=context.getSharedPreferences(PREF_FILE_NAME,Context.MODE_PRIVATE);
    }
    public void setFromDetailsScreen(boolean value){
        SharedPreferences.Editor editor;
        editor=mSharedPreferences.edit();
        editor.putBoolean(FROM_REVIEW_DETAILS,value);
        editor.commit();

    }

    public boolean getSharedVariable(){
        boolean temp=false;
        if(mSharedPreferences.contains(FROM_REVIEW_DETAILS)){
            temp=mSharedPreferences.getBoolean(FROM_REVIEW_DETAILS,false);
        }
        return temp;
    }
    public void saveFavoritesList(List<MovieDetail> list){
        SharedPreferences.Editor editor;
        editor=mSharedPreferences.edit();
        Gson gsonObject=new Gson();
        String jsonString=gsonObject.toJson(list);
        editor.putString(FAVORITES_KEY,jsonString);
        editor.commit();

    }
    public List<MovieDetail> getFavoritesList(){
        List<MovieDetail> tempList=null;

        if(mSharedPreferences.contains(FAVORITES_KEY)){
            String jsonString=mSharedPreferences.getString(FAVORITES_KEY,null);
            Gson gsonObject=new Gson();
            if(!jsonString.equals("null")){

                    MovieDetail[] movieDetails = gsonObject.fromJson(jsonString, MovieDetail[].class);
                    tempList = Arrays.asList(movieDetails);
                    tempList = new ArrayList<MovieDetail>(tempList);
                    return tempList;
            } else {
                return null;
            }

        } else {
            return null;
        }
    }
    public MovieDetail getMovieFromFavoritesList(int id) {
        MovieDetail movie=new MovieDetail();
        List<MovieDetail> tempList=getFavoritesList();
        for(MovieDetail movieDetail: tempList) {

            if(movieDetail.getId()==id) {
                movie = movieDetail;
                return movie;
            }
        }


        return null;
    }
    public boolean isMovieInFavorites(MovieDetail movieDetail){
        boolean found=false;
        List<MovieDetail> tempList=getFavoritesList();
        if (tempList!=null) {
            if (tempList.contains(movieDetail)) {
                found=true;
            }
        } else {
            found=false;
        }
            return found;
    }


}
