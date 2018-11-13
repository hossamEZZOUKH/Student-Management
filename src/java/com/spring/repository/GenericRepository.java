package com.spring.repository;

import java.util.Collection;
import java.util.List;

interface GenericRepository<T, ID> {

    T save(T entity);

    T add(T entity);

    void save(Collection<T> entity);

    void add(Collection<T> entity);

    T create(T entity);

    T update(T oldEntity);

    T update(T oldEntity, T newEntity);

    T delete(ID id) throws Exception;

    Long count();

    boolean exists(ID primaryKey);

    List<T> findAll();

    T find(ID primaryKey);

    T findById(ID primaryKey);

    T findOne(ID primaryKey);

    List<T> findBy(String param, Object value);
}
