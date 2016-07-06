package com.carlos.popularmovies.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.DisplayMetrics;

/**
 * Created by Carlos on 29/06/2016.
 */
public class Utilities {

    public static SpannableString setTypeface(Context context, String title) {
        SpannableString s = new SpannableString(title);
        s.setSpan(new TypeFaceSpan(context,"Lobster-Regular.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return s;
    }

    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }
}
