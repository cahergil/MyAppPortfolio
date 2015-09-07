package com.carlos.myappportfolio.themoviedb.provider.detail;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.carlos.myappportfolio.themoviedb.provider.base.AbstractSelection;

/**
 * Selection for the {@code detail} table.
 */
public class DetailSelection extends AbstractSelection<DetailSelection> {
    @Override
    protected Uri baseUri() {
        return DetailColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code DetailCursor} object, which is positioned before the first entry, or null.
     */
    public DetailCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new DetailCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public DetailCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code DetailCursor} object, which is positioned before the first entry, or null.
     */
    public DetailCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new DetailCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public DetailCursor query(Context context) {
        return query(context, null);
    }


    public DetailSelection id(long... value) {
        addEquals("detail." + DetailColumns._ID, toObjectArray(value));
        return this;
    }

    public DetailSelection idNot(long... value) {
        addNotEquals("detail." + DetailColumns._ID, toObjectArray(value));
        return this;
    }

    public DetailSelection orderById(boolean desc) {
        orderBy("detail." + DetailColumns._ID, desc);
        return this;
    }

    public DetailSelection orderById() {
        return orderById(false);
    }

    public DetailSelection movieId(int... value) {
        addEquals(DetailColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public DetailSelection movieIdNot(int... value) {
        addNotEquals(DetailColumns.MOVIE_ID, toObjectArray(value));
        return this;
    }

    public DetailSelection movieIdGt(int value) {
        addGreaterThan(DetailColumns.MOVIE_ID, value);
        return this;
    }

    public DetailSelection movieIdGtEq(int value) {
        addGreaterThanOrEquals(DetailColumns.MOVIE_ID, value);
        return this;
    }

    public DetailSelection movieIdLt(int value) {
        addLessThan(DetailColumns.MOVIE_ID, value);
        return this;
    }

    public DetailSelection movieIdLtEq(int value) {
        addLessThanOrEquals(DetailColumns.MOVIE_ID, value);
        return this;
    }

    public DetailSelection orderByMovieId(boolean desc) {
        orderBy(DetailColumns.MOVIE_ID, desc);
        return this;
    }

    public DetailSelection orderByMovieId() {
        orderBy(DetailColumns.MOVIE_ID, false);
        return this;
    }

    public DetailSelection title(String... value) {
        addEquals(DetailColumns.TITLE, value);
        return this;
    }

    public DetailSelection titleNot(String... value) {
        addNotEquals(DetailColumns.TITLE, value);
        return this;
    }

    public DetailSelection titleLike(String... value) {
        addLike(DetailColumns.TITLE, value);
        return this;
    }

    public DetailSelection titleContains(String... value) {
        addContains(DetailColumns.TITLE, value);
        return this;
    }

    public DetailSelection titleStartsWith(String... value) {
        addStartsWith(DetailColumns.TITLE, value);
        return this;
    }

    public DetailSelection titleEndsWith(String... value) {
        addEndsWith(DetailColumns.TITLE, value);
        return this;
    }

    public DetailSelection orderByTitle(boolean desc) {
        orderBy(DetailColumns.TITLE, desc);
        return this;
    }

    public DetailSelection orderByTitle() {
        orderBy(DetailColumns.TITLE, false);
        return this;
    }

    public DetailSelection runtime(int... value) {
        addEquals(DetailColumns.RUNTIME, toObjectArray(value));
        return this;
    }

    public DetailSelection runtimeNot(int... value) {
        addNotEquals(DetailColumns.RUNTIME, toObjectArray(value));
        return this;
    }

    public DetailSelection runtimeGt(int value) {
        addGreaterThan(DetailColumns.RUNTIME, value);
        return this;
    }

    public DetailSelection runtimeGtEq(int value) {
        addGreaterThanOrEquals(DetailColumns.RUNTIME, value);
        return this;
    }

    public DetailSelection runtimeLt(int value) {
        addLessThan(DetailColumns.RUNTIME, value);
        return this;
    }

    public DetailSelection runtimeLtEq(int value) {
        addLessThanOrEquals(DetailColumns.RUNTIME, value);
        return this;
    }

    public DetailSelection orderByRuntime(boolean desc) {
        orderBy(DetailColumns.RUNTIME, desc);
        return this;
    }

    public DetailSelection orderByRuntime() {
        orderBy(DetailColumns.RUNTIME, false);
        return this;
    }

    public DetailSelection releasedate(String... value) {
        addEquals(DetailColumns.RELEASEDATE, value);
        return this;
    }

    public DetailSelection releasedateNot(String... value) {
        addNotEquals(DetailColumns.RELEASEDATE, value);
        return this;
    }

    public DetailSelection releasedateLike(String... value) {
        addLike(DetailColumns.RELEASEDATE, value);
        return this;
    }

    public DetailSelection releasedateContains(String... value) {
        addContains(DetailColumns.RELEASEDATE, value);
        return this;
    }

    public DetailSelection releasedateStartsWith(String... value) {
        addStartsWith(DetailColumns.RELEASEDATE, value);
        return this;
    }

    public DetailSelection releasedateEndsWith(String... value) {
        addEndsWith(DetailColumns.RELEASEDATE, value);
        return this;
    }

    public DetailSelection orderByReleasedate(boolean desc) {
        orderBy(DetailColumns.RELEASEDATE, desc);
        return this;
    }

    public DetailSelection orderByReleasedate() {
        orderBy(DetailColumns.RELEASEDATE, false);
        return this;
    }

    public DetailSelection posterPath(String... value) {
        addEquals(DetailColumns.POSTER_PATH, value);
        return this;
    }

    public DetailSelection posterPathNot(String... value) {
        addNotEquals(DetailColumns.POSTER_PATH, value);
        return this;
    }

    public DetailSelection posterPathLike(String... value) {
        addLike(DetailColumns.POSTER_PATH, value);
        return this;
    }

    public DetailSelection posterPathContains(String... value) {
        addContains(DetailColumns.POSTER_PATH, value);
        return this;
    }

    public DetailSelection posterPathStartsWith(String... value) {
        addStartsWith(DetailColumns.POSTER_PATH, value);
        return this;
    }

    public DetailSelection posterPathEndsWith(String... value) {
        addEndsWith(DetailColumns.POSTER_PATH, value);
        return this;
    }

    public DetailSelection orderByPosterPath(boolean desc) {
        orderBy(DetailColumns.POSTER_PATH, desc);
        return this;
    }

    public DetailSelection orderByPosterPath() {
        orderBy(DetailColumns.POSTER_PATH, false);
        return this;
    }

    public DetailSelection backdropPath(String... value) {
        addEquals(DetailColumns.BACKDROP_PATH, value);
        return this;
    }

    public DetailSelection backdropPathNot(String... value) {
        addNotEquals(DetailColumns.BACKDROP_PATH, value);
        return this;
    }

    public DetailSelection backdropPathLike(String... value) {
        addLike(DetailColumns.BACKDROP_PATH, value);
        return this;
    }

    public DetailSelection backdropPathContains(String... value) {
        addContains(DetailColumns.BACKDROP_PATH, value);
        return this;
    }

    public DetailSelection backdropPathStartsWith(String... value) {
        addStartsWith(DetailColumns.BACKDROP_PATH, value);
        return this;
    }

    public DetailSelection backdropPathEndsWith(String... value) {
        addEndsWith(DetailColumns.BACKDROP_PATH, value);
        return this;
    }

    public DetailSelection orderByBackdropPath(boolean desc) {
        orderBy(DetailColumns.BACKDROP_PATH, desc);
        return this;
    }

    public DetailSelection orderByBackdropPath() {
        orderBy(DetailColumns.BACKDROP_PATH, false);
        return this;
    }

    public DetailSelection voteAverage(float... value) {
        addEquals(DetailColumns.VOTE_AVERAGE, toObjectArray(value));
        return this;
    }

    public DetailSelection voteAverageNot(float... value) {
        addNotEquals(DetailColumns.VOTE_AVERAGE, toObjectArray(value));
        return this;
    }

    public DetailSelection voteAverageGt(float value) {
        addGreaterThan(DetailColumns.VOTE_AVERAGE, value);
        return this;
    }

    public DetailSelection voteAverageGtEq(float value) {
        addGreaterThanOrEquals(DetailColumns.VOTE_AVERAGE, value);
        return this;
    }

    public DetailSelection voteAverageLt(float value) {
        addLessThan(DetailColumns.VOTE_AVERAGE, value);
        return this;
    }

    public DetailSelection voteAverageLtEq(float value) {
        addLessThanOrEquals(DetailColumns.VOTE_AVERAGE, value);
        return this;
    }

    public DetailSelection orderByVoteAverage(boolean desc) {
        orderBy(DetailColumns.VOTE_AVERAGE, desc);
        return this;
    }

    public DetailSelection orderByVoteAverage() {
        orderBy(DetailColumns.VOTE_AVERAGE, false);
        return this;
    }

    public DetailSelection voteCount(int... value) {
        addEquals(DetailColumns.VOTE_COUNT, toObjectArray(value));
        return this;
    }

    public DetailSelection voteCountNot(int... value) {
        addNotEquals(DetailColumns.VOTE_COUNT, toObjectArray(value));
        return this;
    }

    public DetailSelection voteCountGt(int value) {
        addGreaterThan(DetailColumns.VOTE_COUNT, value);
        return this;
    }

    public DetailSelection voteCountGtEq(int value) {
        addGreaterThanOrEquals(DetailColumns.VOTE_COUNT, value);
        return this;
    }

    public DetailSelection voteCountLt(int value) {
        addLessThan(DetailColumns.VOTE_COUNT, value);
        return this;
    }

    public DetailSelection voteCountLtEq(int value) {
        addLessThanOrEquals(DetailColumns.VOTE_COUNT, value);
        return this;
    }

    public DetailSelection orderByVoteCount(boolean desc) {
        orderBy(DetailColumns.VOTE_COUNT, desc);
        return this;
    }

    public DetailSelection orderByVoteCount() {
        orderBy(DetailColumns.VOTE_COUNT, false);
        return this;
    }

    public DetailSelection overview(String... value) {
        addEquals(DetailColumns.OVERVIEW, value);
        return this;
    }

    public DetailSelection overviewNot(String... value) {
        addNotEquals(DetailColumns.OVERVIEW, value);
        return this;
    }

    public DetailSelection overviewLike(String... value) {
        addLike(DetailColumns.OVERVIEW, value);
        return this;
    }

    public DetailSelection overviewContains(String... value) {
        addContains(DetailColumns.OVERVIEW, value);
        return this;
    }

    public DetailSelection overviewStartsWith(String... value) {
        addStartsWith(DetailColumns.OVERVIEW, value);
        return this;
    }

    public DetailSelection overviewEndsWith(String... value) {
        addEndsWith(DetailColumns.OVERVIEW, value);
        return this;
    }

    public DetailSelection orderByOverview(boolean desc) {
        orderBy(DetailColumns.OVERVIEW, desc);
        return this;
    }

    public DetailSelection orderByOverview() {
        orderBy(DetailColumns.OVERVIEW, false);
        return this;
    }
}
