package ieeemadc.saopayne.tracchis.com.makerme;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class HistoryActivity extends ActionBarActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private TextView featTextView;
    private TextView womenTextView;
    private TextView inventionsTextView;
    private TextView organisationsTextView;
    private TextView coreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        initUI();
    }

    private void initUI(){
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        featTextView = (TextView)findViewById(R.id.engineering_feat_history);
        featTextView.setOnClickListener(this);
        womenTextView = (TextView)findViewById(R.id.engineering_women_history);
        womenTextView.setOnClickListener(this);
        inventionsTextView = (TextView)findViewById(R.id.engineering_inventions_history);
        inventionsTextView.setOnClickListener(this);
        organisationsTextView = (TextView)findViewById(R.id.engineering_organisations_history);
        organisationsTextView.setOnClickListener(this);
        coreTextView  = (TextView)findViewById(R.id.engineering_main_history);
        coreTextView.setOnClickListener(this);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_history, menu);
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
    public void onClick(View v) {

    }
}
