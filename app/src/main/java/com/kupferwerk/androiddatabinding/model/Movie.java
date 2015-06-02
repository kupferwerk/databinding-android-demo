package com.kupferwerk.androiddatabinding.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Movie implements Parcelable {

   public static final Creator<Movie> CREATOR = new Creator<Movie>() {
      @Override
      public Movie createFromParcel(Parcel in) {
         return new Movie(in);
      }

      @Override
      public Movie[] newArray(int size) {
         return new Movie[size];
      }
   };
   private String genre;
   private String imageUrl;
   private Date publicationDate;
   private String title;

   public Movie() {

   }

   private Movie(Parcel in) {
      genre = in.readString();
      imageUrl = in.readString();
      title = in.readString();
      publicationDate = new Date(in.readLong());
   }

   @Override
   public int describeContents() {
      return 0;
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

   @Override
   public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(genre);
      dest.writeString(imageUrl);
      dest.writeString(title);
      dest.writeLong(publicationDate.getTime());
   }
}
