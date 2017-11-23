package com.shalan.mohamed.verificationview;

import java.util.Locale;

/**
 * Created by mohamed on 11/23/17.
 */

public class LocalizationUtils {

    public static String getDeviceLanguage(){
        return Locale.getDefault().getLanguage();
    }

    public static Locale getDefLocal(){
        return Locale.getDefault();
    }
}
