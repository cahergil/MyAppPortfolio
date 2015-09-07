package com.carlos.myappportfolio.themoviedb.provider.trailer;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;

import com.carlos.myappportfolio.themoviedb.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code trailer} table.
 */
public class TrailerContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return TrailerColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver,  TrailerSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context,  TrailerSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * the movie id
     */
    public TrailerContentValues putMovieId(int value) {
        mContentValues.put(TrailerColumns.MOVIE_ID, value);
        return this;
    }


    /**
     * name of the trailer
     */
    public TrailerContentValues putTrailerName(String value) {
        if (value == null) throw new IllegalArgumentException("trailerName must not be null");
        mContentValues.put(TrailerColumns.TRAILER_NAME, value);
        return this;
    }


    /**
     * size of the trailer
     */
    public TrailerContentValues putSize(String value) {
        if (value == null) throw new IllegalArgumentException("size must not be null");
        mContentValues.put(TrailerColumns.SIZE, value);
        return this;
    }


    /**
     * youtube page of the trailer
     */
    public TrailerContentValues putSource(String value) {
        if (value == null) throw new IllegalArgumentException("source must not be null");
        mContentValues.put(TrailerColumns.SOURCE, value);
        return this;
    }


    /**
     * type of the trailer
     */
    public TrailerContentValues putType(String value) {
        if (value == null) throw new IllegalArgumentException("type must not be null");
        mContentValues.put(TrailerColumns.TYPE, value);
        return this;
    }

}
