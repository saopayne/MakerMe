package ieeemadc.saopayne.tracchis.com.makerme.utils;


import android.content.Context;
import android.content.SharedPreferences;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import ieeemadc.saopayne.tracchis.com.makerme.MakerME;

/**
 * Created by saopayne on 3/10/15.
 */
/**
 *
 */


public class AppPreferences {

    SharedPreferences prefs;
    Context context;

    public AppPreferences(Context context){
        this.context = context;
        prefs = context.getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE);
    }

    public AppPreferences(){
        prefs = MakerME.getAppContext().getSharedPreferences(Constants.PREFS, Context.MODE_PRIVATE);
        this.context = MakerME.getAppContext();
    }

    public void setDeviceID(String deviceId){
    }

    public float getFontScale(){
        return prefs.getFloat(Constants.PREFS_FONTSIZE, 1F);
    }

    public void setFontScale(float scaleFactor){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(Constants.PREFS_FONTSIZE, scaleFactor);
        editor.commit();
    }
}
