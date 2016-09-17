package com.su.dao.api;


import java.util.List;

public interface GenericDao<T> {
    List<T> getAll();
    void add(T entity);
    void remote(T entity);
}
