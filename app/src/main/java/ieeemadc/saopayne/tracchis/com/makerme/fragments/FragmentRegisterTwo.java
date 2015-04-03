package ieeemadc.saopayne.tracchis.com.makerme.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import ieeemadc.saopayne.tracchis.com.makerme.HomeActivity;
import ieeemadc.saopayne.tracchis.com.makerme.R;

/**
 * Created by saopayne on 3/27/15.
 */
public class FragmentRegisterTwo extends Fragment implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{

    private CheckBox boxComputer;
    private CheckBox boxElectrical;
    private CheckBox boxChemical;
    private CheckBox boxMechanical;
    private CheckBox boxAgricultural;
    private CheckBox boxMetallurgy;
    private CheckBox boxFood;
    private CheckBox boxCivil;
    private CheckBox boxAeronautics;
    private CheckBox boxNanoTech;
    private Button btnSignUp;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_register_two,container,false);

        boxComputer = (CheckBox)rootView.findViewById(R.id.box_computer);
        boxComputer.setOnCheckedChangeListener(this);
        boxElectrical = (CheckBox)rootView.findViewById(R.id.box_electrical);
        boxElectrical.setOnCheckedChangeListener(this);
        boxChemical = (CheckBox)rootView.findViewById(R.id.box_chemical);
        boxChemical.setOnCheckedChangeListener(this);
        boxMechanical = (CheckBox)rootView.findViewById(R.id.box_mechanical);
        boxMechanical.setOnCheckedChangeListener(this);
        boxAgricultural = (CheckBox)rootView.findViewById(R.id.box_agricultural);
        boxAgricultural.setOnCheckedChangeListener(this);
        boxMetallurgy = (CheckBox)rootView.findViewById(R.id.box_metallurgy);
        boxMetallurgy.setOnCheckedChangeListener(this);
        boxFood = (CheckBox)rootView.findViewById(R.id.box_food);
        boxFood.setOnCheckedChangeListener(this);
        boxCivil = (CheckBox)rootView.findViewById(R.id.box_civil);
        boxCivil.setOnCheckedChangeListener(this);
        boxAeronautics = (CheckBox)rootView.findViewById(R.id.box_aeronautics);
        boxAeronautics.setOnCheckedChangeListener(this);
        boxNanoTech = (CheckBox)rootView.findViewById(R.id.box_nanotech);
        boxNanoTech.setOnCheckedChangeListener(this);
        btnSignUp = (Button)rootView.findViewById(R.id.button_sec_sign_up);
        btnSignUp.setOnClickListener(this);

        return rootView;

    }


    @Override
    public void onClick(View v) {

        if(v.equals(btnSignUp)){
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if(compoundButton.equals(boxComputer)){
            if(boxComputer.isChecked()){

            }
        }


    }
}
