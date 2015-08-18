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
        btnSpotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message.message(MainActivity.this,"This button will launch Spotify Streamer app");
            }
        });
        btnScores= (Button) findViewById(R.id.btnScores);
        btnScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message.message(MainActivity.this,"This button will launch Scores app");
            }
        });
        btnLibrary= (Button) findViewById(R.id.btnLibrary);
        btnLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message.message(MainActivity.this,"This button will launch Library app");
            }
        });
        btnBigger= (Button) findViewById(R.id.btnBigger);
        btnBigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message.message(MainActivity.this,"This button will launch Buid it Bigger app");
            }
        });
        btnReader= (Button) findViewById(R.id.btnReader);
        btnReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message.message(MainActivity.this,"This button will launch XYZ Reader app");
            }
        });
        btnCapstone= (Button) findViewById(R.id.btnCapstone);
        btnCapstone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message.message(MainActivity.this,"This button will launch My Own app");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
