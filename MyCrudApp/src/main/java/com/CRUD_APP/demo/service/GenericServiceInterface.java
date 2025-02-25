package com.CRUD_APP.demo.service;

import java.util.List;

public interface GenericServiceInterface<T> {
    List<T> findAll(Class<T> entityClass);
    T findById(Class<T> entityClass, int id);
    T save(Class<T> entityClass, T entity);
    void deleteById(Class<T> entityClass, int id);
}
