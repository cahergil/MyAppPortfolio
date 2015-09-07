package com.carlos.myappportfolio.themoviedb.provider.trailer;

import com.carlos.myappportfolio.themoviedb.provider.base.BaseModel;

import java.util.Date;

/**
 * the trailers of the movie
 */
public interface TrailerModel extends BaseModel {

    /**
     * the movie id
     */
    int getMovieId();

    /**
     * name of the trailer
     * Cannot be {@code null}.
     */
    String getTrailerName();

    /**
     * size of the trailer
     * Cannot be {@code null}.
     */
    String getSize();

    /**
     * youtube page of the trailer
     * Cannot be {@code null}.
     */
    String getSource();

    /**
     * type of the trailer
     * Cannot be {@code null}.
     */
    String getType();
}
