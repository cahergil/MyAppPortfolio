package com.carlos.popularmovies.themoviedb.api.client;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Carlos on 22/07/2016.
 */
public class Constants {
    public static final String API_KEY="fd743d7e561dafce3e95178a536b5450";
    public static final String POSTER_BASE_URL="http://image.tmdb.org/t/p/w185/";
    public static final String POSTER_HQ_BASE_URL="http://image.tmdb.org/t/p/w342/";
    public static final String YOURTUBE_BASE_URL="http://www.youtube.com/watch?v=";
    public static final String YOUTUBE_IMAGE_BASE_URL="http://img.youtube.com/vi/%1$s/mqdefault.jpg";

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({MOVIES_BY_POPULARITY, MOVIES_BY_RATE})
    public @interface MovieType {
    }

    public static final int MOVIES_BY_POPULARITY = 0;
    public static final int MOVIES_BY_RATE = 1;

}
