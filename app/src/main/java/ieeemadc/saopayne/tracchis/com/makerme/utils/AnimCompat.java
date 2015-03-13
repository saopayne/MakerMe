package ieeemadc.saopayne.tracchis.com.makerme.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by saopayne on 3/10/15.
 */

public class AnimCompat extends Animation {


    private View mView;
    private float mTranslationY;

    public static AnimCompat instantiate(View view){
        Animation instance = view.getAnimation();

        if(instance instanceof AnimCompat){
            return (AnimCompat)instance;
        }
        else{
            return new AnimCompat(view);
        }
    }


    private AnimCompat(View view){
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        mView = view;
    }

    public void setTranslationY(float translationY){
        mTranslationY = translationY;
    }


    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        // TODO Auto-generated method stub
        if(mView != null){
            t.getMatrix().postTranslate(0, mTranslationY);
        }
    }
}

