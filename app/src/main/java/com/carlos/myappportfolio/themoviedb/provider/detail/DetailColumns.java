package com.carlos.myappportfolio.themoviedb.provider.detail;

import android.net.Uri;
import android.provider.BaseColumns;

import com.carlos.myappportfolio.themoviedb.provider.MoviesProvider;
import com.carlos.myappportfolio.themoviedb.provider.detail.DetailColumns;
import com.carlos.myappportfolio.themoviedb.provider.gridview.GridviewColumns;
import com.carlos.myappportfolio.themoviedb.provider.review.ReviewColumns;
import com.carlos.myappportfolio.themoviedb.provider.trailer.TrailerColumns;

/**
 * the details of the movie
 */
public class DetailColumns implements BaseColumns {
    public static final String TABLE_NAME = "detail";
    public static final Uri CONTENT_URI = Uri.parse(MoviesProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * the id movie
     */
    public static final String MOVIE_ID = "movie_id";

    /**
     * the title of the movie
     */
    public static final String TITLE = "title";

    /**
     * runtime of the movie
     */
    public static final String RUNTIME = "runtime";

    /**
     * release date of the movie
     */
    public static final String RELEASEDATE = "releasedate";

    /**
     * poster path of the movie
     */
    public static final String POSTER_PATH = "poster_path";

    /**
     * backdrop path of the movie
     */
    public static final String BACKDROP_PATH = "backdrop_path";

    /**
     * vote average of the movie
     */
    public static final String VOTE_AVERAGE = "vote_average";

    /**
     * vote count of the movie
     */
    public static final String VOTE_COUNT = "vote_count";

    /**
     * synopsis of the movie
     */
    public static final String OVERVIEW = "overview";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            MOVIE_ID,
            TITLE,
            RUNTIME,
            RELEASEDATE,
            POSTER_PATH,
            BACKDROP_PATH,
            VOTE_AVERAGE,
            VOTE_COUNT,
            OVERVIEW
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(MOVIE_ID) || c.contains("." + MOVIE_ID)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(RUNTIME) || c.contains("." + RUNTIME)) return true;
            if (c.equals(RELEASEDATE) || c.contains("." + RELEASEDATE)) return true;
            if (c.equals(POSTER_PATH) || c.contains("." + POSTER_PATH)) return true;
            if (c.equals(BACKDROP_PATH) || c.contains("." + BACKDROP_PATH)) return true;
            if (c.equals(VOTE_AVERAGE) || c.contains("." + VOTE_AVERAGE)) return true;
            if (c.equals(VOTE_COUNT) || c.contains("." + VOTE_COUNT)) return true;
            if (c.equals(OVERVIEW) || c.contains("." + OVERVIEW)) return true;
        }
        return false;
    }

}
