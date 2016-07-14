package com.carlos.popularmovies.themoviedb;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.carlos.popularmovies.R;
import com.carlos.popularmovies.themoviedb.models.MovieDetail;
import com.carlos.popularmovies.themoviedb.models.MovieImages;
import com.carlos.popularmovies.themoviedb.models.Reviews;
import com.carlos.popularmovies.themoviedb.models.Trailers;
import com.carlos.popularmovies.utils.AppConstants;
import com.carlos.popularmovies.utils.Utilities;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private String mMovieId;
    private MovieDetail mMovieDetail;
    private TextView mTvRunTime, mTvReleaseDate, mTvRate, mTvSynopsis;
    private ImageView mIvPoster, mIvCollapsingPoster;
    private boolean mUserRotate = false;
    private ArrayList<Trailers.YoutubeEntity> mlistTrailers = new ArrayList<Trailers.YoutubeEntity>();
    private ArrayList<Reviews.ResultsEntity> mlistReviews = new ArrayList<Reviews.ResultsEntity>();
    private ArrayList<MovieImages.BackdropsEntity> mListBackdrops=new ArrayList<MovieImages.BackdropsEntity>();
    private ArrayList<MovieImages.PostersEntity> mListPoster=new ArrayList<MovieImages.PostersEntity>();

    SharedPreferenceManager mSharedPreferenceManager;

    private ImageView mIvFavorite;
    private boolean mFavoritesMode = false;
    private boolean mTwoPaneMode;
    private boolean mRemoveFragment = false;
    private String mCustomFrag;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ScrollView mScrollView;
    private boolean mMovieInFavorites;
    private MovieImages mMovieImages;



    public DetailActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        Bundle bundle = getArguments();
        mSharedPreferenceManager = new SharedPreferenceManager(getActivity());
        if (bundle != null) {
            mMovieId = (String) bundle.get("movieId");
            mFavoritesMode = bundle.getBoolean("favoritesMode");
            mTwoPaneMode = bundle.getBoolean("twoPaneMode");
            mCustomFrag = bundle.getString("customFrag");
        }
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "Lobster-Regular.ttf");
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        mCollapsingToolbarLayout.setExpandedTitleTypeface(typeface);
        mCollapsingToolbarLayout.setCollapsedTitleTypeface(typeface);


        //for transition listener
        mScrollView = (ScrollView) view.findViewById(R.id.svMain);
        // mTvTitle= (TextView) view.findViewById(R.id.tvTitle);
        mTvRunTime = (TextView) view.findViewById(R.id.tvRunTime);
        mTvReleaseDate = (TextView) view.findViewById(R.id.tvReleaseDate);
        mTvRate = (TextView) view.findViewById(R.id.tvRate);
        mTvSynopsis = (TextView) view.findViewById(R.id.tvSynopsis);
        mIvPoster = (ImageView) view.findViewById(R.id.ivPoster);
        mIvCollapsingPoster = (ImageView) view.findViewById(R.id.collapsingPoster);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();

            }
        });
        if(mTwoPaneMode) {
            toolbar.setVisibility(Toolbar.INVISIBLE);
        }
        mIvFavorite = (ImageView) view.findViewById(R.id.btnFavorite);
        mIvFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mTwoPaneMode == true && mFavoritesMode == true) {
                    mRemoveFragment = true;
                    sendBundleBroadcast();
                    DetailActivityFragment detailActivityFragment = (DetailActivityFragment) getActivity().getSupportFragmentManager()
                            .findFragmentByTag(mCustomFrag);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .remove(detailActivityFragment)
                            .commit();

                }
                List<MovieDetail> tempList;
                if (!mMovieInFavorites) {
                    tempList = mSharedPreferenceManager.getFavoritesList();
                    if (tempList == null) {
                        tempList = new ArrayList<MovieDetail>();
                     }
                     tempList.add(mMovieDetail);
                     mSharedPreferenceManager.saveFavoritesList(tempList);
                     Picasso.with(getActivity())
                             .load(R.drawable.ic_favorite)
                             .into(mIvFavorite);
                     mMovieInFavorites=!mMovieInFavorites;
                    Snackbar.make(v,"Movie added to favorites",Snackbar.LENGTH_LONG).show();

                } else {
                    tempList= mSharedPreferenceManager.getFavoritesList();
                    tempList.remove(mMovieDetail);
                    mSharedPreferenceManager.saveFavoritesList(tempList);
                    Picasso.with(getActivity())
                            .load(R.drawable.ic_favorite_outline)
                            .into(mIvFavorite);
                    mMovieInFavorites=!mMovieInFavorites;
                    Snackbar.make(v,"Movie removed from favorites",Snackbar.LENGTH_LONG).show();

                }
            }
        });


        if (savedInstanceState != null) {
            mUserRotate = true;
            mMovieDetail = savedInstanceState.getParcelable("movieDetails");
            ArrayList<Reviews.ResultsEntity> listReviewsTemp;
            listReviewsTemp = savedInstanceState.getParcelableArrayList("reviewsList");
            mlistReviews.addAll(listReviewsTemp);

            ArrayList<Trailers.YoutubeEntity> listTrailersTemp;
            listTrailersTemp = savedInstanceState.getParcelableArrayList("trailerList");
            mlistTrailers.addAll(listTrailersTemp);


        }


        return view;
    }

    public void sendBundleBroadcast() {

        Intent intent = new Intent("remove-item-favorites");
        Bundle bundle = new Bundle();
        if (mRemoveFragment == true) {
            bundle.putBoolean("removeFragment", mRemoveFragment);
            intent.putExtras(bundle);
        }

        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mUserRotate != true) {
            getMoviesDetail();

        } else {
            displayDataOnScreen();
        }
        mUserRotate = false;


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putParcelable("movieDetails", mMovieDetail);
        outState.putParcelableArrayList("reviewsList", mlistReviews);
        outState.putParcelableArrayList("trailerList", mlistTrailers);
        outState.putBoolean("movideInFavorites",mFavoritesMode);
        super.onSaveInstanceState(outState);
    }


    public void getMoviesDetail() {

        if (mFavoritesMode != true) {
            ApiClient.MyApi myApi = ApiClient.getMyApiClient();
            myApi.getMovieDetails(mMovieId, AppConstants.API_KEY, callbackResponse());
        } else {

            mMovieDetail = mSharedPreferenceManager.getMovieFromFavoritesList(Integer.parseInt(mMovieId));
            Trailers trailers = mMovieDetail.getTrailers();
            mlistTrailers.clear();
            mlistTrailers.addAll(trailers.getYoutubeTrailers());


            Reviews reviews = mMovieDetail.getReviews();
            mlistReviews.clear();
            mlistReviews.addAll(reviews.getListReviews());


            displayDataOnScreen();
        }
    }



    private Callback<MovieDetail> callbackResponse() {

        return new Callback<MovieDetail>() {

            @Override
            public void success(MovieDetail movieDetail, retrofit.client.Response response) {
                mMovieDetail = movieDetail;
                displayDataOnScreen();

            }

            @Override
            public void failure(RetrofitError error) {
                Log.v("VILLANUEVA", "errro:" + error.getMessage().toString());

            }
        };


    }

    private void displayDataOnScreen() {
        mCollapsingToolbarLayout.setTitle(mMovieDetail.getTitle());

     //   String pathPoster = AppConstants.POSTER_BASE_URL + mMovieDetail.getPoster_path();
        String pathBackdrop = AppConstants.POSTER_BASE_URL + mMovieDetail.getBackdrop_path();

        //backdrop
        MovieImages movieImages=mMovieDetail.getImages();
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
            Picasso.with(getActivity())
                    .load(pathBackdropFullQuality)
                    .centerCrop()
                    .resize((int)Utilities.convertDpToPixel(135,getActivity()),(int)Utilities.convertDpToPixel(166,getActivity()))
                    .into(mIvPoster);
        } else {
            Picasso.with(getActivity()).load(pathBackdrop).into(mIvPoster);
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
            Picasso.with(getActivity()).load(pathPosterFullQuality).into(mIvCollapsingPoster);
        } else {
            Picasso.with(getActivity()).load(pathBackdrop).into(mIvCollapsingPoster);
        }



        mTvRunTime.setText(String.valueOf(mMovieDetail.getRuntime()) + "m");
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = null;
        try {
            Date date = parser.parse(mMovieDetail.getRelease_date());
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
            formattedDate = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mTvReleaseDate.setText(formattedDate);
        mTvRate.setText(mMovieDetail.getVote_average() + "/10" + "(" + mMovieDetail.getVote_count() + " votes)");
        TextView tvSynopsis= (TextView) getView().findViewById(R.id.tvHeaderSynopsis);
        Typeface myTypeface=Typeface.createFromAsset(getActivity().getAssets(),"Lobster-Regular.ttf");
        tvSynopsis.setTypeface(myTypeface);
        mTvSynopsis.setText(mMovieDetail.getOverview());
        int drawableId;
        if (mSharedPreferenceManager.isMovieInFavorites(mMovieDetail)) {
            drawableId = R.drawable.ic_favorite;
            mMovieInFavorites = true;
        } else {
            drawableId = R.drawable.ic_favorite_outline;
            mMovieInFavorites = false;
        }
        Picasso.with(getActivity()).
                load(drawableId).
                into(mIvFavorite);

        //trailers
        TextView tvTrailers= (TextView) getView().findViewById(R.id.txtTrailers);
        tvTrailers.setTypeface(myTypeface);
        Trailers trailers=mMovieDetail.getTrailers();
        List<Trailers.YoutubeEntity> trailersList=trailers.getYoutubeTrailers();
        LinearLayout trailersLinearLayout= (LinearLayout) getView().findViewById(R.id.llTrailers);

        for (int i = 0; i<trailersList.size();i++) {
            final Trailers.YoutubeEntity trailer=trailersList.get(i);
            View v=LayoutInflater.from(getActivity()).inflate(R.layout.trailers,trailersLinearLayout,false);
            TextView tvTrailerTitle= (TextView) v.findViewById(R.id.trailerTitle);
            ImageView IvTrailerContainer= (ImageView) v.findViewById(R.id.trailerContainer);
            tvTrailerTitle.setText(trailer.getName());
            String trailerPath=String.format(AppConstants.YOUTUBE_IMAGE_BASE_URL,trailer.getSource());
            Picasso.with(getActivity())
                    .load(trailerPath)
                    .into(IvTrailerContainer);
            IvTrailerContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String buildUrl=AppConstants.YOURTUBE_BASE_URL + trailer.getSource();
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(buildUrl));
                    startActivity(intent);
                }
            });
            trailersLinearLayout.addView(v);


        }


        //reviews
        TextView tvReviews= (TextView) getView().findViewById(R.id.txtReviews);
        tvReviews.setTypeface(myTypeface);
        Reviews reviews=mMovieDetail.getReviews();
        List<Reviews.ResultsEntity> reviewsList=reviews.getListReviews();

        LinearLayout reviewLinearLayout= (LinearLayout) getView().findViewById(R.id.llReviews);
        for(int i = 0; i<reviewsList.size();i++) {
            Reviews.ResultsEntity review =reviewsList.get(i);
            View view=LayoutInflater.from(getActivity()).inflate(R.layout.reviews,reviewLinearLayout,false);
            TextView nameAutor= (TextView) view.findViewById(R.id.autorName);
            nameAutor.setText(review.getAuthor());
            TextView content= (TextView) view.findViewById(R.id.content);
            content.setText(review.getContent());
            reviewLinearLayout.addView(view);
        }

        if(!mTwoPaneMode) {
            getActivity().supportStartPostponedEnterTransition();
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setTransitionListenerV21() {
        final Transition fade = getActivity().getWindow().getEnterTransition();
        //fade.setDuration(200);
        fade.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                mScrollView.setVisibility(View.VISIBLE);

                fade.removeListener(this);
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
        getActivity().getWindow().setEnterTransition(fade);


    }
}
