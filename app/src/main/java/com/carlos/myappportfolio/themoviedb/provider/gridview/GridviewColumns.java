package com.carlos.myappportfolio.themoviedb.provider.gridview;

import android.net.Uri;
import android.provider.BaseColumns;

import com.carlos.myappportfolio.themoviedb.provider.MoviesProvider;
import com.carlos.myappportfolio.themoviedb.provider.detail.DetailColumns;
import com.carlos.myappportfolio.themoviedb.provider.gridview.GridviewColumns;
import com.carlos.myappportfolio.themoviedb.provider.review.ReviewColumns;
import com.carlos.myappportfolio.themoviedb.provider.trailer.TrailerColumns;

/**
 * the Gridview Entity
 */
public class GridviewColumns implements BaseColumns {
    public static final String TABLE_NAME = "gridview";
    public static final Uri CONTENT_URI = Uri.parse(MoviesProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * id de la pelicula
     */
    public static final String MOVIE_ID = "movie_id";

    /**
     * titulo de la pelicula
     */
    public static final String TITLE = "title";

    /**
     * poster de la pelicula
     */
    public static final String POSTER_PATH = "poster_path";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            MOVIE_ID,
            TITLE,
            POSTER_PATH
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(MOVIE_ID) || c.contains("." + MOVIE_ID)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(POSTER_PATH) || c.contains("." + POSTER_PATH)) return true;
        }
        return false;
    }

}
