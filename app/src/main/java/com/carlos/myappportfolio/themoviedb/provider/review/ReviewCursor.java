package com.carlos.myappportfolio.themoviedb.provider.review;

import java.util.Date;

import android.database.Cursor;

import com.carlos.myappportfolio.themoviedb.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code review} table.
 */
public class ReviewCursor extends AbstractCursor implements ReviewModel {
    public ReviewCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(ReviewColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * the movie id
     */
    public int getMovieId() {
        Integer res = getIntegerOrNull(ReviewColumns.MOVIE_ID);
        if (res == null)
            throw new NullPointerException("The value of 'movie_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * page of the review
     * Cannot be {@code null}.
     */
    public String getPage() {
        String res = getStringOrNull(ReviewColumns.PAGE);
        if (res == null)
            throw new NullPointerException("The value of 'page' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * author of the review
     * Cannot be {@code null}.
     */
    public String getAuthor() {
        String res = getStringOrNull(ReviewColumns.AUTHOR);
        if (res == null)
            throw new NullPointerException("The value of 'author' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * content of the review
     * Cannot be {@code null}.
     */
    public String getContent() {
        String res = getStringOrNull(ReviewColumns.CONTENT);
        if (res == null)
            throw new NullPointerException("The value of 'content' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
