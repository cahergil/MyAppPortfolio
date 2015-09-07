package com.carlos.myappportfolio.themoviedb.provider.review;

import android.net.Uri;
import android.provider.BaseColumns;

import com.carlos.myappportfolio.themoviedb.provider.MoviesProvider;
import com.carlos.myappportfolio.themoviedb.provider.detail.DetailColumns;
import com.carlos.myappportfolio.themoviedb.provider.gridview.GridviewColumns;
import com.carlos.myappportfolio.themoviedb.provider.review.ReviewColumns;
import com.carlos.myappportfolio.themoviedb.provider.trailer.TrailerColumns;

/**
 * the reviews of the movie
 */
public class ReviewColumns implements BaseColumns {
    public static final String TABLE_NAME = "review";
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
     * page of the review
     */
    public static final String PAGE = "page";

    /**
     * author of the review
     */
    public static final String AUTHOR = "author";

    /**
     * content of the review
     */
    public static final String CONTENT = "content";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            MOVIE_ID,
            PAGE,
            AUTHOR,
            CONTENT
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(MOVIE_ID) || c.contains("." + MOVIE_ID)) return true;
            if (c.equals(PAGE) || c.contains("." + PAGE)) return true;
            if (c.equals(AUTHOR) || c.contains("." + AUTHOR)) return true;
            if (c.equals(CONTENT) || c.contains("." + CONTENT)) return true;
        }
        return false;
    }

}
