package ieeemadc.saopayne.tracchis.com.makerme.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ieeemadc.saopayne.tracchis.com.makerme.fragments.GeneralFragment;
import ieeemadc.saopayne.tracchis.com.makerme.fragments.InterestFragment;
import ieeemadc.saopayne.tracchis.com.makerme.fragments.NewTechFragment;

/**
 * Created by saopayne on 4/1/15.
 */
public class HomePageTabAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private GeneralFragment fragmentGeneral;
    private InterestFragment fragmentInterest;
    private NewTechFragment fragmentNewTech;

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public HomePageTabAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            return getFragmentInterest();
        }
        else if(position == 1)
        {
            return getFragmentNewTech();
        }else{
            return getFragmentGeneral();
        }

    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }

    public GeneralFragment getFragmentGeneral(){
        if(fragmentGeneral == null){
            fragmentGeneral = new GeneralFragment();
        }
        return  fragmentGeneral;
    }

    public InterestFragment getFragmentInterest(){
        if(fragmentInterest == null){
            fragmentInterest = new InterestFragment();
        }
        return fragmentInterest;
    }

    public NewTechFragment getFragmentNewTech(){
        if(fragmentNewTech == null){
            fragmentNewTech = new NewTechFragment();
        }
        return  fragmentNewTech;
    }

    public Context getContext(){
        return context;
    }
}
