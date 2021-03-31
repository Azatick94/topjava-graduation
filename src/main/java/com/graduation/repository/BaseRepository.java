package com.graduation.repository;

import java.util.List;

public interface BaseRepository<T> {
    List<T> getAll();

    T getById(int id);

    void delete(int id);

    T create(T o);

    void update(T o, int id);
}
