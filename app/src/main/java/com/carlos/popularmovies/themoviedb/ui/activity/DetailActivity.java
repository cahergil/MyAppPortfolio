package com.carlos.popularmovies.themoviedb.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.carlos.popularmovies.R;
import com.carlos.popularmovies.themoviedb.ui.fragment.DetailFragment;

/**
 * Created by Carlos on 23/07/2016.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if(savedInstanceState==null) {
            Intent intent=getIntent();
            Bundle bundle=intent.getExtras();
            DetailFragment detailFragment=new DetailFragment();
            detailFragment.setArguments(bundle);
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
                postponeEnterTransition();
            }
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detail_activity_container,detailFragment)
                    .commit();
        }
    }
}
