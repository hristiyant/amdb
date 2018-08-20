package com.hrisko.amdb.repo;

import android.annotation.SuppressLint;

import com.google.firebase.firestore.FirebaseFirestore;
import com.hrisko.amdb.repo.RepositoryBase;
import java.util.function.Consumer;
import java.util.List;



public class FirestoreRepository implements RepositoryBase {

    private final FirebaseFirestore mDb;
    private final Class<T> mKlass;
    private final String mCollectionName;

    public FirestoreRepository(Class<T> klass) {
        mDb = FirebaseFirestore.getInstance();
        mKlass = klass;
        mCollectionName = klass.getSimpleName().toLowerCase() + "s";
    }


    @SuppressLint("NewApi")
    @Override
    public void getAll(Consumer action) {
        mDb.collection(mCollectionName)
                .get()
                .addOnCompleteListener(task -> {
                    List<T> items = task.getResult()
                            .toObjects(mKlass);
                    action.accept(items);
                });
    }

    @SuppressLint("NewApi")
    @Override
    public void add(Object item, Consumer action) {
        mDb.collection(mCollectionName)
                .add(item)
                .addOnCompleteListener(task -> {
                    action.accept(item);
                });
    }
}
