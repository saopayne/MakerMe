/**
 * 
 */
package ieeemadc.saopayne.tracchis.com.makerme.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;


import ieeemadc.saopayne.tracchis.com.makerme.R;
import ieeemadc.saopayne.tracchis.com.makerme.utils.AnimCompat;

/**
 * @author saopayne
 *
 */
public class ParallaxScrollView extends ScrollView {
	
	private static final float DEFAULT_SCROLL_FACTOR = 0.5f;
	private static float mScrollFactor = DEFAULT_SCROLL_FACTOR;
	
	private Callbacks mCallbacks;
	private static boolean IS_PRE_HONEYCOMB = Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB;
	
	private int mBackgroundResId;
	private View mBackgroundView;

	public ParallaxScrollView(Context context){
		super(context);
		
	}
	
	public ParallaxScrollView(Context context, AttributeSet attrs){
		super(context, attrs);
		init(context, attrs, 0);
	}
	
	public ParallaxScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context, attrs, defStyle);
	}
	
	private void init(Context context, AttributeSet attrs, int defStyle){
		if(isInEditMode())
			return;
		
		if(attrs != null){
			TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.ParallaxScrollView, defStyle, 0);
			
			mBackgroundResId = values.getResourceId(R.styleable.ParallaxScrollView_background_view, 0);
			mScrollFactor = values.getFloat(R.styleable.ParallaxScrollView_scroll_factor, DEFAULT_SCROLL_FACTOR);
			
			values.recycle();
		}
		
		setVerticalFadingEdgeEnabled(false);
	}

	public void setBackgroundView(int resId){
		mBackgroundView = findViewById(resId);
	}
	
	public void setBackgroundView(View view){
		mBackgroundView = view;
	}
	
	public void setScrollFactor(float scrollFactor){
		mScrollFactor = scrollFactor;
	}
	
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		super.onLayout(changed, l, t, r, b);
		if(changed){
			translateBackgroundView(getScrollY());
		}
	}
	
	
	@Override
	protected void onAttachedToWindow() {
		// TODO Auto-generated method stub
		if(mBackgroundResId > 0 && mBackgroundView == null){
			mBackgroundView = findViewById(mBackgroundResId);
			mBackgroundResId = 0;
		}
		super.onAttachedToWindow();
	}
	
	@Override
	protected void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		if(IS_PRE_HONEYCOMB){
			mBackgroundView.clearAnimation();
		}
		mBackgroundView = null;
		
		super.onDetachedFromWindow();
	}
	
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		// TODO Auto-generated method stub
		super.onScrollChanged(l, t, oldl, oldt);
		if (mCallbacks != null) {
            mCallbacks.onScrollChanged(t);
        }
		translateBackgroundView(t);
	}
	
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void translateBackgroundView(int y){
		if(mBackgroundView != null){
			int translationY = (int) (mScrollFactor * y);
			if(IS_PRE_HONEYCOMB){
				AnimCompat.instantiate(mBackgroundView).setTranslationY(translationY);
			}
			else{
				mBackgroundView.setTranslationY(translationY);
			}
		}
	}
	
	public void setCallbacks(Callbacks listener) {
        mCallbacks = listener;
    }
	

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mCallbacks != null) {
            switch (ev.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    mCallbacks.onDownMotionEvent();
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    mCallbacks.onUpOrCancelMotionEvent();
                    break;
            }
        }
        return super.onTouchEvent(ev);
    }

    @Override
    public int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    public static interface Callbacks {
        public void onScrollChanged(int scrollY);
        public void onDownMotionEvent();
        public void onUpOrCancelMotionEvent();
    }
}
