package com.carlos.myappportfolio.themoviedb.provider.review;

import com.carlos.myappportfolio.themoviedb.provider.base.BaseModel;

import java.util.Date;

/**
 * the reviews of the movie
 */
public interface ReviewModel extends BaseModel {

    /**
     * the movie id
     */
    int getMovieId();

    /**
     * page of the review
     * Cannot be {@code null}.
     */
    String getPage();

    /**
     * author of the review
     * Cannot be {@code null}.
     */
    String getAuthor();

    /**
     * content of the review
     * Cannot be {@code null}.
     */
    String getContent();
}
