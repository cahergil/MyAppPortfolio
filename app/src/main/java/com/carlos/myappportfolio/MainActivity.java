package com.carlos.myappportfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.carlos.myappportfolio.utils.Message;

public class MainActivity extends AppCompatActivity {
    private Button btnSpotify,btnScores,btnLibrary,btnBigger,btnReader,btnCapstone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSpotify= (Button) findViewById(R.id.btnSpotify);
        btnScores= (Button) findViewById(R.id.btnScores);
        btnLibrary= (Button) findViewById(R.id.btnLibrary);
        btnBigger= (Button) findViewById(R.id.btnBigger);
        btnReader= (Button) findViewById(R.id.btnReader);
        btnCapstone= (Button) findViewById(R.id.btnCapstone);

    }
    public void showToast(View v){

        switch (v.getId()){
            case R.id.btnSpotify:
            case R.id.btnScores:
            case R.id.btnLibrary:
            case R.id.btnBigger:
            case R.id.btnReader:
            case R.id.btnCapstone:
               Message.displayToast(this,"This button will launch "+((Button)v).getText().toString());
        }

    }

}
