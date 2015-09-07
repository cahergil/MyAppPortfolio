package com.carlos.myappportfolio.themoviedb.provider.detail;

import java.util.Date;

import android.database.Cursor;

import com.carlos.myappportfolio.themoviedb.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code detail} table.
 */
public class DetailCursor extends AbstractCursor implements DetailModel {
    public DetailCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(DetailColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * the id movie
     */
    public int getMovieId() {
        Integer res = getIntegerOrNull(DetailColumns.MOVIE_ID);
        if (res == null)
            throw new NullPointerException("The value of 'movie_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * the title of the movie
     * Cannot be {@code null}.
     */
    public String getTitle() {
        String res = getStringOrNull(DetailColumns.TITLE);
        if (res == null)
            throw new NullPointerException("The value of 'title' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * runtime of the movie
     */
    public int getRuntime() {
        Integer res = getIntegerOrNull(DetailColumns.RUNTIME);
        if (res == null)
            throw new NullPointerException("The value of 'runtime' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * release date of the movie
     * Cannot be {@code null}.
     */
    public String getReleasedate() {
        String res = getStringOrNull(DetailColumns.RELEASEDATE);
        if (res == null)
            throw new NullPointerException("The value of 'releasedate' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * poster path of the movie
     * Cannot be {@code null}.
     */
    public String getPosterPath() {
        String res = getStringOrNull(DetailColumns.POSTER_PATH);
        if (res == null)
            throw new NullPointerException("The value of 'poster_path' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * backdrop path of the movie
     * Cannot be {@code null}.
     */
    public String getBackdropPath() {
        String res = getStringOrNull(DetailColumns.BACKDROP_PATH);
        if (res == null)
            throw new NullPointerException("The value of 'backdrop_path' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * vote average of the movie
     */
    public float getVoteAverage() {
        Float res = getFloatOrNull(DetailColumns.VOTE_AVERAGE);
        if (res == null)
            throw new NullPointerException("The value of 'vote_average' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * vote count of the movie
     */
    public int getVoteCount() {
        Integer res = getIntegerOrNull(DetailColumns.VOTE_COUNT);
        if (res == null)
            throw new NullPointerException("The value of 'vote_count' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * synopsis of the movie
     * Cannot be {@code null}.
     */
    public String getOverview() {
        String res = getStringOrNull(DetailColumns.OVERVIEW);
        if (res == null)
            throw new NullPointerException("The value of 'overview' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
