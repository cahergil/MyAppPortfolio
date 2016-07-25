package com.carlos.popularmovies.themoviedb.ui.fragment;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.carlos.popularmovies.R;
import com.carlos.popularmovies.themoviedb.SettingsActivity;
import com.carlos.popularmovies.themoviedb.SharedPreferenceManager;
import com.carlos.popularmovies.themoviedb.ui.activity.DetailActivity;
import com.carlos.popularmovies.themoviedb.ui.adapter.MovieAdapter;
import com.carlos.popularmovies.themoviedb.api.client.Constants;
import com.carlos.popularmovies.themoviedb.api.model.Response;
import com.carlos.popularmovies.themoviedb.presenter.MoviesPresenter;
import com.carlos.popularmovies.themoviedb.view.MoviesMvpView;
import com.carlos.popularmovies.utils.Utilities;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Carlos on 22/07/2016.
 */
public class MoviesFragment extends Fragment implements MoviesMvpView {

    @BindView(R.id.gridView)
    GridView mGridView;
    @BindView(R.id.toolBar)
    Toolbar mToolbar;

    private MoviesPresenter mMoviesPresenter;
    private MovieAdapter mMovieAdapter;
    private ArrayList<Response.Movie> mListMovies = new ArrayList<Response.Movie>();
    private ProgressDialog mProgressDialog;
    private boolean mRotation;
    private boolean mFavorite;
    private SharedPreferenceManager spm;

    public MoviesFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mMoviesPresenter = new MoviesPresenter();
        mMoviesPresenter.setView(this);
        spm=new SharedPreferenceManager(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setUpToolBar();
        setUpGridView();
        if (savedInstanceState != null) {
            mRotation = true;
            ArrayList<Response.Movie> tempList = new ArrayList<Response.Movie>();
            tempList = savedInstanceState.getParcelableArrayList("mListMovies");
            renderMovies(tempList);

        } else {
            if (!mFavorite) {
                executeCallToMoviesApi();
            } else {
                mMoviesPresenter.onLoadFavorites();
            }
        }

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("mListMovies", mListMovies);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.movies_feed_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(getActivity(), SettingsActivity.class));
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void setUpToolBar() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String orderStr = sp.getString(getString(R.string.pref_order_key), "movies");
        String title = null;
        spm.saveFavoriteMode(false);
        if (orderStr.equals(getString(R.string.pref_popularity))) {
            title = getString(R.string.mainactivity_title_popularity);
        } else if (orderStr.equals(getString(R.string.pref_rate))) {
            title = getString(R.string.mainactivity_title_rate);
        } else if (orderStr.equals(getString(R.string.pref_favorites))) {
            mFavorite = true;
            spm.saveFavoriteMode(true);
            title = getString(R.string.mainactivity_title_favorites);
        } else {
            title = "Popular Movies";
        }
        mToolbar.setTitle(Utilities.setTypeface(getActivity(), title));

        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
    }

    public void setUpGridView() {
        mMovieAdapter = new MovieAdapter(getActivity(), mListMovies);
        mGridView.setAdapter(mMovieAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String movieId = String.valueOf(mListMovies.get(position).getId());
                if (!getResources().getBoolean(R.bool.isTablet)) {
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("movieId", movieId);
                    intent.putExtras(bundle);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        ActivityOptions activityOptions = ActivityOptions.
                                makeSceneTransitionAnimation(getActivity(), view, "imgRow");
                        getActivity().startActivity(intent, activityOptions.toBundle());
                    } else {
                        startActivity(intent);
                    }
                } else {
                    DetailFragment detailFragment = new DetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("movieId", movieId);
                    detailFragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.detail_activity_container, detailFragment,"DETAIL_FRAG")
                            .commit();
                }

            }
        });
    }

    public void executeCallToMoviesApi() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String orderStr = sharedPreferences.getString(getString(R.string.pref_order_key),
                getString(R.string.pref_order_default));
        if (orderStr.equals(getString(R.string.pref_popularity))) {
            mMoviesPresenter.loadMoviesFromApi(Constants.MOVIES_BY_POPULARITY);
        }
        if (orderStr.equals(getString(R.string.pref_rate))) {
            mMoviesPresenter.loadMoviesFromApi(Constants.MOVIES_BY_RATE);
        }
    }

    @Override
    public void onDestroy() {
        mMoviesPresenter.detachView();
        super.onDestroy();

    }


    @Override
    public void showLoading() {
        mProgressDialog = ProgressDialog.show(getActivity(), "", "Loading data", true);
    }

    @Override
    public void hideLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showConnectionErrorMessage() {

    }

    @Override
    public void showServerError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void renderMovies(List<Response.Movie> list) {
        mListMovies.clear();
        mListMovies.addAll(list);

        mMovieAdapter = new MovieAdapter(getActivity(), mListMovies);
        mGridView.setAdapter(mMovieAdapter);
        if(getResources().getBoolean(R.bool.isTablet) && mRotation==false && mListMovies.size()>0) {
            DetailFragment detailsFragment = new DetailFragment();
            Bundle args = new Bundle();
            args.putString("movieId", String.valueOf(mListMovies.get(0).getId()));
          //  args.putBoolean("favoritesMode", mFavoritesMode);
            detailsFragment.setArguments(args);
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_activity_container, detailsFragment,"DETAIL_FRAG")
                    .commit();

        }
        mRotation=false;

    }

    @Override
    public void removeDetailFragment() {
        DetailFragment detailFragment;
        detailFragment= (DetailFragment) getActivity().getSupportFragmentManager().findFragmentByTag("DETAIL_FRAG");
        if(detailFragment!=null) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .remove(detailFragment)
                    .commit();
        }
    }


}
