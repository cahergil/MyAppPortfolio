package com.carlos.myappportfolio.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Carlos on 18/08/2015.
 */
public class Message {
    private static Context context;
    private static Toast mAppToast;

    public Message(Context context){
        this.context=context;
    }
    public static void displayToast(Context context,String message){
        if(mAppToast!=null){
            mAppToast.cancel();
        }
        mAppToast=Toast.makeText(context,message,Toast.LENGTH_SHORT);
        mAppToast.show();

    }
}
