package com.istarindia.tfylanguage.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by akshay on 10/27/17.
 */


public class InternetConnectionUtil {
    private Context context;

    public InternetConnectionUtil(Context context) {
        this.context = context;
    }

    public boolean isConnectedToInternet(){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
