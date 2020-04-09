package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class DAO<T> {

    @PersistenceContext
    protected  EntityManager entityManager;

    public DAO(EntityManager entityManager){this.entityManager = entityManager;}

    public DAO() {

    }

    public abstract boolean add(T element);

    public abstract boolean modify(T element);

    public abstract T getObjectById(String id);

}