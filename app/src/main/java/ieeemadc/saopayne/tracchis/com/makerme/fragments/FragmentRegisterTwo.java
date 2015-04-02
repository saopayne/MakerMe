package ieeemadc.saopayne.tracchis.com.makerme.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ieeemadc.saopayne.tracchis.com.makerme.R;

/**
 * Created by saopayne on 3/27/15.
 */
public class FragmentRegisterTwo extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Context context = getActivity();
        View rootView = inflater.inflate(R.layout.fragment_register_two,container,false);

        return rootView;

    }

    private void initUI(){

    }

    @Override
    public void onClick(View view) {

    }
}
