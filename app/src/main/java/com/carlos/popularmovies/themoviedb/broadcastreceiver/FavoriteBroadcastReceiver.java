package com.carlos.popularmovies.themoviedb.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;
import com.carlos.popularmovies.themoviedb.observable.ObservableFavorites;

/**
 * Created by Carlos on 25/07/2016.
 */
public class FavoriteBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ObservableFavorites observable=ObservableFavorites.getInstance();
        observable.updateValue(intent.<MovieDetail>getParcelableArrayListExtra("favoritesList"));
    }
}
