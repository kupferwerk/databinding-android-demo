package com.kupferwerk.androiddatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kupferwerk.androiddatabinding.databinding.ListItemBinding;
import com.kupferwerk.androiddatabinding.model.Movie;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

   public interface OnItemClickListener {
      void onItemClick(final int id, final Movie movie);
   }

   public static class ViewHolder extends RecyclerView.ViewHolder {
      private final ListItemBinding binding;

      ViewHolder(final ListItemBinding binding) {
         super(binding.getRoot());
         this.binding = binding;
      }
   }

   private final List<Movie> movies;
   private LayoutInflater layoutInflater;
   private OnItemClickListener onItemClickListener;

   public ListAdapter(List<Movie> movies) {
      this.movies = movies;
   }

   @Override
   public int getItemCount() {
      return movies.size();
   }

   @Override
   public void onBindViewHolder(ViewHolder viewHolder, final int i) {
      viewHolder.binding.setMovie(movies.get(i));
      viewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            if (onItemClickListener != null) {
               onItemClickListener.onItemClick(i, movies.get(i));
            }
         }
      });
   }

   @Override
   public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
      if (layoutInflater == null) {
         layoutInflater = LayoutInflater.from(viewGroup.getContext());
      }
      final ListItemBinding binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false);
      return new ViewHolder(binding);
   }

   public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
      this.onItemClickListener = onItemClickListener;
   }
}
