package com.danielbrinker.android.aca.filmsearch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by danielbrinker on 10/22/16.
 */


public class MovieDescription extends AppCompatActivity {

    ImageView imageViewDescription;
    TextView movieTitle;
    TextView movieDescription;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_movie);

        imageViewDescription = (ImageView) findViewById(R.id.imageViewDescription);
        movieTitle = (TextView) findViewById(R.id.movieTitle);
        movieDescription = (TextView) findViewById(R.id.movieDescription);


        Intent intent = getIntent();
        Movie mMovie = (Movie) intent.getSerializableExtra("Movie");
        intent.putExtra("serializable_extra", mMovie);
        movieTitle.setText(mMovie.getTitle());
        movieDescription.setText(mMovie.getDescription());


        Picasso.with(mContext)
                .load(mMovie.getBackdrop())
                .placeholder(R.color.colorAccent)
                .into(imageViewDescription);

    }
}

