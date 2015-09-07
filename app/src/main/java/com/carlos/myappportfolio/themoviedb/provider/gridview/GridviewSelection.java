package com.carlos.myappportfolio.themoviedb.provider.gridview;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.carlos.myappportfolio.themoviedb.provider.base.AbstractSelection;

/**
 * Selection for the {@code gridview} table.
 */
public class GridviewSelection extends AbstractSelection<GridviewSelection> {
    @Override
    protected Uri baseUri() {
        return GridviewColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code GridviewCursor} object, which is positioned before the first entry, or null.
     */
    public GridviewCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new GridviewCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public GridviewCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code GridviewCursor} object, which is positioned before the first entry, or null.
     */
    public GridviewCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new GridviewCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public GridviewCursor query(Context context) {
        return query(context, null);
    }


    public GridviewSelection id(long... value) {
        addEquals("gridview." + GridviewColumns._ID, toObjectArray(value));
        return this;
    }

    public GridviewSelection idNot(long... value) {
        addNotEquals("gridview." + GridviewColumns._ID, toObjectArray(value));
        return this;
    }

    public GridviewSelection orderById(boolean desc) {
        orderBy("gridview." + GridviewColumns._ID, desc);
        return this;
    }

    public GridviewSelection orderById() {
        return orderById(false);
    }

    public GridviewSelection movieId(int... value) {
        addEquals(GridviewColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public GridviewSelection movieIdNot(int... value) {
        addNotEquals(GridviewColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public GridviewSelection movieIdGt(int value) {
        addGreaterThan(GridviewColumns.MOVIE_ID, value);
        return this;
    }

    public GridviewSelection movieIdGtEq(int value) {
        addGreaterThanOrEquals(GridviewColumns.MOVIE_ID, value);
        return this;
    }

    public GridviewSelection movieIdLt(int value) {
        addLessThan(GridviewColumns.MOVIE_ID, value);
        return this;
    }

    public GridviewSelection movieIdLtEq(int value) {
        addLessThanOrEquals(GridviewColumns.MOVIE_ID, value);
        return this;
    }

    public GridviewSelection orderByMovieId(boolean desc) {
        orderBy(GridviewColumns.MOVIE_ID, desc);
        return this;
    }

    public GridviewSelection orderByMovieId() {
        orderBy(GridviewColumns.MOVIE_ID, false);
        return this;
    }

    public GridviewSelection title(String... value) {
        addEquals(GridviewColumns.TITLE, value);
        return this;
    }

    public GridviewSelection titleNot(String... value) {
        addNotEquals(GridviewColumns.TITLE, value);
        return this;
    }

    public GridviewSelection titleLike(String... value) {
        addLike(GridviewColumns.TITLE, value);
        return this;
    }

    public GridviewSelection titleContains(String... value) {
        addContains(GridviewColumns.TITLE, value);
        return this;
    }

    public GridviewSelection titleStartsWith(String... value) {
        addStartsWith(GridviewColumns.TITLE, value);
        return this;
    }

    public GridviewSelection titleEndsWith(String... value) {
        addEndsWith(GridviewColumns.TITLE, value);
        return this;
    }

    public GridviewSelection orderByTitle(boolean desc) {
        orderBy(GridviewColumns.TITLE, desc);
        return this;
    }

    public GridviewSelection orderByTitle() {
        orderBy(GridviewColumns.TITLE, false);
        return this;
    }

    public GridviewSelection posterPath(String... value) {
        addEquals(GridviewColumns.POSTER_PATH, value);
        return this;
    }

    public GridviewSelection posterPathNot(String... value) {
        addNotEquals(GridviewColumns.POSTER_PATH, value);
        return this;
    }

    public GridviewSelection posterPathLike(String... value) {
        addLike(GridviewColumns.POSTER_PATH, value);
        return this;
    }

    public GridviewSelection posterPathContains(String... value) {
        addContains(GridviewColumns.POSTER_PATH, value);
        return this;
    }

    public GridviewSelection posterPathStartsWith(String... value) {
        addStartsWith(GridviewColumns.POSTER_PATH, value);
        return this;
    }

    public GridviewSelection posterPathEndsWith(String... value) {
        addEndsWith(GridviewColumns.POSTER_PATH, value);
        return this;
    }

    public GridviewSelection orderByPosterPath(boolean desc) {
        orderBy(GridviewColumns.POSTER_PATH, desc);
        return this;
    }

    public GridviewSelection orderByPosterPath() {
        orderBy(GridviewColumns.POSTER_PATH, false);
        return this;
    }
}
