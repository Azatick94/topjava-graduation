package com.graduation.service;
import java.util.List;

public interface BaseService<T> {
    List<T> getAll();

    T getById(int id);

    T save(T o);

    void update(T o, int id);

    void delete(int id);
}
