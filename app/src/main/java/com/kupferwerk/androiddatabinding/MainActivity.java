package com.kupferwerk.androiddatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.kupferwerk.androiddatabinding.databinding.ActivityMainBinding;
import com.kupferwerk.androiddatabinding.model.Movie;
import com.kupferwerk.androiddatabinding.model.MovieStore;
import com.kupferwerk.androiddatabinding.utils.ModifyInBackgroundTask;

public class MainActivity extends AppCompatActivity {

   private ActivityMainBinding binding;

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      int id = item.getItemId();

      //noinspection SimplifiableIfStatement
      if (id == R.id.action_modify) {
         new ModifyInBackgroundTask().execute(MovieStore.getAllMovies().toArray(new Movie[0]));
         return true;
      }

      return super.onOptionsItemSelected(item);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
      initRecyclerView();
   }

   private void initRecyclerView() {
      final RecyclerView list = binding.list;
      list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
      final ListAdapter adapter = new ListAdapter(MovieStore.getAllMovies());
      adapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
         @Override
         public void onItemClick(int id, Movie movie) {
            startActivity(DetailActivity.buildIntent(getApplicationContext(), id));
         }
      });
      list.setAdapter(adapter);
   }
}
