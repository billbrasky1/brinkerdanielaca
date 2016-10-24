package com.danielbrinker.android.aca.filmsearch;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by danielbrinker on 10/17/16.
 */

public interface MoviesApiService {
    @GET("/3/movie/popular?api_key=a52b684a959dda9aee0e70cbe7314906")
    Call<Movie.MovieResult> getPopularMovies();
}
