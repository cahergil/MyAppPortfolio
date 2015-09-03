package com.carlos.myappportfolio.themoviedb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.carlos.myappportfolio.R;
import com.carlos.myappportfolio.themoviedb.adapters.MovieAdapter;
import com.carlos.myappportfolio.themoviedb.models.MovieDetail;
import com.carlos.myappportfolio.themoviedb.models.Response;
import com.carlos.myappportfolio.utils.AppConstants;
import com.carlos.myappportfolio.utils.Message;
import com.carlos.myappportfolio.utils.TimeMeasure;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by Carlos on 03/09/2015.
 */
public class MoviesFeedFragment extends Fragment implements AdapterView.OnItemClickListener {
    private static final int APPROX_FIXED_IMAGE_WIDTH=170;
    private GridView mGridView;
    private MovieAdapter mMovieAdapter;
    private ArrayList<Response.Movie> mListMovies=new ArrayList<Response.Movie>();
    private TimeMeasure mTm;
    private boolean mFromDetailsActivity =false;
    private boolean mUserRotation=false;
    private boolean mFavoritesMode=false;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_moviesfeed, container, false);


        mTm =new TimeMeasure("VILLANUEVA");
        mTm.log("BEGIN_ONCREATE");

        mGridView= (GridView) view.findViewById(R.id.gridView);
        mGridView.setOnItemClickListener(this);
        mMovieAdapter = new MovieAdapter(getActivity(), mListMovies);
        mGridView.setAdapter(mMovieAdapter);
        //for tablets specially
//        float scalefactor = getResources().getDisplayMetrics().density * APPROX_FIXED_IMAGE_WIDTH;
//        Point size=new Point();
//        getWindowManager().getDefaultDisplay().getSize(size);
//        int number=size.x;
//        int columns = (int) ((float) number / (float) scalefactor);
//
//        mGridView.setNumColumns(columns);

        if(savedInstanceState!=null){
            mUserRotation=true;
            ArrayList<Response.Movie> tempList=new ArrayList<Response.Movie>();
            tempList=savedInstanceState.getParcelableArrayList("mListMovies");
            mListMovies.clear();
            mListMovies.addAll(tempList);

        }
        mTm.log("END_ONCREATE");

        return view;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("mListMovies", mListMovies);
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mFromDetailsActivity !=true && mUserRotation!=true) {
            executeCallToMoviesApi();
        } else if(mFromDetailsActivity==true && mFavoritesMode==true) {
            getFavoritesMovies();
        }
        mFromDetailsActivity =false;
        mUserRotation=false;

    }

      @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent=new Intent(getActivity(),DetailActivity.class);
        intent.putExtra("favoritesMode",mFavoritesMode);
        intent.putExtra("movieId", mListMovies.get(position).getId());
        mFromDetailsActivity =true;
        startActivity(intent);
    }

    public void executeCallToMoviesApi(){

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getActivity());
        String orderStr= sharedPreferences.getString(getString(R.string.pref_order_key),
                getString(R.string.pref_order_default));
        mFavoritesMode=false;
        if (orderStr.equals(getString(R.string.pref_popularity))){
            getActivity().setTitle(getString(R.string.mainactivity_title_popularity));
            getMoviesByPopularity();

        }
        if (orderStr.equals(getString(R.string.pref_rate))){
            getActivity().setTitle(getString(R.string.mainactivity_title_rate));
            getMoviesByRate();
        }
        if (orderStr.equals(getString(R.string.pref_favorites))) {
            getActivity().setTitle(getString(R.string.mainactivity_title_favorites));
            mFavoritesMode=true;
            getFavoritesMovies();
        }
    }

    public void getMoviesByPopularity(){

        ApiClient.MyApi myApi=ApiClient.getMyApiClient();
        myApi.getMoviesByPopularityDesc(AppConstants.API_KEY, callbackResponse());


    }
    public void getMoviesByRate(){
        ApiClient.MyApi myApi=ApiClient.getMyApiClient();
        myApi.getMoviesByAverageRate(AppConstants.API_KEY, callbackResponse());


    }

    private Callback<Response> callbackResponse() {

        return new Callback<Response>() {
            @Override
            public void success(Response response, retrofit.client.Response response2) {
                //    Message.displayToast(MoviesFeed.this, "success");
                mTm.log("BEGIN_CALLBACK");
                mListMovies.clear();
                mListMovies.addAll((ArrayList) response.getResults());
                mMovieAdapter = new MovieAdapter(getActivity(), mListMovies);
                mGridView.setAdapter(mMovieAdapter);
                mTm.log("END_CALLBACK");


            }

            @Override
            public void failure(RetrofitError error) {
                Log.v("VILLANUEVA", "error:" + error.getMessage().toString());
                Message.displayToast(getActivity(), "failure" + error.getMessage().toString());
            }
        };

    }

    public void getFavoritesMovies(){
        List<MovieDetail> tempListDetail;
        ArrayList<Response.Movie> tempList=new ArrayList<Response.Movie>();
        SharedPreferenceManager sharedPreferenceManager=new SharedPreferenceManager(getActivity());
        tempListDetail = sharedPreferenceManager.getFavoritesList();
        Response.Movie tempMovie;
        for (MovieDetail movieDetail : tempListDetail) {
            tempMovie = new Response.Movie();
            tempMovie.setId(movieDetail.getId());
            tempMovie.setPoster_path(movieDetail.getPoster_path());
            tempList.add(tempMovie);
        }
        mListMovies.clear();
        mListMovies.addAll(tempList);
        mMovieAdapter = new MovieAdapter(getActivity(), mListMovies);
        mGridView.setAdapter(mMovieAdapter);


    }



}
