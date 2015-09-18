package fadejimi.adegbulugbe.movies.app;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;

import static fadejimi.adegbulugbe.movies.app.MainActivity.MOVIE_NAME;
import static fadejimi.adegbulugbe.movies.app.MainActivity.MOVIE_DATE;

public class MovieNotificationActivity extends ActionBarActivity {
    private TextView nameTextView, dateTextView, timeTextView;
    private Button notificationButton;
    static final int TIME_DIALOG = 0;
    private SharedPreferences.Editor editor;
    // variables to save selected time
    private int hour, minute;

    // variable to set the time when it appears
    private int mHour, mMinute, mDay, mMonth, mYear;

    private PendingIntent pendingIntent;

    String movie_name = "";
    String movie_dates = "";
    public MovieNotificationActivity()
    {
        // Assign current time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);
        mMonth = c.get(Calendar.MONTH);
        mYear = c.get(Calendar.YEAR);
        mDay = c.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_notification);

        Intent intent = getIntent();
        if(intent != null)
        {
            movie_name = intent.getStringExtra(MOVIE_NAME);
            movie_dates = intent.getStringExtra(MOVIE_DATE);
        }

        nameTextView = (TextView) findViewById(R.id.nameTextView);
        nameTextView.setText(movie_name);

        dateTextView = (TextView) findViewById(R.id.newDateTextView);
        dateTextView.setText(movie_dates);

        timeTextView = (TextView) findViewById(R.id.timeTextView);
        notificationButton = (Button) findViewById(R.id.notificationButton);

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(TIME_DIALOG);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_notification, menu);
        return true;
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

    private TimePickerDialog.OnTimeSetListener mTimeSetListener =
            new TimePickerDialog.OnTimeSetListener(){
                public void onTimeSet(TimePicker view, int hourOfDay, int min)
                {
                    hour = hourOfDay;
                    minute = min;
                    // make the timeTextView visible
                    timeTextView.setVisibility(TextView.VISIBLE);
                    timeTextView.setText("Time Selected: " + hour + "-" + minute);
                    Intent myIntent = new Intent(MovieNotificationActivity.this, MyReciever.class);
                    myIntent.putExtra(MOVIE_NAME, movie_name);
                    myIntent.putExtra(MOVIE_DATE, movie_dates);

                    SharedPreferences pref = getApplicationContext().getSharedPreferences("options", MODE_PRIVATE);
                    editor = pref.edit();
                    editor.putString(MOVIE_NAME, movie_name);
                    editor.putString(MOVIE_DATE, movie_dates);
                    editor.commit();

                    pendingIntent = PendingIntent.getBroadcast(MovieNotificationActivity.this, 0, myIntent, 0);

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(mYear, mMonth, mDay, hour, minute);

                    AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                    alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
                }
            };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            // create a new TimePickerDialog with values you want to show
            case TIME_DIALOG:
                return new TimePickerDialog(this,
                        mTimeSetListener, mHour, mMinute, false);

        }
        return null;
    }
}
