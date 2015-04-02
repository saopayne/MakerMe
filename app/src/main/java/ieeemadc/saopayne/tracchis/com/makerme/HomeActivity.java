package ieeemadc.saopayne.tracchis.com.makerme;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.heinrichreimersoftware.materialdrawer.DrawerFrameLayout;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerItem;
import com.heinrichreimersoftware.materialdrawer.structure.DrawerProfile;

import java.util.ArrayList;

import ieeemadc.saopayne.tracchis.com.makerme.adapters.HomePageTabAdapter;
import ieeemadc.saopayne.tracchis.com.makerme.adapters.NavDrawerListAdapter;
import ieeemadc.saopayne.tracchis.com.makerme.views.NavDrawerItem;
import ieeemadc.saopayne.tracchis.com.makerme.views.SlidingTabLayout;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class HomeActivity extends ActionBarActivity implements View.OnClickListener,ActionBar.TabListener{

    /**
     * UI Views
     */

    Toolbar toolbar;
    ViewPager pager;
    HomePageTabAdapter homeAdapter;
    SlidingTabLayout tabs;
    CharSequence Titles[] = {"Interest","New Tech","General"};
    int Numboftabs = 3;
    /**
     * For the navigation drawers
     */
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
    private TextView brandLinkText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        prepareViewComponents();

        prepareNavigationDrawerComponents();
        if (savedInstanceState == null) {
            // on first time display view for first nav item
        }

    }

    private void prepareViewComponents(){
        // Initialization
        // Creating The Toolbar and setting it as the Toolbar for the activity

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        homeAdapter =  new HomePageTabAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(homeAdapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @SuppressLint("NewApi")
    private void prepareNavigationDrawerComponents(){

        DrawerFrameLayout drawer = (DrawerFrameLayout)findViewById(R.id.drawer);

        drawer.setProfile(
                new DrawerProfile()
                        .setAvatar(getResources().getDrawable(R.drawable.ic_drawer))
                        .setBackground(getResources().getDrawable(R.drawable.nav_drawer_profile_bground))
                        .setName(getString(R.string.string_settings))
                        .setOnProfileClickListener(new DrawerProfile.OnProfileClickListener() {
                            @Override
                            public void onClick(DrawerProfile drawerProfile) {

                            }
                        })
        );

        drawer.addItem(
                new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.engineer_icon))
                        .setTextPrimary(getString(R.string.string_be_an_engineer))
                        .setOnItemClickListener(new DrawerItem.OnItemClickListener() {
                            @Override
                            public void onClick(DrawerItem drawerItem, int id, int position) {
                                Intent intent = new Intent(HomeActivity.this,BeEngineerActivity.class);
                                startActivity(intent);
                            }
                        })
        );
        drawer.addDivider();
        drawer.addItem(
                new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.region_icon))
                        .setTextPrimary(getString(R.string.string_regional_news))
                        .setOnItemClickListener(new DrawerItem.OnItemClickListener() {
                            @Override
                            public void onClick(DrawerItem drawerItem, int id, int position) {
                                Intent intent = new Intent(HomeActivity.this, RegionalNewsActivity.class);
                                startActivity(intent);
                            }
                        })
        );
        drawer.addDivider();
        drawer.addItem(
                new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.history_icon))
                        .setTextPrimary(getString(R.string.string_history))
                        .setOnItemClickListener(new DrawerItem.OnItemClickListener() {
                            @Override
                            public void onClick(DrawerItem drawerItem, int id, int position) {
                                Intent intent = new Intent(HomeActivity.this,HistoryActivity.class);
                                startActivity(intent);
                            }
                        })
        );
        drawer.addDivider();
        drawer.addItem(
                new DrawerItem()
                        .setImage(getResources().getDrawable(R.drawable.settings_icon))
                        .setTextPrimary(getString(R.string.string_settings))
                        .setOnItemClickListener(new DrawerItem.OnItemClickListener() {
                            @Override
                            public void onClick(DrawerItem drawerItem, int id, int position) {
                                Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
                                startActivity(intent);
                            }
                        })
        );

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,  mDrawerLayout, toolbar,
                R.string.string_settings, R.string.string_settings
        );
        drawer.setDrawerListener(new ActionBarDrawerToggle( this,  mDrawerLayout, toolbar,
                R.string.string_settings, R.string.string_settings));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
//        mDrawerToggle.syncState();

//
//        mTitle = mDrawerTitle = getTitle();
//        // load slide menu items
//        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
//
//        // nav drawer icons from resources\
//        navMenuIcons = getResources()
//                .obtainTypedArray(R.array.nav_drawer_icons);
//
//        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
//        mDrawerList = (ListView) findViewById(R.id.left_drawer);
//        mDrawerList.setBackgroundResource(R.color.drawer_background);
//
//
//
//        navDrawerItems = new ArrayList<NavDrawerItem>();
//
//        mDrawerToggle = new ActionBarDrawerToggle(this,
//                mDrawerLayout
//                , R.drawable.ic_drawer // navigation menu toggle icon
//                , R.string.app_name //when the drawer opens
//                , R.string.app_name) // when the drawer closes
//        {
//            public void onDrawerClosed(View view) {
////                getActionBar().setTitle(mTitle);
//                // calling onPrepareOptionsMenu() to show action bar icons
//                invalidateOptionsMenu();
//            }
//
//            public void onDrawerOpened(View drawerView) {
////                getActionBar().setTitle(mDrawerTitle);
//                // calling onPrepareOptionsMenu() to hide action bar icons
//                invalidateOptionsMenu();
//            }
//        };
//
//        mDrawerLayout.setDrawerListener(mDrawerToggle);

    }

    /**
     *  Slide menu item click listener
     **/
    private class SlideMenuClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parentduration, View view, int position,long id) {
            // display view for selected nav drawer item
            switch (position) {

                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }
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

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}
