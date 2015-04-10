package ieeemadc.saopayne.tracchis.com.makerme.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ieeemadc.saopayne.tracchis.com.makerme.R;
import ieeemadc.saopayne.tracchis.com.makerme.model.News;

/**
 * Created by saopayne on 4/9/15.
 */
public class RegionalNewsListAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private Activity activity;
    private List<News> news;

    String [] header = {"IEEE Gets a new stage","IEEE Gets a new stage",
            "IEEE Gets a new stage","IEEE Gets a new stage",
            "IEEE Gets a new stage","IEEE Gets a new stage",
            "IEEE Gets a new stage","IEEE Gets a new stage",
            "IEEE Gets a new stage","IEEE Gets a new stage"};

    String [] date = {"19th March", "19th March","19th March",
            "19th March","19th March","19th March",
            "19th March","19th March","19th March","19th March"};

    String [] source = {"IEEE OAUSB","IEEE OAUSB","IEEE OAUSB",
            "IEEE OAUSB","IEEE OAUSB","IEEE OAUSB"
            ,"IEEE OAUSB","IEEE OAUSB","IEEE OAUSB","IEEE OAUSB"};

    public RegionalNewsListAdapter(Activity a, List<News> news){
        this.activity = a;
        this.news = news;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        super.unregisterDataSetObserver(observer);
    }

    @Override
    public int getCount() {
        return source.length;
    }

    @Override
    public Object getItem(int i) {
        return source[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public static class ViewHolder{
        private TextView header;
        private TextView date;
        private TextView source;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View rootView = view;
        ViewHolder holder;
        if (view == null) {

            rootView = inflater.inflate(R.layout.regional_news_list_item, null);
        }


        holder = (ViewHolder) rootView.getTag();
        if(holder == null)
        {
            holder = new ViewHolder();
            rootView.setTag(holder);
        }else{
            holder = (ViewHolder)rootView.getTag();
        }

        holder.header = (TextView)rootView.findViewById(R.id.regional_news_item_header);
        holder.date = (TextView)rootView.findViewById(R.id.regional_news_item_date);
        holder.source = (TextView)rootView.findViewById(R.id.regional_news_item_source);

        holder.header.setText(header[i]);
        holder.date.setText(date[i]);
        holder.source.setText(source[i]);

        rootView.setOnClickListener(new OnItemClickListener(i));

        return rootView;
    }


    /********* Called when Item click in ListView ************/
    private class OnItemClickListener implements View.OnClickListener {
        private int mPosition;

        OnItemClickListener(int position) {
            mPosition = position;
        }

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
//            Intent intent = new Intent(activity,LatestInfoIndividualActivity.class);
//            //add the postId to perform other functions
//            activity.startActivity(intent);
        }


    }

}


