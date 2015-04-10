package ieeemadc.saopayne.tracchis.com.makerme.fragments.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.TypedValue;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import ieeemadc.saopayne.tracchis.com.makerme.R;

/**
 * Created by saopayne on 4/5/15.
 */
public class AdialogFragment extends DialogFragment {

    DialogCallBack callback;
    int which;
    String positiveBtn;
    String negativeBtn;
    float scaleFactor;

    public static AdialogFragment getInstance(DialogCallBack callback, int which, String title, String positiveBtn, String negativeBtn){
        AdialogFragment frag = new AdialogFragment();

        frag.callback = callback;
        frag.which = which;
        frag.negativeBtn = negativeBtn;
        frag.positiveBtn = positiveBtn;

        return frag;
    }


    /* (non-Javadoc)
     * @see android.support.v4.app.DialogFragment#onCreateDialog(android.os.Bundle)
     */
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final View view = View.inflate(getActivity(), R.layout.dialog_font_size, null);
        builder.setView(view);
        builder.setCancelable(true);
        scaleFactor = 1.0F;
        SeekBar sb = (SeekBar)view.findViewById(R.id.seekbar_font);
        final TextView tv = (TextView)view.findViewById(R.id.textview_font_sample);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.textsize_normal));

        final float textSize = tv.getTextSize();
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                scaleFactor = ((float)progress / (float)seekBar.getMax()) + 0.5F;
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize * scaleFactor);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

        });

        final AlertDialog dialog = builder.create();
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, negativeBtn, new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub

            }

        });

        dialog.setButton(AlertDialog.BUTTON_POSITIVE, positiveBtn, new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub

            }

        });
        dialog.show();

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                callback.onPositiveButtonSelected(which, String.valueOf(scaleFactor));
                dialog.dismiss();
            }

        });

        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();
                callback.onNegativeButtonSelected(which, null);
            }

        });

        return dialog;
    }



}
