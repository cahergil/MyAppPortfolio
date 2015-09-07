package com.carlos.myappportfolio.themoviedb.provider.gridview;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;

import com.carlos.myappportfolio.themoviedb.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code gridview} table.
 */
public class GridviewContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return GridviewColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver,  GridviewSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context,  GridviewSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * id de la pelicula
     */
    public GridviewContentValues putMovieId(int value) {
        mContentValues.put(GridviewColumns.MOVIE_ID, value);
        return this;
    }


    /**
     * titulo de la pelicula
     */
    public GridviewContentValues putTitle(String value) {
        if (value == null) throw new IllegalArgumentException("title must not be null");
        mContentValues.put(GridviewColumns.TITLE, value);
        return this;
    }


    /**
     * poster de la pelicula
     */
    public GridviewContentValues putPosterPath(String value) {
        if (value == null) throw new IllegalArgumentException("posterPath must not be null");
        mContentValues.put(GridviewColumns.POSTER_PATH, value);
        return this;
    }

}
