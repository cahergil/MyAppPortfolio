package com.carlos.popularmovies.themoviedb.view;

import android.graphics.Typeface;
import android.view.View;

import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;

/**
 * Created by Carlos on 23/07/2016.
 */
public interface DetailsMvpView extends MvpView {

    public void loadMovieDetails(MovieDetail movieDetail);
    public void showServerError(String error);
    public void launchYouTubeVideo(String url);
    public void showInFavorite(View v);
    public void showOutFavorite(View v);
    public void showFavorite(int drawable);
    public void showBackdropFullQuality(String pathBackdropFullQuality);
    public void showBackdropLowQuality(String pathBackdrop);
    public void showCollapsingPosterFullQuality(String pathPosterFullQuality);
    public void showCollapsingPosterLowQuality(String pathPoster);
    public void showRunTime(String runTime);
    public void showReleaseDate(String releaseDate);
    public void showRate(String rate);
    public void showSynopsis(String synopsis, Typeface myTypeface);

}
