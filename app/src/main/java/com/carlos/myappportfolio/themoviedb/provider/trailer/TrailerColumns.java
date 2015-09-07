package com.carlos.myappportfolio.themoviedb.provider.trailer;

import android.net.Uri;
import android.provider.BaseColumns;

import com.carlos.myappportfolio.themoviedb.provider.MoviesProvider;
import com.carlos.myappportfolio.themoviedb.provider.detail.DetailColumns;
import com.carlos.myappportfolio.themoviedb.provider.gridview.GridviewColumns;
import com.carlos.myappportfolio.themoviedb.provider.review.ReviewColumns;
import com.carlos.myappportfolio.themoviedb.provider.trailer.TrailerColumns;

/**
 * the trailers of the movie
 */
public class TrailerColumns implements BaseColumns {
    public static final String TABLE_NAME = "trailer";
    public static final Uri CONTENT_URI = Uri.parse(MoviesProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * the movie id
     */
    public static final String MOVIE_ID = "movie_id";

    /**
     * name of the trailer
     */
    public static final String TRAILER_NAME = "trailer_name";

    /**
     * size of the trailer
     */
    public static final String SIZE = "size";

    /**
     * youtube page of the trailer
     */
    public static final String SOURCE = "source";

    /**
     * type of the trailer
     */
    public static final String TYPE = "type";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            MOVIE_ID,
            TRAILER_NAME,
            SIZE,
            SOURCE,
            TYPE
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(MOVIE_ID) || c.contains("." + MOVIE_ID)) return true;
            if (c.equals(TRAILER_NAME) || c.contains("." + TRAILER_NAME)) return true;
            if (c.equals(SIZE) || c.contains("." + SIZE)) return true;
            if (c.equals(SOURCE) || c.contains("." + SOURCE)) return true;
            if (c.equals(TYPE) || c.contains("." + TYPE)) return true;
        }
        return false;
    }

}
