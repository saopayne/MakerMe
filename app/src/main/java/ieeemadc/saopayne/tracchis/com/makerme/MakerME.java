package ieeemadc.saopayne.tracchis.com.makerme;

import android.app.Application;
import android.content.Context;

/**
 * Created by saopayne on 3/27/15.
 */
public class MakerME extends Application{


    private static MakerME instance;
    private static Context context;


    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();

        instance = this;
        this.setAppContext(getApplicationContext());
    }

    public MakerME(){
        super();
    }


    public static MakerME getInstance(){
        return instance;
    }

    public void setAppContext(Context context){
        this.context = context;
    }

    public static Context getAppContext(){
        return context;
    }
}
