package com.kupferwerk.androiddatabinding.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BindingUtils {

   @BindingAdapter ({"bind:imageUrl"})
   public static void loadImage(ImageView view, String url) {
      Picasso.with(view.getContext()).load(url).into(view);
   }
}
