package fadejimi.adegbulugbe.movies.app.models;

import java.util.Date;

/**
 * Created by Test on 9/16/2015.
 */
public class MovieItem {
    private int imageId;
    private String movieName, starring, runningTime, grade, date, url;

    public MovieItem()
    {

    }

    public MovieItem(int imageId, String name, String starring, String runningTime, String grade,
                          String date, String url)
    {
        setImageId(imageId);
        setMovieName(name);
        setStarring(starring);
        setRunningTime(runningTime);
        setGrade(grade);
        setDate(date);
        setURL(url);
    }

    public void setImageId(int i)
    {
        imageId = i;
    }

    public int getImageId()
    {
        return imageId;
    }

    public void setMovieName(String name)
    {
        movieName = name;
    }

    public void setStarring(String starr)
    {
        starring = starr;
    }

    public void setRunningTime(String time)
    {
        runningTime = time;
    }

    public void setGrade(String g)
    {
        grade = g;
    }

    public void setDate(String d)
    {
        date = d;
    }

    public String getMovieName()
    {
        return movieName;
    }

    public String getStarring()
    {
        return starring;
    }

    public String getGrade()
    {
        return grade;
    }

    public String getDate()
    {
        return date;
    }

    public void setURL(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    public String getRunningTime()
    {
        return runningTime;
    }
}
