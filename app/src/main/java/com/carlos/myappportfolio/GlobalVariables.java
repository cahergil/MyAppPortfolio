package com.carlos.myappportfolio;

/**
 * Created by Carlos on 08/09/2015.
 */
public class GlobalVariables {
    private static GlobalVariables instance;
    private static Boolean mFromReviewDetails;
    //other private static variables.

    //setters
    public void setTestVar(Boolean vAR)
    {
        GlobalVariables.mFromReviewDetails = vAR;
    }
    //other similar setters from private static variables above.

    //getters
    public Boolean getTestVar() {
        return GlobalVariables.mFromReviewDetails;
    }
    //other similar getters from private static variables above.

    public static synchronized GlobalVariables getInstatnce() {
        if(instance==null) {
            instance=new GlobalVariables();
        }
        return instance;
    }
}