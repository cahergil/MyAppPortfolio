package com.carlos.myappportfolio.themoviedb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.carlos.myappportfolio.R;
import com.carlos.myappportfolio.themoviedb.model.Response;
import com.carlos.myappportfolio.utils.Message;
import com.carlos.myappportfolio.utils.TimeMeasure;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by Carlos on 19/08/2015.
 */
public class MoviesFeed extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    private static final int APPROX_FIXED_IMAGE_WIDTH=170;
    private GridView mGridView;
    private MovieAdapter mMovieAdapter;
    private ArrayList<Response.Movie> mListMovies=new ArrayList<Response.Movie>();
    private static final String API_KEY="fd743d7e561dafce3e95178a536b5450";
    private TimeMeasure mTm;
    private boolean mFromDetailsActivity =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mTm =new TimeMeasure("VILLANUEVA");
        mTm.log("BEGIN_ONCREATE");
        setContentView(R.layout.themoviedb_main);
        mGridView= (GridView) findViewById(R.id.gridView);
        mGridView.setOnItemClickListener(MoviesFeed.this);

        //for tablets specially
        float scalefactor = getResources().getDisplayMetrics().density * APPROX_FIXED_IMAGE_WIDTH;
        Point size=new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int number=size.x;
        int columns = (int) ((float) number / (float) scalefactor);

        mGridView.setNumColumns(columns);

        if(savedInstanceState!=null){
            mListMovies=savedInstanceState.getParcelableArrayList("mListMovies");
        }
        mTm.log("END_ONCREATE");
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putParcelableArrayList("mListMovies", mListMovies);

        super.onSaveInstanceState(outState, outPersistentState);
    }

     @Override
    protected void onResume() {
        super.onResume();
        if (mFromDetailsActivity !=true) {
            executeCallToMoviesApi();
        }
        mFromDetailsActivity =false;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
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
            Message.displayToast(this,"despues intent");

            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      //  Message.displayToast(this, "pulsado sobre " + mListMovies.get(position).getTitle() + ","
      //          + mListMovies.get(position).getId());


        Intent intent=new Intent(this,DetailActivity.class);
        intent.putExtra("movieId", mListMovies.get(position).getId());
        mFromDetailsActivity =true;
        startActivity(intent);
    }
    public void executeCallToMoviesApi(){

        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        String orderStr= sharedPreferences.getString(getString(R.string.pref_order_key),
                getString(R.string.pref_order_default));

        if (orderStr.equals(getString(R.string.pref_popularity))){
            setTitle(getString(R.string.mainactivity_title_popularity));
            getMoviesByPopularity();

        }
        if (orderStr.equals(getString(R.string.pref_rate))){
            setTitle(getString(R.string.mainactivity_title_rate));
            getMoviesByRate();
        }

    }
    public void getMoviesByPopularity(){

        ApiClient.MyApi myApi=ApiClient.getMyApiClient();
        myApi.getMoviesByPopularityDesc(API_KEY, callbackResponse());


    }
    public void getMoviesByRate(){
        ApiClient.MyApi myApi=ApiClient.getMyApiClient();
        myApi.getMoviesByAverageRate(API_KEY, callbackResponse());


    }
    private Callback<Response> callbackResponse(){

        return new Callback<Response>() {
            @Override
            public void success(Response response, retrofit.client.Response response2) {
            //    Message.displayToast(MoviesFeed.this, "success");
                mTm.log("BEGIN_CALLBACK");
                mListMovies =(ArrayList) response.getResults();
                mMovieAdapter = new MovieAdapter(MoviesFeed.this, mListMovies);
                mGridView.setAdapter(mMovieAdapter);
                mTm.log("END_CALLBACK");




            }

            @Override
            public void failure(RetrofitError error) {
                Log.v("VILLANUEVA","error:"+error.getMessage().toString());
                Message.displayToast(MoviesFeed.this, "failure" + error.getMessage().toString());
            }
        };


    }




}
