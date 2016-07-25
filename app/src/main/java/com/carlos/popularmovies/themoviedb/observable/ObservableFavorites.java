package com.carlos.popularmovies.themoviedb.observable;

import com.carlos.popularmovies.themoviedb.SharedPreferenceManager;
import com.carlos.popularmovies.themoviedb.api.client.MyApplication;
import com.carlos.popularmovies.themoviedb.api.model.MovieDetail;

import java.util.List;
import java.util.Observable;

/**
 * Created by Carlos on 25/07/2016.
 */
public class ObservableFavorites extends Observable {

    private static List<MovieDetail> favoriteList;
    static {
        SharedPreferenceManager spm=new SharedPreferenceManager(MyApplication.getContext());
        favoriteList=spm.getFavoritesList();
    }
    private static final ObservableFavorites instance=new ObservableFavorites();

    public static ObservableFavorites getInstance(){
        return instance;
    }
    public void updateValue(List<MovieDetail> newList){
        favoriteList=newList;
        synchronized (this) {
            setChanged();
            notifyObservers(favoriteList);
        }
    }

    public List<MovieDetail> getValue(){
        return favoriteList;
    }

}
