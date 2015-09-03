package com.carlos.myappportfolio.themoviedb;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.carlos.myappportfolio.R;
import com.carlos.myappportfolio.themoviedb.adapters.ReviewAdapter;
import com.carlos.myappportfolio.themoviedb.adapters.TrailerAdapter;
import com.carlos.myappportfolio.themoviedb.models.MovieDetail;
import com.carlos.myappportfolio.themoviedb.models.Reviews;
import com.carlos.myappportfolio.themoviedb.models.Trailers;
import com.carlos.myappportfolio.utils.AppConstants;
import com.carlos.myappportfolio.utils.TimeMeasure;
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
    private TimeMeasure mTm;
    private MovieDetail mMovieDetail;
    private TextView mTvTitle,mTvRunTime,mTvReleaseDate,mTvRate,mTvSynopsis;
    private ImageView mIvPoster;
    private boolean mUserRotate=false;
    private ArrayList<Trailers.YoutubeEntity> mlistTrailers = new ArrayList<Trailers.YoutubeEntity>();
    private ArrayList<Reviews.ResultsEntity> mlistReviews   = new ArrayList<Reviews.ResultsEntity>();
    SharedPreferenceManager mSharedPreferenceManager;
    private ListView mListViewTrailers;
    private ListView mListViewReviews;
    private Button mBtnFavorite;
    private boolean mFavoritesMode=false;

    public DetailActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TimeMeasure mTm=new TimeMeasure("VILLANUEVA");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_detail, container, false);
        Bundle bundle=this.getArguments();
        mSharedPreferenceManager=new SharedPreferenceManager(getActivity());
        mMovieId=(String)bundle.get("movieId");
        mFavoritesMode=bundle.getBoolean("favoritesMode");
        mTvTitle= (TextView) view.findViewById(R.id.tvTitle);
        mTvRunTime= (TextView) view.findViewById(R.id.tvRunTime);
        mTvReleaseDate= (TextView) view.findViewById(R.id.tvReleaseDate);
        mTvRate= (TextView) view.findViewById(R.id.tvRate);
        mTvSynopsis= (TextView) view.findViewById(R.id.tvSynopsis);
        mIvPoster= (ImageView) view.findViewById(R.id.ivPoster);
        mBtnFavorite= (Button) view.findViewById(R.id.btnFavorite);
        mBtnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btnTemp=(Button)v;

                List<MovieDetail> tempList;
                if (btnTemp.getText().equals("ADD TO FAVORITES")) {
                    tempList = mSharedPreferenceManager.getFavoritesList();
                    if (tempList == null) {
                        tempList = new ArrayList<MovieDetail>();
                    }
                    tempList.add(mMovieDetail);
                    mSharedPreferenceManager.saveFavoritesList(tempList);
                    addRemoveTextAndIconButtonFavorite();
                    // tempList=mSharedPreferenceManager.getFavoritesList();
                } else {
                    tempList= mSharedPreferenceManager.getFavoritesList();
                    tempList.remove(mMovieDetail);
                    mSharedPreferenceManager.saveFavoritesList(tempList);
                    Toast.makeText(getActivity(),"Remove",Toast.LENGTH_SHORT).show();
                    addAddTextAndIconButtonFavorite();
                }
            }
        });
        //mBtnFavorite.setCompoundDrawablesWithIntrinsicBounds();
        //Trailers
        mListViewTrailers=(ListView) view.findViewById(R.id.listViewTrailers);
        TrailerAdapter trailerAdapter =new TrailerAdapter(getActivity(),mlistTrailers);
        mListViewTrailers.setAdapter(trailerAdapter);
        mListViewTrailers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                String buildUrl;
                buildUrl=AppConstants.YOURTUBE_BASE_URL+mlistTrailers.get(position).getSource();
                intent =new Intent(Intent.ACTION_VIEW, Uri.parse(buildUrl));
                startActivity(intent);
            }
        });

        //Reviews
        mListViewReviews=(ListView) view.findViewById(R.id.listViewReviews);
        ReviewAdapter reviewAdapter =new ReviewAdapter(getActivity(),mlistReviews);
        mListViewReviews.setAdapter(reviewAdapter);
        mListViewReviews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),ReviewsDetail.class);
                intent.putExtra(Intent.EXTRA_TEXT,mlistReviews.get(position).getContent());
                startActivity(intent);
            }
        });



        if(savedInstanceState!=null){
            mUserRotate=true;
            mMovieDetail=savedInstanceState.getParcelable("movieDetails");
            ArrayList<Reviews.ResultsEntity> listReviewsTemp;
            listReviewsTemp=savedInstanceState.getParcelableArrayList("reviewsList");
            mlistReviews.addAll(listReviewsTemp);
            setListViewHeightBasedOnChildren(mListViewReviews);
            ArrayList<Trailers.YoutubeEntity> listTrailersTemp;
            listTrailersTemp=savedInstanceState.getParcelableArrayList("trailerList");
            mlistTrailers.addAll(listTrailersTemp);
            setListViewHeightBasedOnChildren(mListViewTrailers);

            displayDataOnScreen();
        }


        return view;
    }


    @Override
   public void onResume() {
        super.onResume();
        if(mUserRotate!=true) {
             getMoviesDetail();
        }
        mUserRotate=false;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putParcelable("movieDetails", mMovieDetail);
        outState.putParcelableArrayList("reviewsList", mlistReviews);
        outState.putParcelableArrayList("trailerList", mlistTrailers);
        super.onSaveInstanceState(outState);
    }

    public void  getMoviesDetail(){

        if(mFavoritesMode!=true) {
            ApiClient.MyApi myApi = ApiClient.getMyApiClient();
            myApi.getMovieDetails(mMovieId, AppConstants.API_KEY, callbackResponse());
        } else {

            mMovieDetail= mSharedPreferenceManager.getMovieFromFavoritesList(Integer.parseInt(mMovieId));
            Trailers trailers=mMovieDetail.getTrailers();
            mlistTrailers.clear();
            mlistTrailers.addAll(trailers.getYoutubeTrailers());
            setListViewHeightBasedOnChildren(mListViewTrailers);

            Reviews reviews=mMovieDetail.getReviews();
            mlistReviews.clear();
            mlistReviews.addAll(reviews.getListReviews());
            setListViewHeightBasedOnChildren(mListViewReviews);

            displayDataOnScreen();
        }
    }
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
             return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    private Callback<MovieDetail> callbackResponse(){

        return new Callback<MovieDetail>() {

            @Override
            public void success(MovieDetail movieDetail, retrofit.client.Response response) {
                mMovieDetail=movieDetail;
                Trailers trailers=mMovieDetail.getTrailers();
                Reviews reviews=mMovieDetail.getReviews();

                mlistTrailers.clear();
                mlistTrailers.addAll(trailers.getYoutubeTrailers());
                setListViewHeightBasedOnChildren(mListViewTrailers);

                mlistReviews.clear();
                mlistReviews.addAll(reviews.getListReviews());

                setListViewHeightBasedOnChildren(mListViewReviews);

                displayDataOnScreen();

            }

            @Override
            public void failure(RetrofitError error) {
                Log.v("VILLANUEVA","errro:"+error.getMessage().toString());

            }
        };


    }

    private void displayDataOnScreen() {
        mTvTitle.setText(mMovieDetail.getTitle());
        getActivity().setTitle("Details "+ mMovieDetail.getTitle());
        String url=AppConstants.POSTER_BASE_URL+mMovieDetail.getPoster_path();
        Picasso.with(getActivity()).load(url).into(mIvPoster);
        mTvRunTime.setText(String.valueOf(mMovieDetail.getRuntime())+"m");
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate=null;
        try {
            Date date=parser.parse(mMovieDetail.getRelease_date());
            SimpleDateFormat formatter=new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
             formattedDate=formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mTvReleaseDate.setText(formattedDate);
        mTvRate.setText(mMovieDetail.getVote_average() + "/10" + "(" + mMovieDetail.getVote_count() + " votes)");
        mTvSynopsis.setText(mMovieDetail.getOverview());
        if(mSharedPreferenceManager.isMovieInFavorites(mMovieDetail)){
            addRemoveTextAndIconButtonFavorite();
        } else {
            addAddTextAndIconButtonFavorite();
        }
    }

   public void addAddTextAndIconButtonFavorite() {
       mBtnFavorite.setText("ADD TO FAVORITES");
       mBtnFavorite.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_favorite_outline,0);
   }
    public void addRemoveTextAndIconButtonFavorite(){
        mBtnFavorite.setText("REMOVE FROM FAVORITES");
        mBtnFavorite.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_favorite, 0);
    }


}
