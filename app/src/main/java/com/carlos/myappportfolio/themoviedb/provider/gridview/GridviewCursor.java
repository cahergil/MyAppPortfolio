package com.carlos.myappportfolio.themoviedb.provider.gridview;

import java.util.Date;

import android.database.Cursor;

import com.carlos.myappportfolio.themoviedb.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code gridview} table.
 */
public class GridviewCursor extends AbstractCursor implements GridviewModel {
    public GridviewCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(GridviewColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * id de la pelicula
     */
    public int getMovieId() {
        Integer res = getIntegerOrNull(GridviewColumns.MOVIE_ID);
        if (res == null)
            throw new NullPointerException("The value of 'movie_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * titulo de la pelicula
     * Cannot be {@code null}.
     */
    public String getTitle() {
        String res = getStringOrNull(GridviewColumns.TITLE);
        if (res == null)
            throw new NullPointerException("The value of 'title' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * poster de la pelicula
     * Cannot be {@code null}.
     */
    public String getPosterPath() {
        String res = getStringOrNull(GridviewColumns.POSTER_PATH);
        if (res == null)
            throw new NullPointerException("The value of 'poster_path' in the database was null, which is not allowed according to the model definition");
        return res;
    }
}
