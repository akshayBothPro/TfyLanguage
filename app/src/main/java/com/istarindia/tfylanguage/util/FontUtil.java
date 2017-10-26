package com.istarindia.tfylanguage.util;

/**
 * Created by istarferoz on 27/10/17.
 */


import android.content.Context;
import android.graphics.Typeface;

import java.util.Hashtable;

/**
 * Created by Feroz on 19-04-2017.
 */

public class FontUtil {
    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();
    private static Context context;

    public FontUtil(Context context) {
        this.context = context;
    }

    public static Typeface getTypeface(String name) {

        if(name.equalsIgnoreCase("LatoRegular")){
            name="fonts/Lato-Regular.ttf";
        }else{
            name="fonts/Lato-Bold.ttf";
        }
        Typeface tf = fontCache.get(name);
        if (tf == null) {
            try {
                if (name.equalsIgnoreCase(""))
                    tf = Typeface.createFromAsset(context.getAssets(),name);
                else
                    tf = Typeface.createFromAsset(context.getAssets(),name);


            } catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }
}