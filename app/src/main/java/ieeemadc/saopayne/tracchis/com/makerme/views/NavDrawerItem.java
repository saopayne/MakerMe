package ieeemadc.saopayne.tracchis.com.makerme.views;

/**
 * Created by saopayne on 4/1/15.
 */

public class NavDrawerItem {

    private String title;
    private int icon;
    private String count = "0";

    //boolean to set the counter visible
    private boolean isCounterVisible = false;

    public NavDrawerItem() {
    }

    public NavDrawerItem(String title, int icon) {
        this.icon = icon;
        this.title = title;
    }

    public NavDrawerItem(String title, int icon, boolean isCounterVisible, String count) {

        this.title = title;
        this.icon = icon;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return this.icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public boolean isCounterVisible() {
        return this.isCounterVisible;
    }

    public void setCounterVisible(boolean isCounterVisible) {
        this.isCounterVisible = isCounterVisible;
    }


}