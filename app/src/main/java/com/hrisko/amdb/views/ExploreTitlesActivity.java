package com.hrisko.amdb.views;

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
//ArrayList<Movie> movies;
    ListView mListView;
    SearchView mSearchView;
    ArrayAdapter<String> mAdapter;
    private FirebaseFirestore mDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_titles);

        mListView = (ListView) findViewById(R.id.lv_movies);
        mSearchView = (SearchView) findViewById(R.id.sv_search_movies);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1);
        mListView.setAdapter(mAdapter);
        mSearchView.setOnQueryTextListener(this);

        mDataBase = FirebaseFirestore.getInstance();
        mDataBase.collection("movies")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        List<Movie> moviesList = task.getResult().toObjects(Movie.class);

                        for (Movie movie : moviesList) {
                            mAdapter.add(movie.title_eng);
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
        mAdapter.getFilter().filter(text);
        return false;
    }
}
