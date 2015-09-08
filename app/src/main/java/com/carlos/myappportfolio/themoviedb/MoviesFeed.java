package com.carlos.myappportfolio.themoviedb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
 * Created by Carlos on 19/08/2015.
 */
public class MoviesFeed extends AppCompatActivity {
    private static boolean mTwoPane;

    private static final String CUSTOM_FRAG ="CUSTOM_FRAG";

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            MoviesFeedFragment fragment=(MoviesFeedFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_gridview);
            if ( fragment.isOnFavoriteMode())
                    fragment.getFavoritesMovies();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themoviedb_main);
        if(findViewById(R.id.detail_activity_container)!=null) {
        //Register to receive message from DetailActivity
            LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                    new IntentFilter("remove-item-favorites"));
            //the detail_activity_container will be present only in large-screen
            //Layouts (res/Layout-sw600dp. If this view is present, then the activity
            //should be in two-pane mode
            mTwoPane=true;
            //In two-pane mode, show the detail view in this activity by adding
            // or replacing the detail fragment using a fragment transaction

        } else {
            mTwoPane=false;
        }
    }

     @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        super.onDestroy();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.movies_feed_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this,SettingsActivity.class));
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    public static class MoviesFeedFragment extends Fragment implements AdapterView.OnItemClickListener {

        private static final int APPROX_FIXED_IMAGE_WIDTH=170;
        private  GridView mGridView;
        private  MovieAdapter mMovieAdapter;
        private  ArrayList<Response.Movie> mListMovies=new ArrayList<Response.Movie>();
        private  TimeMeasure mTm;
        private  boolean mFromDetailsActivity =false;
        private  boolean mUserRotation=false;
        private  boolean mFavoritesMode=false;

        public MoviesFeedFragment(){
        }

        public boolean isOnFavoriteMode(){
            return (mFavoritesMode==true);
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View view= inflater.inflate(R.layout.fragment_moviesfeed, container, false);

            mGridView= (GridView) view.findViewById(R.id.gridView);
            mGridView.setOnItemClickListener(this);
            mMovieAdapter = new MovieAdapter(getActivity(), mListMovies);
            mGridView.setAdapter(mMovieAdapter);
            if(savedInstanceState!=null){
                mUserRotation=true;
                ArrayList<Response.Movie> tempList=new ArrayList<Response.Movie>();
                tempList=savedInstanceState.getParcelableArrayList("mListMovies");
                mListMovies.clear();
                mListMovies.addAll(tempList);
                mMovieAdapter = new MovieAdapter(getActivity(), mListMovies);
                mGridView.setAdapter(mMovieAdapter);
            }
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
                if (mTwoPane==true){
                DetailActivityFragment detailActivityFragment=(DetailActivityFragment)getActivity()
                         .getSupportFragmentManager().findFragmentByTag(CUSTOM_FRAG);
                 if (detailActivityFragment!=null) {
                     getActivity().getSupportFragmentManager().beginTransaction()
                             .remove(detailActivityFragment)
                             .commit();
                 }
                }
                executeCallToMoviesApi();

            } else if(mFromDetailsActivity==true && mFavoritesMode==true) {

                getFavoritesMovies();
            }
            mFromDetailsActivity =false;
            mUserRotation=false;

        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (mTwoPane==true) {
                DetailActivityFragment detailActivityFragment=new DetailActivityFragment();
                Bundle args=new Bundle();
                args.putString("movieId", String.valueOf(mListMovies.get(position).getId()));
                args.putBoolean("favoritesMode",mFavoritesMode);
                args.putBoolean("twoPaneMode",mTwoPane);
                args.putString("customFrag", CUSTOM_FRAG);
                detailActivityFragment.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.detail_activity_container,detailActivityFragment, CUSTOM_FRAG)
                        .commit();


            } else {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("favoritesMode", mFavoritesMode);
                intent.putExtra("movieId", mListMovies.get(position).getId());
                mFromDetailsActivity = true;
                startActivity(intent);
            }
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

                    mListMovies.clear();
                    mListMovies.addAll((ArrayList) response.getResults());
                    mMovieAdapter = new MovieAdapter(getActivity(), mListMovies);
                    mGridView.setAdapter(mMovieAdapter);
                  //  GridviewSelection selection=new GridviewSelection();
                 //   selection.delete(getActivity().getContentResolver());



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
            if (tempListDetail!=null) {
                for (MovieDetail movieDetail : tempListDetail) {
                    tempMovie = new Response.Movie();
                    tempMovie.setId(movieDetail.getId());
                    tempMovie.setPoster_path(movieDetail.getPoster_path());
                    tempList.add(tempMovie);
                }
                mListMovies.clear();
                mListMovies.addAll(tempList);
            }
            mMovieAdapter = new MovieAdapter(getActivity(), mListMovies);
            mGridView.setAdapter(mMovieAdapter);


        }




    }//MoviesFeedFragment






}
