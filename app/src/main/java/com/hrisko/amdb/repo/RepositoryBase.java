package com.hrisko.amdb.repo;

import java.util.List;
import java.util.function.Consumer;

public interface RepositoryBase<T> {
    void getAll(Consumer<List<T>> action);

    void add(T item, Consumer<T> action);

}
