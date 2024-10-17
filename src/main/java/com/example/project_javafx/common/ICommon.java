package com.example.project_javafx.common;

import java.util.ArrayList;

public interface ICommon<T> {
    ArrayList<T> getAll();
    public T getById(Long id);
    //    T getOne(long id);
    boolean create(T obj);
    //    boolean add(T obj);
    boolean update(T obj, int id);
    boolean delete(int id);
}
