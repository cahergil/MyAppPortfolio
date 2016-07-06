package com.carlos.popularmovies.themoviedb;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;

import com.carlos.popularmovies.R;


public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {



            Intent intent=getIntent();

            Bundle bundle=intent.getExtras();
            Integer integer=(Integer)bundle.get("movieId");
            bundle.putString("movieId",String.valueOf(integer));
            DetailActivityFragment detailActivityFragment=new DetailActivityFragment();
            detailActivityFragment.setArguments(bundle);
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
                postponeEnterTransition();
            }
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detail_activity_container,detailActivityFragment)
                  //  .add(R.id.container, new DetailFragment())
                    .commit();
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
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
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void addEnterTransitionV21(Fragment fragment) {
        Slide slideTransition = new Slide(Gravity.LEFT);
        slideTransition.addTarget(R.id.content_transition);
        slideTransition.setInterpolator(AnimationUtils.loadInterpolator(this,
                android.R.interpolator.linear_out_slow_in));
        slideTransition.setDuration(5000);
        fragment.setEnterTransition(slideTransition);

    }


}