package com.carlos.popularmovies.themoviedb.presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.carlos.popularmovies.R;
import com.carlos.popularmovies.themoviedb.SharedPreferenceManager;
import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;
import com.carlos.popularmovies.themoviedb.api.model.MovieImages;
import com.carlos.popularmovies.themoviedb.api.model.Trailers;
import com.carlos.popularmovies.themoviedb.model.DetailsCallback;
import com.carlos.popularmovies.themoviedb.model.DetailsInteractor;
import com.carlos.popularmovies.themoviedb.view.DetailsMvpView;
import com.carlos.popularmovies.utils.AppConstants;
import com.carlos.popularmovies.utils.Utilities;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Carlos on 23/07/2016.
 */
public class DetailsPresenter implements Presenter<DetailsMvpView>,DetailsCallback {

    private DetailsMvpView mDetailsMvpView;
    private DetailsInteractor mDetailsInteractor;
    private SharedPreferenceManager mSharedPreferenceManager;
    private boolean mMovieInFavorite;
    private Context mContext;
    private Typeface myTypeface;

    @Override
    public void setView(DetailsMvpView view) {
        mDetailsMvpView=view;
        mDetailsInteractor=new DetailsInteractor(mDetailsMvpView.getContext());
        mContext=mDetailsMvpView.getContext();
        myTypeface = Typeface.createFromAsset(mContext.getAssets(), "Lobster-Regular.ttf");
        mSharedPreferenceManager=new SharedPreferenceManager(mDetailsMvpView.getContext());

    }

    @Override
    public void detachView() {
        mDetailsMvpView=null;
    }

    public void onSearchMovieDetails(String movieId) {
        mDetailsInteractor.getMovieDetails(movieId,this);
    }
    public void onLaunchYoutubeTrailer(String url){
        mDetailsMvpView.launchYouTubeVideo(url);
    }
    public boolean isMovieInFavorite(MovieDetail movieDetail) {
        mMovieInFavorite= mSharedPreferenceManager.isMovieInFavorites(movieDetail);
        return mMovieInFavorite;
    }
    public void onFavoriteClick(View v,MovieDetail movieDetail) {
        List<MovieDetail> tempList;
        if (!isMovieInFavorite(movieDetail)){
            tempList = mSharedPreferenceManager.getFavoritesList();
            if (tempList == null) {
                tempList = new ArrayList<MovieDetail>();
            }
            tempList.add(movieDetail);
            mSharedPreferenceManager.saveFavoritesList(tempList);
            mMovieInFavorite=true;
            mDetailsMvpView.showInFavorite(v);
        } else {
            tempList= mSharedPreferenceManager.getFavoritesList();
            tempList.remove(movieDetail);
            mSharedPreferenceManager.saveFavoritesList(tempList);
            mMovieInFavorite=false;
            mDetailsMvpView.showOutFavorite(v);
        }


    }
    public Typeface getLobsterRegularTypeface(){
        return myTypeface;
    }
    public void handleDataPresentation(MovieDetail movieDetail) {


        String pathBackdrop = AppConstants.POSTER_BASE_URL + movieDetail.getBackdrop_path();

        //backdrop
        MovieImages movieImages=movieDetail.getImages();
        List<MovieImages.BackdropsEntity> backdropsList=movieImages.getBackdrops();
        String pathBackdropFullQuality=null;
        if(backdropsList!=null) {
            for(int i=0;i<backdropsList.size();i++) {
                pathBackdropFullQuality=backdropsList.get(i).getFile_path();
                if(i==0) {
                    break;
                }
            }
        }
        if(pathBackdropFullQuality!=null) {
            pathBackdropFullQuality = AppConstants.POSTER_HQ_BASE_URL + pathBackdropFullQuality;
            mDetailsMvpView.showBackdropFullQuality(pathBackdropFullQuality);

        } else {
            mDetailsMvpView.showBackdropLowQuality(pathBackdrop);
        }
        //posters
        List<MovieImages.PostersEntity> postersList=movieImages.getPosters();
        String pathPosterFullQuality=null;
        if (postersList!=null) {
            for(int i=0; i<postersList.size();i++) {
                pathPosterFullQuality=postersList.get(i).getFile_path();
                if(i==0) {
                    break;
                }
            }
        }
        if( pathPosterFullQuality!=null) {
            pathPosterFullQuality=AppConstants.POSTER_HQ_BASE_URL + pathPosterFullQuality;
            mDetailsMvpView.showCollapsingPosterFullQuality(pathPosterFullQuality);

        } else {
            mDetailsMvpView.showCollapsingPosterLowQuality(pathBackdrop);
        }

        mDetailsMvpView.showRunTime(String.valueOf(movieDetail.getRuntime()) + "m");

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = null;
        try {
            Date date = parser.parse(movieDetail.getRelease_date());
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
            formattedDate = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mDetailsMvpView.showReleaseDate(formattedDate);
        mDetailsMvpView.showRate(movieDetail.getVote_average() + "/10" + "(" + movieDetail.getVote_count() + " votes)");
        int drawableId;
        if (isMovieInFavorite(movieDetail)) {
            drawableId = R.drawable.ic_favorite;
        } else {
            drawableId = R.drawable.ic_favorite_outline;
        }
        mDetailsMvpView.showFavorite(drawableId);
        mDetailsMvpView.showSynopsis(movieDetail.getOverview(),myTypeface);




    }

    @Override
    public void onResponse(MovieDetail movieDetail) {
        mDetailsMvpView.loadMovieDetails(movieDetail);
    }

    @Override
    public void onServerError(String error) {
        mDetailsMvpView.showServerError(error);
    }
}
