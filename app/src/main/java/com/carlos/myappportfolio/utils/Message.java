package com.carlos.myappportfolio.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Carlos on 18/08/2015.
 */
public class Message {
    private static Context context;
    public Message(Context context){

        this.context=context;
    }
    public static void message(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();

    }
}
