/**
 * 
 */
package ieeemadc.saopayne.tracchis.com.makerme.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import ieeemadc.saopayne.tracchis.com.makerme.R;

/**
 * @author saopayne
 *
 */
public class CustomEditText extends EditText {

	public CustomEditText(Context context){
		super(context);
		if(!isInEditMode())
			setup(null);
	}
	
	public CustomEditText(Context context, AttributeSet attrs){
		super(context, attrs);
		if(!isInEditMode())
			setup(attrs);
	}
	
	public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		if(!isInEditMode())
			setup(attrs);
	}

	public void setup(AttributeSet attrs){
		if(attrs != null){
			TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.CustomTextView);
			String fontName = array.getString(R.styleable.CustomTextView_textFont);
			if(fontName != null){
				Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName + ".ttf");
				setTypeface(tf);
			}
			array.recycle();
		}
	}
}
