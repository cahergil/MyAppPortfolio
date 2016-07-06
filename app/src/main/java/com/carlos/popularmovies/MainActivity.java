package com.carlos.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;


import com.carlos.popularmovies.themoviedb.MoviesFeed;
import com.carlos.popularmovies.utils.Message;

public class MainActivity extends AppCompatActivity {
    private Button btnSpotify,btnScores,btnLibrary,btnBigger,btnReader,btnCapstone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void showToast(View v){

        switch (v.getId()){
            case R.id.btnSpotify:
            case R.id.btnScores:
                Intent intent=new Intent(this, MoviesFeed.class);
                startActivity(intent);
                break;
            case R.id.btnLibrary:
            case R.id.btnBigger:
            case R.id.btnReader:
            case R.id.btnCapstone:
               Message.displayToast(this,"This button will launch "+((Button)v).getText().toString());
        }

    }

}
