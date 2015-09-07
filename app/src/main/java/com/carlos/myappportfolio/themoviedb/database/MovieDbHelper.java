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

        final String SQL_CREATE_MOVIEGRID="CREATE TABLE "+ MovieContract.GridView.TABLE_NAME + "(" +
                MovieContract.GridView._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MovieContract.GridView.COLUMN_MOVIE_ID + " INTEGER NOT NULL," +
                MovieContract.GridView.COLUMN_TITLE +    " TEXT NOT NULL," +
                MovieContract.GridView.COLUMN_POSTER_PATH + "TEXT NOT NULL);";


        final String SQL_CREATE_MOVIEDETAIL="CREATE TABLE "+ MovieContract.Detail.TABLE_NAME + "(" +
                MovieContract.Detail._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MovieContract.Detail.COLUMN_MOVIE_ID      + " INTEGER NOT NULL," +
                MovieContract.Detail.COLUMN_TITLE         + " TEXT NOT NULL," +
                MovieContract.Detail.COLUMN_RUNTIME       + " INTEGER NOT NULL," +
                MovieContract.Detail.COLUMN_RELEASE_DATE  + " TEXT NOT NULL," +
                MovieContract.Detail.COLUMN_POSTER_PATH   + " TEXT NOT NULL," +
                MovieContract.Detail.COLUMN_BACKDROP_PATH + " TEXT NOT NULL," +
                MovieContract.Detail.COLUMN_VOTE_AVERAGE  + " REAL NOT NULL," +
                MovieContract.Detail.COLUMN_VOTE_COUNT    + " INTEGER NOT NULL," +
                MovieContract.Detail.COLUMN_OVERVIEW      + " TEXT NOT NULL);";

        final String SQL_CREATE_TRAILER="CREATE TABLE " + MovieContract.Trailer.TABLE_NAME + "(" +
                MovieContract.Trailer._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MovieContract.Trailer.COLUMN_MOVIE_ID + " INTEGER NOT NULL," +
                MovieContract.Trailer.COLUMN_TRAILER_NAME + " TEXT NOT NULL," +
                MovieContract.Trailer.COLUMN_SIZE + " TEXT NOT NULL," +
                MovieContract.Trailer.COLUMN_SOURCE + " TEXT NOT NULL," +
                MovieContract.Trailer.COLUMN_TYPE + " TEXT NOT NULL);";

        final String SQL_CREATE_REVIEW="CREATE TABLE " + MovieContract.Review.TABLE_NAME + "(" +
                MovieContract.Review._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MovieContract.Review.COLUMN_MOVIE_ID + " INTEGER NOT NULL," +
                MovieContract.Review.COLUMN_PAGE + " INTEGER NOT NULL," +
                MovieContract.Review.COLUMN_AUTHOR + " TEXT NOT NULL," +
                MovieContract.Review.COLUMN_CONTENT + " TEXT NOT NULL);";



        db.execSQL(SQL_CREATE_MOVIEGRID);
        db.execSQL(SQL_CREATE_MOVIEDETAIL);
        db.execSQL(SQL_CREATE_TRAILER);
        db.execSQL(SQL_CREATE_REVIEW);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
