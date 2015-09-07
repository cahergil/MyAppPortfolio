package com.carlos.myappportfolio.themoviedb.database;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Carlos on 28/08/2015.
 */
public class MovieContract {

    public static final String CONTENT_AUTHORITY="com.carlos.myappportfolio";
    public static final Uri BASE_CONTENT_URI=Uri.parse("content://"+CONTENT_AUTHORITY);

    /**
     * class for movies that stay in GridView
     */
    public static final class GridView implements BaseColumns {

        public static final String TABLE_NAME="moviegrid";
        public static final String COLUMN_MOVIE_ID="movie_id";
        public static final String COLUMN_TITLE="title";
        public static final String COLUMN_POSTER_PATH="poster_path";
        //create content uri
        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
        //create cursor for base type directory for multiples entries
        public static final String CONTENT_DIR_TYPE= ContentResolver.CURSOR_DIR_BASE_TYPE +
                "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        public static final String CONTENT_ITEM_TYPE =ContentResolver.CURSOR_ITEM_BASE_TYPE +
                "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;

        //for Building Uris on insertion
        public static Uri buildGridViewUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }


    }

    /**
     *  class for the detail view
     */
    public static final class Detail implements  BaseColumns {

        public static final String TABLE_NAME="detail";
        public static final String COLUMN_MOVIE_ID="movie_id";
        public static final String COLUMN_TITLE="title";
        public static final String COLUMN_RUNTIME="runtime";
        public static final String COLUMN_RELEASE_DATE="release_date";
        public static final String COLUMN_POSTER_PATH="poster_path";
        public static final String COLUMN_BACKDROP_PATH="backdrop_path";
        public static final String COLUMN_VOTE_AVERAGE="vote_average";
        public static final String COLUMN_VOTE_COUNT="vote_count";
        public static final String COLUMN_OVERVIEW="overview";

        //create content uri
        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
        //create cursor for base type directory for multiples entries
        public static final String CONTENT_DIR_TYPE= ContentResolver.CURSOR_DIR_BASE_TYPE +
                "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        public static final String CONTENT_ITEM_TYPE =ContentResolver.CURSOR_ITEM_BASE_TYPE +
                "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;

        //for Building Uris on insertion
        public static Uri buildDetailUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
    /**
     * class for trailers
     */
    public static final class Trailer implements BaseColumns {

        public static final String TABLE_NAME="trailer";
        public static final String COLUMN_MOVIE_ID="movie_id";
        public static final String COLUMN_TRAILER_NAME="name";
        public static final String COLUMN_SIZE="size";
        public static final String COLUMN_SOURCE="source";
        public static final String COLUMN_TYPE="type";
        //create content uri
        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
        //create cursor for base type directory for multiples entries
        public static final String CONTENT_DIR_TYPE= ContentResolver.CURSOR_DIR_BASE_TYPE +
                "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        public static final String CONTENT_ITEM_TYPE =ContentResolver.CURSOR_ITEM_BASE_TYPE +
                "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        //for Building Uris on insertion
        public static Uri buildTrailerUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    /**
     * class for reviews
     */
    public static final class Review implements BaseColumns {

        public static final String TABLE_NAME="review";
        public static final String COLUMN_MOVIE_ID="movie_id";
        public static final String COLUMN_PAGE="page";
        public static final String COLUMN_AUTHOR="author";
        public static final String COLUMN_CONTENT="content";
        //create content uri
        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(TABLE_NAME).build();
        //create cursor for base type directory for multiples entries
        public static final String CONTENT_DIR_TYPE= ContentResolver.CURSOR_DIR_BASE_TYPE +
                "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        public static final String CONTENT_ITEM_TYPE =ContentResolver.CURSOR_ITEM_BASE_TYPE +
                "/" + CONTENT_AUTHORITY + "/" + TABLE_NAME;
        //for Building Uris on insertion
        public static Uri buildReviewUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }



}
