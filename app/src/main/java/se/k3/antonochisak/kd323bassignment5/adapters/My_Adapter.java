package se.k3.antonochisak.kd323bassignment5.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import se.k3.antonochisak.kd323bassignment5.models.movie.Movie;
import se.k3.antonochisak.kd323bassignment5.R;
import se.k3.antonochisak.kd323bassignment5.helpers.StaticHelpers;
import se.k3.antonochisak.kd323bassignment5.models.movie.Movie;

/**
 * Created by Victo on 2015-04-27.
 */
public class My_Adapter extends BaseAdapter
{
    ArrayList<Movie> mMovies;
    LayoutInflater mLayoutInflater;

    private int mItemWidth, mItemHeight, mMargin;

    public My_Adapter(ArrayList<Movie> mMovies, LayoutInflater mLayoutInflater) {
        this.mMovies = mMovies;
        this.mLayoutInflater = mLayoutInflater;
    }

    class ViewHolder{
    @InjectView(R.id.poster_pic)
      ImageView poster_pic;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
          //  int screenWidth = StaticHelpers.getScreenWidth(view.getContext());

        //    mItemWidth = (screenWidth / 2);
        //    mItemHeight = (int) ((double) mItemWidth / 0.677);
         //   mMargin = StaticHelpers.getPixelsFromDp(view.getContext(), 2);
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.list_movies, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        // Load pictures with picasso
        Picasso.with(view.getContext())
                .load(mMovies.get(position).getPoster())
            //  .resize(mItemWidth, mItemHeight)
                .into(holder.poster_pic);


        //For title
        TextView movie_text = (TextView)view.findViewById(R.id.movie_text);

        //For years
        String years = String.valueOf(mMovies.get(position).getYear());
        //settext
        movie_text.setText(mMovies.get(position).getTitle() + " (" + years + ")");

        //likes
        TextView movie_description = (TextView)view.findViewById(R.id.movie_description);
        String likes = String.valueOf(mMovies.get(position).getLikes());
        //settext
        movie_description.setText(likes + " likes");

        Log.i("tagline", "movies "+mMovies.get(position).getYear());


        return view;
    }


    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}