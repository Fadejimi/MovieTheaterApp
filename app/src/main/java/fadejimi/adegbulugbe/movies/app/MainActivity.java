package fadejimi.adegbulugbe.movies.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fadejimi.adegbulugbe.movies.app.adapter.CustomAdapter;
import fadejimi.adegbulugbe.movies.app.models.MovieItem;

public class MainActivity extends ActionBarActivity {
    ListView ls;
    Context context;

    private CustomAdapter adapter;
    List<MovieItem> items;

    public static final String MOVIE_NAME = "movie_name";
    public static final String MOVIE_DATE = "movie_date";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set the movie items
        addItems();
        adapter = new CustomAdapter(this, items);
        // instantiate the listview and set the adapter
        ls = (ListView) findViewById(R.id.listView);
        ls.setAdapter(adapter);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long offset) {
                MovieItem item = (MovieItem) adapter.getItem(position);

                Intent intent = new Intent(getApplicationContext(), MovieNotificationActivity.class);
                intent.putExtra(MOVIE_NAME, item.getMovieName());
                intent.putExtra(MOVIE_DATE, item.getDate());
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    // add movie items to items list
    private void addItems()
    {
        items = new ArrayList<MovieItem>();
        // add firstItem
        MovieItem item1 = new MovieItem();
        item1.setImageId(R.drawable.inside_out);
        item1.setMovieName("Inside Out");
        item1.setStarring("Amy Poehler, Bill Hader");
        item1.setGrade("G");
        item1.setDate("Fri to Thur : 10:30AM");
        item1.setURL("https://www.youtube.com/watch?v=seMwpP0yeu4");
        items.add(item1);

        MovieItem item2 = new MovieItem();
        item2.setImageId(R.drawable.man_from_uncle);
        item2.setMovieName("Man From Uncle");
        item2.setStarring("Henry Cavill, Armie Hammer");
        item2.setDate("Fri to Thur : 10:30AM");
        item2.setGrade("18");
        item2.setURL("https://www.youtube.com/watch?v=-x08iNZ8Mfc");
        items.add(item2);

        MovieItem item3 = new MovieItem();
        item3.setImageId(R.drawable.hitman);
        item3.setMovieName("Hitman: Agent 47");
        item3.setStarring("Rupert Friend, Hannah Ware");
        item3.setDate("Fri to Sun : 1:55PM, 9:25PM");
        item3.setGrade("18");
        item3.setURL("https://www.youtube.com/watch?v=alQlJDRnQkE");
        items.add(item3);

        MovieItem item4 = new MovieItem();
        item4.setImageId(R.drawable.dragon_blade);
        item4.setMovieName("Dragon Blade");
        item4.setStarring("Jackie Chan, John Cusack");
        item4.setDate("Fri to Thur : 2:20PM, 4:20PM");
        item4.setGrade("18");
        item4.setURL("https://www.youtube.com/watch?v=hfr6fVpWBiU");
        items.add(item4);

        MovieItem item5 = new MovieItem();
        item5.setImageId(R.drawable.stolen_lives);
        item5.setMovieName("Stolen Lives");
        item5.setStarring("Alex Ekubo, Jide Kosoko");
        item5.setDate("Fri to Sun : 12:25PM, 9:10PM");
        item5.setGrade("TBC");
        item5.setURL("https://www.youtube.com/watch?v=gHqbvh_Rn5M");
        items.add(item5);

        MovieItem item6 = new MovieItem();
        item6.setImageId(R.drawable.transporter);
        item6.setMovieName("The Transporter Refueled");
        item6.setStarring("Ed Skrein, Loan Chabanol, ");
        item6.setDate("Mon to Thur : 12:00PM, 3:40PM");
        item6.setGrade("15");
        item6.setURL("https://www.youtube.com/watch?v=f6xrW4YmOkw");
        items.add(item6);
    }
}
