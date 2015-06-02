package com.kupferwerk.androiddatabinding.model;

import java.util.Date;

public class Movie {

   private String genre;
   private String imageUrl;
   private Date publicationDate;
   private String title;

   public Movie() {

   }

   public String getGenre() {
      return genre;
   }

   public Movie setGenre(String genre) {
      this.genre = genre;
      return this;
   }

   public String getImageUrl() {
      return imageUrl;
   }

   public Movie setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;
      return this;
   }

   public Date getPublicationDate() {
      return publicationDate;
   }

   public Movie setPublicationDate(Date publicationDate) {
      this.publicationDate = publicationDate;
      return this;
   }

   public String getTitle() {
      return title;
   }

   public Movie setTitle(String title) {
      this.title = title;
      return this;
   }
}
