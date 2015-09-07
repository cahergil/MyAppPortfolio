package com.carlos.myappportfolio.themoviedb.provider.gridview;

import com.carlos.myappportfolio.themoviedb.provider.base.BaseModel;

import java.util.Date;

/**
 * the Gridview Entity
 */
public interface GridviewModel extends BaseModel {

    /**
     * id de la pelicula
     */
    int getMovieId();

    /**
     * titulo de la pelicula
     * Cannot be {@code null}.
     */
    String getTitle();

    /**
     * poster de la pelicula
     * Cannot be {@code null}.
     */
    String getPosterPath();
}
