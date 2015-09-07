package com.carlos.myappportfolio.themoviedb.provider.detail;

import com.carlos.myappportfolio.themoviedb.provider.base.BaseModel;

import java.util.Date;

/**
 * the details of the movie
 */
public interface DetailModel extends BaseModel {

    /**
     * the id movie
     */
    int getMovieId();

    /**
     * the title of the movie
     * Cannot be {@code null}.
     */
    String getTitle();

    /**
     * runtime of the movie
     */
    int getRuntime();

    /**
     * release date of the movie
     * Cannot be {@code null}.
     */
    String getReleasedate();

    /**
     * poster path of the movie
     * Cannot be {@code null}.
     */
    String getPosterPath();

    /**
     * backdrop path of the movie
     * Cannot be {@code null}.
     */
    String getBackdropPath();

    /**
     * vote average of the movie
     */
    float getVoteAverage();

    /**
     * vote count of the movie
     */
    int getVoteCount();

    /**
     * synopsis of the movie
     * Cannot be {@code null}.
     */
    String getOverview();
}
