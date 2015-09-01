package com.carlos.myappportfolio.themoviedb.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Carlos on 28/08/2015.
 */
public class MovieDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "movies.db";

    public MovieDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_MOVIEGRID="CREATE TABLE "+ MovieContract.MovieGridViewEntry.TABLE_NAME + "(" +
                MovieContract.MovieGridViewEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MovieContract.MovieGridViewEntry.COLUMN_MOVIE_ID + " INTEGER NOT NULL," +
                MovieContract.MovieGridViewEntry.COLUMN_TITLE +    " TEXT NOT NULL," +
                MovieContract.MovieGridViewEntry.COLUMN_POSTER_PATH + "TEXT NOT NULL);";


        final String SQL_CREATE_MOVIEDETAIL="CREATE TABLE "+ MovieContract.MovieDetailsEntry.TABLE_NAME + "(" +
                MovieContract.MovieDetailsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MovieContract.MovieDetailsEntry.COLUMN_MOVIE_ID      + " INTEGER NOT NULL," +
                MovieContract.MovieDetailsEntry.COLUMN_TITLE         + " TEXT NOT NULL," +
                MovieContract.MovieDetailsEntry.COLUMN_RUNTIME       + " INTEGER NOT NULL," +
                MovieContract.MovieDetailsEntry.COLUMN_RELEASE_DATE  + " TEXT NOT NULL," +
                MovieContract.MovieDetailsEntry.COLUMN_POSTER_PATH   + " TEXT NOT NULL," +
                MovieContract.MovieDetailsEntry.COLUMN_BACKDROP_PATH + " TEXT NOT NULL," +
                MovieContract.MovieDetailsEntry.COLUMN_VOTE_AVERAGE  + " REAL NOT NULL," +
                MovieContract.MovieDetailsEntry.COLUMN_VOTE_COUNT    + " INTEGER NOT NULL," +
                MovieContract.MovieDetailsEntry.COLUMN_OVERVIEW      + " TEXT NOT NULL);";

        final String SQL_CREATE_TRAILER="CREATE TABLE " + MovieContract.MovieTrailersEntry.TABLE_NAME + "(" +
                MovieContract.MovieTrailersEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MovieContract.MovieTrailersEntry.COLUMN_MOVIE_ID + " INTEGER NOT NULL," +
                MovieContract.MovieTrailersEntry.COLUMN_TRAILER_NAME + " TEXT NOT NULL," +
                MovieContract.MovieTrailersEntry.COLUMN_SIZE + " TEXT NOT NULL," +
                MovieContract.MovieTrailersEntry.COLUMN_SOURCE + " TEXT NOT NULL," +
                MovieContract.MovieTrailersEntry.COLUMN_TYPE + " TEXT NOT NULL);";

        final String SQL_CREATE_REVIEW="CREATE TABLE " + MovieContract.MovieReviewsEntry.TABLE_NAME + "(" +
                MovieContract.MovieReviewsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MovieContract.MovieReviewsEntry.COLUMN_MOVIE_ID + " INTEGER NOT NULL," +
                MovieContract.MovieReviewsEntry.COLUMN_PAGE + " INTEGER NOT NULL," +
                MovieContract.MovieReviewsEntry.COLUMN_AUTHOR + " TEXT NOT NULL," +
                MovieContract.MovieReviewsEntry.COLUMN_CONTENT + " TEXT NOT NULL);";



        db.execSQL(SQL_CREATE_MOVIEGRID);
        db.execSQL(SQL_CREATE_MOVIEDETAIL);
        db.execSQL(SQL_CREATE_TRAILER);
        db.execSQL(SQL_CREATE_REVIEW);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
