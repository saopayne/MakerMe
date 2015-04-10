package ieeemadc.saopayne.tracchis.com.makerme.fragments;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

import ieeemadc.saopayne.tracchis.com.makerme.R;
import ieeemadc.saopayne.tracchis.com.makerme.utils.Utils;

/**
 * Created by saopayne on 3/27/15.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class FragmentRegisterOne extends Fragment implements View.OnClickListener {

    private EditText fullNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Spinner countrySpinner;
    private Spinner educationLevelSpinner;
    private Button registerButton;
    private TextView loginTextView;

    private View rootView = null;

    private static final String DEFAULT_COUNTRY_LOCAL = "Nigeria";
    private static final String DEFAULT_EDU_BGROUND = "";
    private String [] array_country_spinner;
    private String [] array_edu_spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Context context = getActivity();
        rootView = inflater.inflate(R.layout.fragment_register_one,container,false);

        initUI();

        return rootView;

    }

    private void initUI(){
        fullNameEditText = (EditText)rootView.findViewById(R.id.edittext_fullname);
        emailEditText = (EditText)rootView.findViewById(R.id.edittext_email);
        passwordEditText = (EditText)rootView.findViewById(R.id.edittext_password);
        countrySpinner = (Spinner)rootView.findViewById(R.id.spinner_country);
        educationLevelSpinner = (Spinner)rootView.findViewById(R.id.spinner_edu_background);
        registerButton = (Button)rootView.findViewById(R.id.button_register);
        registerButton.setOnClickListener(this);
        loginTextView  = (TextView)rootView.findViewById(R.id.textview_login);
        loginTextView.setOnClickListener(this);

        array_country_spinner = getResources().getStringArray(R.array.countries_array);
        ArrayAdapter countryAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, array_country_spinner);
        countrySpinner.setAdapter(countryAdapter);
        countrySpinner.setSelection(countryAdapter.getPosition(DEFAULT_COUNTRY_LOCAL));

        array_edu_spinner = getResources().getStringArray(R.array.edu_background);
        ArrayAdapter eduAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, array_edu_spinner);
        educationLevelSpinner.setAdapter(eduAdapter);
        educationLevelSpinner.setSelection(eduAdapter.getPosition(DEFAULT_EDU_BGROUND));

    }


    private void doRegister(){
        String fullName = fullNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Force user to fill up the form
        if (fullName.equals("") && password.equals("") && email.equals("")) {
            Utils.makeLongToast("Please complete the sign up form");
        } else {
            // Save new user data into Parse.com Data Storage
            ParseUser user = new ParseUser();
            user.setUsername(fullName);
            user.setPassword(password);
            user.setEmail(email);
            user.signUpInBackground(new SignUpCallback() {

                @Override
                public void done(com.parse.ParseException e) {
                    if (e == null) {
                        // Show a simple Toast message upon successful registration
                        Utils.makeLongToast("Successfully Signed up, please log in.");
                    } else {
                        Utils.makeLongToast("User sign up error");
                    }
                }
            });
        }



    }

    @Override
    public void onClick(View view) {
        if(view.equals(registerButton)){


            Fragment pageTwoFragment = new FragmentRegisterTwo();
            android.support.v4.app.FragmentManager fm = getFragmentManager();
            android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.registerFragment,pageTwoFragment);
            ft.commit();
        }
    }
}
