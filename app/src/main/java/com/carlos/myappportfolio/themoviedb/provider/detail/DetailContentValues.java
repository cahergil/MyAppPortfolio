package com.carlos.myappportfolio.themoviedb.provider.detail;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;

import com.carlos.myappportfolio.themoviedb.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code detail} table.
 */
public class DetailContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return DetailColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver,  DetailSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context,  DetailSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * the id movie
     */
    public DetailContentValues putMovieId(int value) {
        mContentValues.put(DetailColumns.MOVIE_ID, value);
        return this;
    }


    /**
     * the title of the movie
     */
    public DetailContentValues putTitle(String value) {
        if (value == null) throw new IllegalArgumentException("title must not be null");
        mContentValues.put(DetailColumns.TITLE, value);
        return this;
    }


    /**
     * runtime of the movie
     */
    public DetailContentValues putRuntime(int value) {
        mContentValues.put(DetailColumns.RUNTIME, value);
        return this;
    }


    /**
     * release date of the movie
     */
    public DetailContentValues putReleasedate(String value) {
        if (value == null) throw new IllegalArgumentException("releasedate must not be null");
        mContentValues.put(DetailColumns.RELEASEDATE, value);
        return this;
    }


    /**
     * poster path of the movie
     */
    public DetailContentValues putPosterPath(String value) {
        if (value == null) throw new IllegalArgumentException("posterPath must not be null");
        mContentValues.put(DetailColumns.POSTER_PATH, value);
        return this;
    }


    /**
     * backdrop path of the movie
     */
    public DetailContentValues putBackdropPath(String value) {
        if (value == null) throw new IllegalArgumentException("backdropPath must not be null");
        mContentValues.put(DetailColumns.BACKDROP_PATH, value);
        return this;
    }


    /**
     * vote average of the movie
     */
    public DetailContentValues putVoteAverage(float value) {
        mContentValues.put(DetailColumns.VOTE_AVERAGE, value);
        return this;
    }


    /**
     * vote count of the movie
     */
    public DetailContentValues putVoteCount(int value) {
        mContentValues.put(DetailColumns.VOTE_COUNT, value);
        return this;
    }


    /**
     * synopsis of the movie
     */
    public DetailContentValues putOverview(String value) {
        if (value == null) throw new IllegalArgumentException("overview must not be null");
        mContentValues.put(DetailColumns.OVERVIEW, value);
        return this;
    }

}
