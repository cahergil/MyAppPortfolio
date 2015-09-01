package com.carlos.myappportfolio.themoviedb.database;

import android.provider.BaseColumns;

/**
 * Created by Carlos on 28/08/2015.
 */
public class MovieContract {


    /**
     * class for movies that stay in GridView
     */
    public static final class MovieGridViewEntry implements BaseColumns {

        public static final String TABLE_NAME="moviegrid";
        public static final String COLUMN_MOVIE_ID="movie_id";
        public static final String COLUMN_TITLE="title";
        public static final String COLUMN_POSTER_PATH="poster_path";
    }

    /**
     *  class for the detail view
     */
    public static final class MovieDetailsEntry implements  BaseColumns {

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



    }
    /**
     * class for trailers
     */
    public static final class MovieTrailersEntry implements BaseColumns {

        public static final String TABLE_NAME="trailer";
        public static final String COLUMN_MOVIE_ID="movie_id";
        public static final String COLUMN_TRAILER_NAME="name";
        public static final String COLUMN_SIZE="size";
        public static final String COLUMN_SOURCE="source";
        public static final String COLUMN_TYPE="type";

    }

    /**
     * class for reviews
     */
    public static final class MovieReviewsEntry implements BaseColumns {

        public static final String TABLE_NAME="review";
        public static final String COLUMN_MOVIE_ID="movie_id";
        public static final String COLUMN_PAGE="page";
        public static final String COLUMN_AUTHOR="author";
        public static final String COLUMN_CONTENT="content";

    }



}
