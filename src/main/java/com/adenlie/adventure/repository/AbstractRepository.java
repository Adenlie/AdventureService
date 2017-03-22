package com.adenlie.adventure.repository;

import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.path.EntityPathBase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class AbstractRepository {

    @PersistenceContext
    private EntityManager entityManager;

    JPAQuery from(EntityPath<?>... paths) {
        return new JPAQuery(entityManager).from(paths);
    }

    public JPADeleteClause delete(EntityPath<?> path) {
        return new JPADeleteClause(entityManager, path);
    }

    public List fetchAll(EntityPathBase model) {
        return from(model).list(model);
    }

    public <T> T save(T object) {
        entityManager.persist(object);
        return object;
    }

    protected void upsert(Object key, Object obj) {
        if (entityManager.find(obj.getClass(), key) == null) {
            entityManager.persist(obj);
        } else {
            entityManager.merge(obj);
        }
    }

    public JPAUpdateClause update(EntityPath<?> path) {
        return new JPAUpdateClause(entityManager, path);
    }
}