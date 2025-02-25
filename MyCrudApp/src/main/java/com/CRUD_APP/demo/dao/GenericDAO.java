package com.CRUD_APP.demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenericDAO<T> implements GenericDAOInterface<T> {

    private EntityManager entityManager;

    @Autowired
    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<T> findAll(Class<T> entityClass) {
        TypedQuery<T> query = entityManager.createQuery("FROM " + entityClass.getSimpleName(), entityClass);
        return query.getResultList();
    }

    @Override
    public T findById(Class<T> entityClass, Integer id) {
        return  entityManager.find(entityClass, id);
    }

    @Override
    public T save(Class<T> entityClass, T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void deleteById(Class<T> entityClass, Integer id) {
        T employee = entityManager.find(entityClass, id);
        entityManager.remove(employee);
    }
}
