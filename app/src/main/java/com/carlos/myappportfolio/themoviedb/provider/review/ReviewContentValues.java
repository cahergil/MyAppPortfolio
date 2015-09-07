package com.carlos.myappportfolio.themoviedb.provider.review;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;

import com.carlos.myappportfolio.themoviedb.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code review} table.
 */
public class ReviewContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return ReviewColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver,  ReviewSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context,  ReviewSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * the movie id
     */
    public ReviewContentValues putMovieId(int value) {
        mContentValues.put(ReviewColumns.MOVIE_ID, value);
        return this;
    }


    /**
     * page of the review
     */
    public ReviewContentValues putPage(String value) {
        if (value == null) throw new IllegalArgumentException("page must not be null");
        mContentValues.put(ReviewColumns.PAGE, value);
        return this;
    }


    /**
     * author of the review
     */
    public ReviewContentValues putAuthor(String value) {
        if (value == null) throw new IllegalArgumentException("author must not be null");
        mContentValues.put(ReviewColumns.AUTHOR, value);
        return this;
    }


    /**
     * content of the review
     */
    public ReviewContentValues putContent(String value) {
        if (value == null) throw new IllegalArgumentException("content must not be null");
        mContentValues.put(ReviewColumns.CONTENT, value);
        return this;
    }

}
