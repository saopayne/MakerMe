package ieeemadc.saopayne.tracchis.com.makerme;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ieeemadc.saopayne.tracchis.com.makerme.RSSParser.RssReader;
import ieeemadc.saopayne.tracchis.com.makerme.adapters.RegionalNewsListAdapter;
import ieeemadc.saopayne.tracchis.com.makerme.model.News;


public class RegionalNewsActivity extends ActionBarActivity implements View.OnClickListener {

    private RegionalNewsListAdapter listAdapter;
    private ListView mListView;
    Toolbar toolbar;

    String key_items = "item";
    String key_title = "title";
    String key_description = "description";
    String key_link = "link";
    String key_date = "pubDate";
    ListView lstPost = null;
    List<HashMap<String, Object>> post_lists = new ArrayList<HashMap<String, Object>>();
    List<String> lists = new ArrayList<String>();
    ArrayAdapter<String> adapter = null;
    RssReader rssfeed = new RssReader();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regional_news);

        initUI();
    }

    private  void initUI(){
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listAdapter = new RegionalNewsListAdapter(this,new ArrayList<News>());
        mListView = (ListView)findViewById(R.id.regional_news_list);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_2, android.R.id.text1, lists) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView txt1 = (TextView) view
                        .findViewById(android.R.id.text1);
                TextView txt2 = (TextView) view
                        .findViewById(android.R.id.text2);
                HashMap<String, Object> data = post_lists.get(position);
                txt1.setText(data.get(key_title).toString());
                txt2.setText(data.get(key_description).toString());
                return view;
            }

        };
        Document xmlFeed = rssfeed
                .getRSSFromServer("http://feeds.feedburner.com/IeeeSpectrum?format=xml");
        NodeList nodes = xmlFeed.getElementsByTagName("item");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element item = (Element) nodes.item(i);
            HashMap<String, Object> feed = new HashMap<String, Object>();
            feed.put(key_title, rssfeed.getValue(item, key_title));
            feed.put(key_description, rssfeed.getValue(item, key_description));
            feed.put(key_link, rssfeed.getValue(item, key_link));
            feed.put(key_date, rssfeed.getValue(item, key_date));
            post_lists.add(feed);
            lists.add(feed.get(key_title).toString());
        }

        mListView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_regional_news, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
    public void onClick(View view) {

    }
}
