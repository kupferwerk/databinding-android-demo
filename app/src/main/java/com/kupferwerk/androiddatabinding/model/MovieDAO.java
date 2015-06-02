package com.kupferwerk.androiddatabinding.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieDAO {

   public static List<Movie> getAllMovies() {
      final List<Movie> movies = new ArrayList<>(20);
      movies.add(new Movie().setTitle("Marvel's The Avengers 2: Age of Ultron").setGenre("Action")
            .setPublicationDate(new Date(1430438400000L))
            .setImageUrl("https://image.tmdb.org/t/p/original/xkgUhkH2ODT5yy5q6FviW3M2aRB.jpg"));
      movies.add(new Movie().setTitle("The Amazing Spider-Man").setGenre("Action")
            .setPublicationDate(new Date(1341360000000L))
            .setImageUrl("https://image.tmdb.org/t/p/original/dosjP4HDZgUl8vD3qq09cbSF5E2.jpg"));

      return movies;
   }
}
