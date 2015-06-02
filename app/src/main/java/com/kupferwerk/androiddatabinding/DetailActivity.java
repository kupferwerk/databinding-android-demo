package com.kupferwerk.androiddatabinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kupferwerk.androiddatabinding.databinding.ActivityDetailBinding;
import com.kupferwerk.androiddatabinding.model.Movie;

public class DetailActivity extends AppCompatActivity {

   private static final String EXTRA_MOVIE = "EXTRA_MOVIE";
   private ActivityDetailBinding binding;

   public static Intent buildIntent(final Context context, final Movie movie) {
      Intent intent = new Intent(context, DetailActivity.class);
      intent.putExtra(EXTRA_MOVIE, movie);
      return intent;
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      final Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
      binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
      binding.setMovie(movie);
   }
}
