package ieeemadc.saopayne.tracchis.com.makerme;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import java.text.ParseException;

import ieeemadc.saopayne.tracchis.com.makerme.utils.Utils;


public class LoginActivity extends Activity implements View.OnClickListener{

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView registerText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = (EditText)findViewById(R.id.edittext_email);
        passwordEditText = (EditText)findViewById(R.id.edittext_password);
        loginButton = (Button)findViewById(R.id.button_login);
        loginButton.setOnClickListener(this);
        registerText = (TextView)findViewById(R.id.textview_register);
        registerText.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void doLogin() {
        String emailText = emailEditText.getText().toString().trim();
        String passwordText = passwordEditText.getText().toString().trim();
        // Retrieve the text entered from the EditText

        // Send data to Parse.com for verification
        ParseUser.logInInBackground(emailText, passwordText,
                new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, com.parse.ParseException e) {
                        if (parseUser != null) {
                            // If user exist and authenticated, send user to Welcome.class
                            Intent intent = new Intent(
                                    LoginActivity.this,
                                    HomeActivity.class);
                            startActivity(intent);
                            Utils.makeShortToast("Successfully logged in.");
                            finish();
                        } else {
                            Utils.makeLongToast("User doesn't exist, please sign up");
                        }
                    }
                });
    }


    private void doRegister(){
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(loginButton)){
//            doLogin();
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
        }
        if(v.equals(registerText)){
            doRegister();
        }
    }
}
