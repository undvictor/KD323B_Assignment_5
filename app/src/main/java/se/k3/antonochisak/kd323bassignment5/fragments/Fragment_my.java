package se.k3.antonochisak.kd323bassignment5.fragments;

import android.app.Fragment;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.callback.Callback;

import retrofit.RetrofitError;
import retrofit.client.Response;
import se.k3.antonochisak.kd323bassignment5.api.model.ApiResponse;
import se.k3.antonochisak.kd323bassignment5.models.movie.Movie;

/**
 * Created by Victo on 2015-04-27.
 */
public class Fragment_my extends Fragment
        implements retrofit.Callback<List<ApiResponse>>, ListView.OnClickListener {
    ArrayList<Movie> mMovies;
    HashMap<String, Object> mMovieMap;


    @Override
    public void success(List<ApiResponse> apiResponses, Response response) {

    }

    @Override
    public void failure(RetrofitError error) {

    }

    @Override
    public void onClick(View v) {

    }
}
