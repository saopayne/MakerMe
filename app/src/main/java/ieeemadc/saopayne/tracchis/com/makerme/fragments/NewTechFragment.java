package ieeemadc.saopayne.tracchis.com.makerme.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
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

import ieeemadc.saopayne.tracchis.com.makerme.R;
import ieeemadc.saopayne.tracchis.com.makerme.RSSParser.RssReader;
import ieeemadc.saopayne.tracchis.com.makerme.adapters.RegionalNewsListAdapter;
import ieeemadc.saopayne.tracchis.com.makerme.model.News;

/**
 * Created by saopayne on 4/1/15.
 */
public class NewTechFragment extends Fragment implements View.OnClickListener {


    private ListView mListView;
    private RegionalNewsListAdapter latestInfoAdapter;
    View rootView;
    private List<News> newsPosts;


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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_new_tech_news,container,false);

//        mSwipeLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.new_tech_news_swipe_refresh_layout);
//        mSwipeLayout.setColorSchemeResources(R.color.orange, R.color.blue, R.color.green, R.color.base_color);

        newsPosts = new ArrayList<News>();

        latestInfoAdapter = new RegionalNewsListAdapter(getActivity(), newsPosts);

        mListView = (ListView)rootView.findViewById(R.id.new_tech_news_list);
        adapter = new ArrayAdapter<String>(getActivity(),
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
                .getRSSFromServer("http://www.ieee.org/rss/index.html?feedId=News%20Release");
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

        return rootView;
    }

    @Override
    public void onClick(View view) {

    }
}
