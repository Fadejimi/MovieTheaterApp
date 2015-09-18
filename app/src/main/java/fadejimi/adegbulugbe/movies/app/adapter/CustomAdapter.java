package fadejimi.adegbulugbe.movies.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import fadejimi.adegbulugbe.movies.app.MainActivity;
import fadejimi.adegbulugbe.movies.app.R;
import fadejimi.adegbulugbe.movies.app.models.MovieItem;

import java.util.List;

/**
 * Created by Test on 9/17/2015.
 */
public class CustomAdapter extends BaseAdapter{
    List<MovieItem> movieItems;
    Context context;
    private static LayoutInflater inflater = null;

    public CustomAdapter(MainActivity mainActivity, List<MovieItem> movieItems)
    {
        this.movieItems = movieItems;
        context = mainActivity;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return movieItems.size();
    }

    @Override
    public MovieItem getItem(int position)
    {
        return movieItems.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    public class Holder
    {
        TextView imageNameTextView, starringTextView, gradeTextView, datesTextView;
        ImageView imageView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.movie_list, null);
        holder.imageNameTextView = (TextView) rowView.findViewById(R.id.title);
        holder.starringTextView = (TextView) rowView.findViewById(R.id.starring);
        holder.datesTextView = (TextView) rowView.findViewById(R.id.dateTextView);
        holder.imageView = (ImageView) rowView.findViewById(R.id.list_image);

        holder.imageNameTextView.setText(movieItems.get(position).getMovieName() + " "
                + movieItems.get(position).getGrade());
        holder.starringTextView.setText(movieItems.get(position).getStarring());
        //holder.gradeTextView.setText(movieItems.get(position).getGrade());
        holder.datesTextView.setText(movieItems.get(position).getDate());
        holder.imageView.setImageResource(movieItems.get(position).getImageId());

        return rowView;
    }
}
