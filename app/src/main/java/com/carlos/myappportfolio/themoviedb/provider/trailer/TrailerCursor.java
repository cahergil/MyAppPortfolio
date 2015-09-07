package com.carlos.myappportfolio.themoviedb.provider.trailer;

import java.util.Date;

import android.database.Cursor;

import com.carlos.myappportfolio.themoviedb.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code trailer} table.
 */
public class TrailerCursor extends AbstractCursor implements TrailerModel {
    public TrailerCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(TrailerColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * the movie id
     */
    public int getMovieId() {
        Integer res = getIntegerOrNull(TrailerColumns.MOVIE_ID);
        if (res == null)
            throw new NullPointerException("The value of 'movie_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * name of the trailer
     * Cannot be {@code null}.
     */
    public String getTrailerName() {
        String res = getStringOrNull(TrailerColumns.TRAILER_NAME);
        if (res == null)
            throw new NullPointerException("The value of 'trailer_name' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * size of the trailer
     * Cannot be {@code null}.
     */
    public String getSize() {
        String res = getStringOrNull(TrailerColumns.SIZE);
        if (res == null)
            throw new NullPointerException("The value of 'size' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * youtube page of the trailer
     * Cannot be {@code null}.
     */
    public String getSource() {
        String res = getStringOrNull(TrailerColumns.SOURCE);
        if (res == null)
            throw new NullPointerException("The value of 'source' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * type of the trailer
     * Cannot be {@code null}.
     */
    public String getType() {
        String res = getStringOrNull(TrailerColumns.TYPE);
        if (res == null)
            throw new NullPointerException("The value of 'type' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
