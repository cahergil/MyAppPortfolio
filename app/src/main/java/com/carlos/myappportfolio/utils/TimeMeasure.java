package com.carlos.myappportfolio.utils;

import android.util.Log;

import java.text.DecimalFormat;

/**
 * Created by Carlos on 19/08/2015.
 */
public class TimeMeasure {
    private final DecimalFormat format;
    private final double start;
    private final String tag;

    public TimeMeasure(String tag) {
        this.format = new DecimalFormat("0.0");
        this.start = System.currentTimeMillis();
        this.tag = tag;
        log("play");
    }

    public void log(String message) {
        double elapsed = ((double) (System.currentTimeMillis() - start)) / 1000.0;
        Log.d(tag, format.format(elapsed) + ": " + message);
    }
}