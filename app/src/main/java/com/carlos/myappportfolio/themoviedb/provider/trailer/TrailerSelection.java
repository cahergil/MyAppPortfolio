package com.carlos.myappportfolio.themoviedb.provider.trailer;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.carlos.myappportfolio.themoviedb.provider.base.AbstractSelection;

/**
 * Selection for the {@code trailer} table.
 */
public class TrailerSelection extends AbstractSelection<TrailerSelection> {
    @Override
    protected Uri baseUri() {
        return TrailerColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code TrailerCursor} object, which is positioned before the first entry, or null.
     */
    public TrailerCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new TrailerCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public TrailerCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code TrailerCursor} object, which is positioned before the first entry, or null.
     */
    public TrailerCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new TrailerCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public TrailerCursor query(Context context) {
        return query(context, null);
    }


    public TrailerSelection id(long... value) {
        addEquals("trailer." + TrailerColumns._ID, toObjectArray(value));
        return this;
    }

    public TrailerSelection idNot(long... value) {
        addNotEquals("trailer." + TrailerColumns._ID, toObjectArray(value));
        return this;
    }

    public TrailerSelection orderById(boolean desc) {
        orderBy("trailer." + TrailerColumns._ID, desc);
        return this;
    }

    public TrailerSelection orderById() {
        return orderById(false);
    }

    public TrailerSelection movieId(int... value) {
        addEquals(TrailerColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public TrailerSelection movieIdNot(int... value) {
        addNotEquals(TrailerColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public TrailerSelection movieIdGt(int value) {
        addGreaterThan(TrailerColumns.MOVIE_ID, value);
        return this;
    }

    public TrailerSelection movieIdGtEq(int value) {
        addGreaterThanOrEquals(TrailerColumns.MOVIE_ID, value);
        return this;
    }

    public TrailerSelection movieIdLt(int value) {
        addLessThan(TrailerColumns.MOVIE_ID, value);
        return this;
    }

    public TrailerSelection movieIdLtEq(int value) {
        addLessThanOrEquals(TrailerColumns.MOVIE_ID, value);
        return this;
    }

    public TrailerSelection orderByMovieId(boolean desc) {
        orderBy(TrailerColumns.MOVIE_ID, desc);
        return this;
    }

    public TrailerSelection orderByMovieId() {
        orderBy(TrailerColumns.MOVIE_ID, false);
        return this;
    }

    public TrailerSelection trailerName(String... value) {
        addEquals(TrailerColumns.TRAILER_NAME, value);
        return this;
    }

    public TrailerSelection trailerNameNot(String... value) {
        addNotEquals(TrailerColumns.TRAILER_NAME, value);
        return this;
    }

    public TrailerSelection trailerNameLike(String... value) {
        addLike(TrailerColumns.TRAILER_NAME, value);
        return this;
    }

    public TrailerSelection trailerNameContains(String... value) {
        addContains(TrailerColumns.TRAILER_NAME, value);
        return this;
    }

    public TrailerSelection trailerNameStartsWith(String... value) {
        addStartsWith(TrailerColumns.TRAILER_NAME, value);
        return this;
    }

    public TrailerSelection trailerNameEndsWith(String... value) {
        addEndsWith(TrailerColumns.TRAILER_NAME, value);
        return this;
    }

    public TrailerSelection orderByTrailerName(boolean desc) {
        orderBy(TrailerColumns.TRAILER_NAME, desc);
        return this;
    }

    public TrailerSelection orderByTrailerName() {
        orderBy(TrailerColumns.TRAILER_NAME, false);
        return this;
    }

    public TrailerSelection size(String... value) {
        addEquals(TrailerColumns.SIZE, value);
        return this;
    }

    public TrailerSelection sizeNot(String... value) {
        addNotEquals(TrailerColumns.SIZE, value);
        return this;
    }

    public TrailerSelection sizeLike(String... value) {
        addLike(TrailerColumns.SIZE, value);
        return this;
    }

    public TrailerSelection sizeContains(String... value) {
        addContains(TrailerColumns.SIZE, value);
        return this;
    }

    public TrailerSelection sizeStartsWith(String... value) {
        addStartsWith(TrailerColumns.SIZE, value);
        return this;
    }

    public TrailerSelection sizeEndsWith(String... value) {
        addEndsWith(TrailerColumns.SIZE, value);
        return this;
    }

    public TrailerSelection orderBySize(boolean desc) {
        orderBy(TrailerColumns.SIZE, desc);
        return this;
    }

    public TrailerSelection orderBySize() {
        orderBy(TrailerColumns.SIZE, false);
        return this;
    }

    public TrailerSelection source(String... value) {
        addEquals(TrailerColumns.SOURCE, value);
        return this;
    }

    public TrailerSelection sourceNot(String... value) {
        addNotEquals(TrailerColumns.SOURCE, value);
        return this;
    }

    public TrailerSelection sourceLike(String... value) {
        addLike(TrailerColumns.SOURCE, value);
        return this;
    }

    public TrailerSelection sourceContains(String... value) {
        addContains(TrailerColumns.SOURCE, value);
        return this;
    }

    public TrailerSelection sourceStartsWith(String... value) {
        addStartsWith(TrailerColumns.SOURCE, value);
        return this;
    }

    public TrailerSelection sourceEndsWith(String... value) {
        addEndsWith(TrailerColumns.SOURCE, value);
        return this;
    }

    public TrailerSelection orderBySource(boolean desc) {
        orderBy(TrailerColumns.SOURCE, desc);
        return this;
    }

    public TrailerSelection orderBySource() {
        orderBy(TrailerColumns.SOURCE, false);
        return this;
    }

    public TrailerSelection type(String... value) {
        addEquals(TrailerColumns.TYPE, value);
        return this;
    }

    public TrailerSelection typeNot(String... value) {
        addNotEquals(TrailerColumns.TYPE, value);
        return this;
    }

    public TrailerSelection typeLike(String... value) {
        addLike(TrailerColumns.TYPE, value);
        return this;
    }

    public TrailerSelection typeContains(String... value) {
        addContains(TrailerColumns.TYPE, value);
        return this;
    }

    public TrailerSelection typeStartsWith(String... value) {
        addStartsWith(TrailerColumns.TYPE, value);
        return this;
    }

    public TrailerSelection typeEndsWith(String... value) {
        addEndsWith(TrailerColumns.TYPE, value);
        return this;
    }

    public TrailerSelection orderByType(boolean desc) {
        orderBy(TrailerColumns.TYPE, desc);
        return this;
    }

    public TrailerSelection orderByType() {
        orderBy(TrailerColumns.TYPE, false);
        return this;
    }
}
