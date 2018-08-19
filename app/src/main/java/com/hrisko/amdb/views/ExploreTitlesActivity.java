package com.hrisko.amdb.views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.hrisko.amdb.R;
import com.hrisko.amdb.models.Movie;

import java.util.List;

public class ExploreTitlesActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView listView;
    SearchView searchView;
    ArrayAdapter<String> adapter;
    private FirebaseFirestore mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_titles);

        listView = (ListView) findViewById(R.id.lv_movies);
        searchView = (SearchView) findViewById(R.id.sv_search_movies);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(this);
        

        mDataBase = FirebaseFirestore.getInstance();
        mDataBase.collection("movies")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        List<Movie> moviesList = task.getResult().toObjects(Movie.class);

                        for (Movie movie : moviesList) {
                            adapter.add(movie.title_eng);
                        }
                    }
                });
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String text) {
        adapter.getFilter().filter(text);
        return false;
    }
}
