package ieeemadc.saopayne.tracchis.com.makerme;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ieeemadc.saopayne.tracchis.com.makerme.fragments.dialog.AdialogFragment;
import ieeemadc.saopayne.tracchis.com.makerme.fragments.dialog.DialogCallBack;
import ieeemadc.saopayne.tracchis.com.makerme.utils.AppPreferences;


public class SettingsActivity extends ActionBarActivity implements DialogCallBack {

    private Toolbar toolbar;
    View buttonFont;
    final static int WHICH_FONT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initUI();
    }

    private void initUI(){
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonFont = findViewById(R.id.button_font);
        buttonFont.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                AdialogFragment dialog = AdialogFragment.getInstance(SettingsActivity.this, WHICH_FONT, "Adjust font size", "Use this size", "Cancel");
                dialog.show(getSupportFragmentManager(),"font_size");
            }

        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == android.R.id.home){
            this.onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPositiveButtonSelected(int which, String data) {
        // TODO Auto-generated method stub
        switch(which){
            case WHICH_FONT:
                float scaleFactor = Float.valueOf(data);
                new AppPreferences().setFontScale(scaleFactor);
                break;
        }
    }


    @Override
    public void onNegativeButtonSelected(int which, String data) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onNeutralButtonSelected(int which, String data) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onDialogCancel(int which) {
        // TODO Auto-generated method stub

    }
}
