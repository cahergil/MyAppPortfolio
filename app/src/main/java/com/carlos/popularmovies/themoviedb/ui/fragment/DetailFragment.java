package com.carlos.popularmovies.themoviedb.ui.fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.carlos.popularmovies.R;
import com.carlos.popularmovies.themoviedb.SharedPreferenceManager;
import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;
import com.carlos.popularmovies.themoviedb.api.model.Reviews;
import com.carlos.popularmovies.themoviedb.api.model.Trailers;
import com.carlos.popularmovies.themoviedb.presenter.DetailsPresenter;
import com.carlos.popularmovies.themoviedb.view.DetailsMvpView;
import com.carlos.popularmovies.utils.AppConstants;
import com.carlos.popularmovies.utils.Utilities;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Carlos on 23/07/2016.
 */
public class DetailFragment extends Fragment implements DetailsMvpView {

    @BindView(R.id.svMain)
    ScrollView mScrollView;
    @BindView(R.id.tvRunTime)
    TextView mTvRunTime;
    @BindView(R.id.tvReleaseDate)
    TextView mTvReleaseDate;
    @BindView(R.id.tvRate)
    TextView mTvRate;
    @BindView(R.id.tvSynopsis)
    TextView mTvSynopsis;
    @BindView(R.id.tvHeaderSynopsis)
    TextView mTvHeaderSynopsis;
    @BindView(R.id.txtTrailers)
    TextView mTvHeaderTrailers;
    @BindView(R.id.txtReviews)
    TextView mTvHeaderReviews;
    @BindView(R.id.ivPoster)
    ImageView mIvPoster;
    @BindView(R.id.collapsingPoster)
    ImageView mIvCollapsingPoster;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btnFavorite)
    ImageView mIvFavorite;

    private SharedPreferenceManager mSharedPreferenceManager;
    private DetailsPresenter mDetailsPresenter;
    private boolean mMovieInFavorites;
    private boolean mRotation;
    private boolean mUserRotate;
    private MovieDetail mMovieDetail;
    private boolean mFavoritesMode = false;
    private String mMovieId;

    private ArrayList<Trailers.YoutubeEntity> mlistTrailers = new ArrayList<Trailers.YoutubeEntity>();
    private ArrayList<Reviews.ResultsEntity> mlistReviews = new ArrayList<Reviews.ResultsEntity>();

    public DetailFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetailsPresenter = new DetailsPresenter();
        mDetailsPresenter.setView(this);
        mSharedPreferenceManager = new SharedPreferenceManager(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setUpToolbar();
        setUpFavoriteIcon();

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "Lobster-Regular.ttf");
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        mCollapsingToolbarLayout.setExpandedTitleTypeface(typeface);
        mCollapsingToolbarLayout.setCollapsedTitleTypeface(typeface);

        if (savedInstanceState == null) {
            Bundle bundle = getArguments();
            mMovieId = bundle.getString("movieId");

        } else {
            mUserRotate = true;
            mMovieDetail = savedInstanceState.getParcelable("movieDetails");
            ArrayList<Reviews.ResultsEntity> listReviewsTemp;
            listReviewsTemp = savedInstanceState.getParcelableArrayList("reviewsList");
            mlistReviews.addAll(listReviewsTemp);

            ArrayList<Trailers.YoutubeEntity> listTrailersTemp;
            listTrailersTemp = savedInstanceState.getParcelableArrayList("trailerList");
            mlistTrailers.addAll(listTrailersTemp);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mUserRotate != true) {
            mDetailsPresenter.onSearchMovieDetails(mMovieId);

        } else {
            displayDataOnScreen(mMovieDetail);
        }
        mUserRotate = false;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putParcelable("movieDetails", mMovieDetail);
        outState.putParcelableArrayList("reviewsList", mlistReviews);
        outState.putParcelableArrayList("trailerList", mlistTrailers);
        outState.putBoolean("movideInFavorites", mFavoritesMode);
        super.onSaveInstanceState(outState);
    }

    public void setUpToolbar() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();

            }
        });
    }

    public void setUpFavoriteIcon() {
        mIvFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDetailsPresenter.onFavoriteClick(v, mMovieDetail);
            }
        });
    }

    public void displayDataOnScreen(MovieDetail movieDetail) {
        mCollapsingToolbarLayout.setTitle(movieDetail.getTitle());

        mDetailsPresenter.handleDataPresentation(movieDetail);


        //trailers
        mTvHeaderTrailers.setTypeface(mDetailsPresenter.getLobsterRegularTypeface());
        Trailers trailers = movieDetail.getTrailers();
        List<Trailers.YoutubeEntity> trailersList = trailers.getYoutubeTrailers();
        LinearLayout trailersLinearLayout = (LinearLayout) getView().findViewById(R.id.llTrailers);

        for (int i = 0; i < trailersList.size(); i++) {
            final Trailers.YoutubeEntity trailer = trailersList.get(i);
            View v = LayoutInflater.from(getActivity()).inflate(R.layout.trailers, trailersLinearLayout, false);
            TextView tvTrailerTitle = (TextView) v.findViewById(R.id.trailerTitle);
            ImageView IvTrailerContainer = (ImageView) v.findViewById(R.id.trailerContainer);
            tvTrailerTitle.setText(trailer.getName());
            String trailerPath = String.format(AppConstants.YOUTUBE_IMAGE_BASE_URL, trailer.getSource());
            Picasso.with(getActivity())
                    .load(trailerPath)
                    .into(IvTrailerContainer);
            IvTrailerContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDetailsPresenter.onLaunchYoutubeTrailer(AppConstants.YOURTUBE_BASE_URL + trailer.getSource());
                  }
            });
            trailersLinearLayout.addView(v);


        }
        //reviews
        TextView tvReviews = (TextView) getView().findViewById(R.id.txtReviews);
        tvReviews.setTypeface(mDetailsPresenter.getLobsterRegularTypeface());
        Reviews reviews = movieDetail.getReviews();
        List<Reviews.ResultsEntity> reviewsList = reviews.getListReviews();

        LinearLayout reviewLinearLayout = (LinearLayout) getView().findViewById(R.id.llReviews);
        for (int i = 0; i < reviewsList.size(); i++) {
            Reviews.ResultsEntity review = reviewsList.get(i);
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.reviews, reviewLinearLayout, false);
            TextView nameAutor = (TextView) view.findViewById(R.id.autorName);
            nameAutor.setText(review.getAuthor());
            TextView content = (TextView) view.findViewById(R.id.content);
            content.setText(review.getContent());
            reviewLinearLayout.addView(view);
        }
        if(!getResources().getBoolean(R.bool.isTablet)) {
            getActivity().supportStartPostponedEnterTransition();
        }
    }

    @Override
    public void loadMovieDetails(MovieDetail movieDetail) {
        mMovieDetail = movieDetail;
        displayDataOnScreen(movieDetail);
    }

    @Override
    public void showServerError(String error) {

    }

    @Override
    public void launchYouTubeVideo(String trailerUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(trailerUrl));
        startActivity(intent);

    }


    @Override
    public void showInFavorite(View v) {
        Picasso.with(getActivity())
                .load(R.drawable.ic_favorite)
                .into(mIvFavorite);
        Snackbar.make(v, "Movie added to favorites", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showOutFavorite(View v) {
        Picasso.with(getActivity())
                .load(R.drawable.ic_favorite_outline)
                .into(mIvFavorite);
        Snackbar.make(v, "Movie removed from favorites", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showFavorite(int drawableId) {
        Picasso.with(getActivity()).
                load(drawableId).
                into(mIvFavorite);

    }

    @Override
    public void showBackdropFullQuality(String pathBackdropFullQuality) {
        Picasso.with(getActivity())
                .load(pathBackdropFullQuality)
                .centerCrop()
                .resize((int) Utilities.convertDpToPixel(135, getActivity()), (int) Utilities.convertDpToPixel(166, getActivity()))
                .into(mIvPoster);
    }

    @Override
    public void showBackdropLowQuality(String pathBackdrop) {
        Picasso.with(getActivity()).
                load(pathBackdrop)
                .into(mIvPoster);
    }

    @Override
    public void showCollapsingPosterFullQuality(String pathPosterFullQuality) {
        Picasso.with(getActivity())
                .load(pathPosterFullQuality)
                .into(mIvCollapsingPoster);

    }

    @Override
    public void showCollapsingPosterLowQuality(String pathBackdrop) {
        Picasso.with(getActivity())
                .load(pathBackdrop)
                .into(mIvCollapsingPoster);
    }

    @Override
    public void showRunTime(String runTime) {
        mTvRunTime.setText(runTime);
    }

    @Override
    public void showReleaseDate(String releaseDate) {
        mTvReleaseDate.setText(releaseDate);
    }

    @Override
    public void showRate(String rate) {
        mTvRate.setText(rate);
    }

    @Override
    public void showSynopsis(String synopsis,Typeface myTypeface) {

        mTvHeaderSynopsis.setTypeface(myTypeface);
        mTvSynopsis.setText(synopsis);
    }




}
