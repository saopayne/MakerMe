package ieeemadc.saopayne.tracchis.com.makerme.model;

/**
 * Created by saopayne on 4/9/15.
 */
public class News  {

    private long id;
    private String title;
    private String details;
    private String date;
    private String source;

    public  News(long id,String title,String details,String date,String source){
        setId(id);
        setTitle(title);
        setDetails(details);
        setDate(date);
        setSource(source);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}