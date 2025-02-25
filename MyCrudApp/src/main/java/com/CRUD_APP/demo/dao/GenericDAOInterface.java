package com.CRUD_APP.demo.dao;

import java.util.List;

public interface GenericDAOInterface<T> {

    List<T> findAll(Class<T> entityClass);

    T findById(Class<T> entityClass, Integer id);

    T save(Class<T> entityClass, T entity);

    void deleteById(Class<T> entityClass, Integer id);
}
