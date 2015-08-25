package com.carlos.myappportfolio.themoviedb;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.carlos.myappportfolio.R;
import com.carlos.myappportfolio.themoviedb.model.MovieDetail;
import com.carlos.myappportfolio.utils.Message;
import com.carlos.myappportfolio.utils.TimeMeasure;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
    private static final String POSTER_BASE_URL="http://image.tmdb.org/t/p/w185/";
    private static final String API_KEY="fd743d7e561dafce3e95178a536b5450";
    private String mMovieId;
    private TimeMeasure mTm;
    private MovieDetail mMovieDetail;
    TextView mTvTitle,mTvRunTime,mTvReleaseDate,mTvRate,mTvSynopsis;
    ImageView mIvPoster;
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
        mMovieId=(String)bundle.get("movieId");

        if(savedInstanceState!=null){
            mMovieDetail=savedInstanceState.getParcelable("movieDetails");

        }
        mTvTitle= (TextView) view.findViewById(R.id.tvTitle);
        mTvRunTime= (TextView) view.findViewById(R.id.tvRunTime);
        mTvReleaseDate= (TextView) view.findViewById(R.id.tvReleaseDate);
        mTvRate= (TextView) view.findViewById(R.id.tvRate);
        mTvSynopsis= (TextView) view.findViewById(R.id.tvSynopsis);
        mIvPoster= (ImageView) view.findViewById(R.id.ivPoster);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getMoviesDetail();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putParcelable("movieDetails",mMovieDetail);
        super.onSaveInstanceState(outState);
    }

    public void getMoviesDetail(){

        ApiClient.MyApi myApi=ApiClient.getMyApiClient();
        myApi.getMovieDetails(mMovieId, API_KEY, callbackResponse());
    }
    private Callback<MovieDetail> callbackResponse(){

        return new Callback<MovieDetail>() {

            @Override
            public void success(MovieDetail movieDetail, retrofit.client.Response response) {
                mMovieDetail=movieDetail;
                displayDataOnScreen();
                Message.displayToast(getActivity(), "success");
            }

            @Override
            public void failure(RetrofitError error) {
                Log.v("VILLANUEVA","errro:"+error.getMessage().toString());
                Message.displayToast(getActivity(), "failure" + error.getMessage().toString());
            }
        };


    }

    private void displayDataOnScreen() {
        mTvTitle.setText(mMovieDetail.getTitle());
        getActivity().setTitle("Details "+ mMovieDetail.getTitle());
        String url=POSTER_BASE_URL+mMovieDetail.getPoster_path();
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
        mTvRate.setText(mMovieDetail.getVote_average()+"/10"+"("+mMovieDetail.getVote_count()+" votes)");
        mTvSynopsis.setText(mMovieDetail.getOverview());
    }

}
