package com.kupferwerk.androiddatabinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kupferwerk.androiddatabinding.databinding.ActivityDetailBinding;
import com.kupferwerk.androiddatabinding.model.Movie;
import com.kupferwerk.androiddatabinding.model.MovieStore;
import com.kupferwerk.androiddatabinding.utils.DateUtils;

public class DetailActivity extends AppCompatActivity {

   private static final String EXTRA_MOVIE_ID = "EXTRA_MOVIE_ID";
   private ActivityDetailBinding binding;

   public static Intent buildIntent(final Context context, final int movieId) {
      Intent intent = new Intent(context, DetailActivity.class);
      intent.putExtra(EXTRA_MOVIE_ID, movieId);
      return intent;
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      final int movieId = getIntent().getIntExtra(EXTRA_MOVIE_ID, 0);
      final Movie movie = MovieStore.getAllMovies().get(movieId);
      binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
      binding.setMovie(movie);
      binding.saveButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            String title = binding.title.getText().toString();
            String genre = binding.genre.getText().toString();
            String publicationDateString = binding.publicationDate.getText().toString();
            movie.setTitle(title);
            movie.setGenre(genre);
            movie.setPublicationDate(DateUtils.parseDate(publicationDateString));
            finish();
         }
      });
   }
}
