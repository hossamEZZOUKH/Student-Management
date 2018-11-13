package com.spring.repository;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author hunter
 * @param <T>
 * @param <ID>
 */
public class Repository<T, ID> implements GenericRepository<T, ID> {

    protected EntityManagerFactory emf;
    protected EntityManager em;
    private EntityTransaction et;

    private final Class<T> clazz;

    public Repository(Class clazz) {
        this.clazz = clazz;
    }
    
    public void begin() {
        et = em.getTransaction();
        et.begin();
    }
    
    public void commit() {
        et.commit();
    }
    
    public void open() {
        emf = Persistence.createEntityManagerFactory("MasterM2IPU");
        em = emf.createEntityManager();
    }

    public void close() {
        em.close();
        emf.close();
    }

    @Override
    public T save(T entity) {
        if (entity != null) {
            em.persist(entity);
        }
        return entity;
    }

    @Override
    public T add(T entity) {
        return save(entity);
    }

    @Override
    public void save(Collection<T> elements) {
        for (T element : elements) {
            em.persist(element);
        }
    }

    @Override
    public void add(Collection<T> elements) {
        if (elements != null) {
            for (T element : elements) {
                em.persist(element);
            }
        }
    }

    @Override
    public T create(T entity) {
        if (entity != null) {
            em.persist(entity);
        }
        return entity;
    }
        public T update(T entity) {
            em.merge(entity);
        return entity;
    }
        public T remove(T entity) {
        em.remove(entity);
        return entity;
    }
    @Override
    public T update(T oldEntity, T newEntity) {
        oldEntity = newEntity;
        return oldEntity;
    }

    @Override
    public T delete(ID id) throws Exception {
        T entity = em.find(clazz, id);
        if (entity != null) {
            em.remove(entity);
            return entity;
        }
        return null;
    }

    @Override
    public Long count() {
        return (long) em.createNamedQuery(clazz.getSimpleName() + ".findAll", clazz).getResultList().size();
    }

    @Override
    public boolean exists(ID id) {
        return em.find(clazz, id) != null;
    }

    @Override
    public List<T> findAll() {
        return em.createNamedQuery(clazz.getSimpleName() + ".findAll", clazz).getResultList();
    }

    @Override
    public T find(ID id) {
        return em.find(clazz, id);
    }

    @Override
    public T findById(ID id) {
        return find(id);
    }
    
    @Override
    public T findOne(ID id) {
        return findById(id);
    }

    @Override
    public List<T> findBy(String param, Object value) {
        TypedQuery<T> query = em.createNamedQuery(clazz.getSimpleName() + ".findBy" + Character.toUpperCase(param.charAt(0)) + param.substring(1) , clazz);
        query.setParameter(Character.toLowerCase(param.charAt(0)) + param.substring(1), value);
        return query.getResultList();
    }

    public List<T> query(String query) {
        TypedQuery<T> list = em.createQuery(query, clazz);
        return list.getResultList();
    }
}
