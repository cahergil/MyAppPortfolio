package com.carlos.myappportfolio.themoviedb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.carlos.myappportfolio.R;

public class ReviewsDetail extends AppCompatActivity {
    private TextView tvComment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews_detail);
        tvComment= (TextView) findViewById(R.id.tvComment);
        Intent intent=getIntent();
        String comment=intent.getStringExtra(Intent.EXTRA_TEXT);
        tvComment.setText(comment);


    }



}
