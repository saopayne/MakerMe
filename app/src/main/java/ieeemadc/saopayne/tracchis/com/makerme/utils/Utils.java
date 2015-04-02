package ieeemadc.saopayne.tracchis.com.makerme.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by saopayne on 3/21/15.
 */
public class Utils {

    private static Context context;

    public static void makeShortToast(String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

    public static void makeLongToast(String text){
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
