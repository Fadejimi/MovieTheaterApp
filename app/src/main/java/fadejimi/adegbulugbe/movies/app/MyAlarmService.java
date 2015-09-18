package fadejimi.adegbulugbe.movies.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import static fadejimi.adegbulugbe.movies.app.MainActivity.MOVIE_DATE;
import static fadejimi.adegbulugbe.movies.app.MainActivity.MOVIE_NAME;

/**
 * Created by Test on 9/17/2015.
 */
public class MyAlarmService extends Service
{
    String movie_name="";
    String movie_date = "";
    SharedPreferences pref;

    private NotificationManager mManager;

    @Override
    public IBinder onBind(Intent arg0)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate()
    {
        // TODO Auto-generated method stub
        super.onCreate();
    }

    @SuppressWarnings("static-access")
    @Override
    public void onStart(Intent intent, int startId)
    {
        super.onStart(intent, startId);

        pref = this.getSharedPreferences("options", Context.MODE_PRIVATE);
        movie_name = pref.getString(MOVIE_NAME, "");
        movie_date = pref.getString(MOVIE_DATE, "");

        mManager = (NotificationManager) this.getApplicationContext().getSystemService(this.getApplicationContext().NOTIFICATION_SERVICE);
        Intent intent1 = new Intent(this.getApplicationContext(),MainActivity.class);


        Notification notification = new Notification(R.drawable.ic_launcher,movie_name + "\nDates: " + movie_date, System.currentTimeMillis());
        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingNotificationIntent = PendingIntent.getActivity( this.getApplicationContext(),0, intent1,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.setLatestEventInfo(this.getApplicationContext(), "Movie Theater Notification", movie_name + "\nDates: " + movie_date,
                pendingNotificationIntent);

        mManager.notify(0, notification);
    }

    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

}