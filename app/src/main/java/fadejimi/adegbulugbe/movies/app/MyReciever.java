package fadejimi.adegbulugbe.movies.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import static fadejimi.adegbulugbe.movies.app.MainActivity.MOVIE_DATE;
import static fadejimi.adegbulugbe.movies.app.MainActivity.MOVIE_NAME;

/**
 * Created by Test on 9/17/2015.
 */

public class MyReciever extends BroadcastReceiver
{
    String movie_name = "";
    String movie_dates = "";
    @Override
    public void onReceive(Context context, Intent intent)
    {
        movie_name = intent.getStringExtra("MOVIE_NAME");
        movie_dates = intent.getStringExtra("MOVIE_DATE");

        Intent service1 = new Intent(context, MyAlarmService.class);
        service1.putExtra(MOVIE_NAME, movie_name);
        service1.putExtra(MOVIE_DATE, movie_dates);

        context.startService(service1);
    }
}