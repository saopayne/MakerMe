package ieeemadc.saopayne.tracchis.com.makerme.fragments.dialog;

/**
 * Created by saopayne on 4/5/15.
 */
public interface DialogCallBack {

    public void onPositiveButtonSelected(int which, String data);
    public void onNegativeButtonSelected(int which, String data);
    public void onNeutralButtonSelected(int which, String data);
    public void onDialogCancel(int which);

}

