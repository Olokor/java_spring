package com.CRUD_APP.demo.service;

import com.CRUD_APP.demo.dao.GenericDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenericService<T> implements GenericServiceInterface<T> {

    private GenericDAO<T> dao;
    @Autowired
    public GenericService(GenericDAO<T> dao) {
        this.dao = dao;
    }
    @Override
    public List<T> findAll(Class<T> entityClass) {

        return dao.findAll(entityClass);
    }

    @Override
    public T findById(Class<T> entityClass, int id) {
        return dao.findById(entityClass, id);
    }

    @Transactional
    @Override
    public T save(Class<T> entityClass, T entity) {
        return dao.save(entityClass, entity);
    }

    @Transactional
    @Override
    public void deleteById(Class<T> entityClass, int id) {

    }
}
