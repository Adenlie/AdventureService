package com.adenlie.adventure.repository;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.Collection;
import java.util.function.Function;

public abstract class AbstractRepositoryTest {

    @Autowired
    private ApplicationContext applicationContext;

    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    private DataSource dataSource;

    protected Statistics hibernateStatistics;

    public void clear() {
        entityManager.clear();
    }

    public void clearStatistics() {
        hibernateStatistics.clear();
    }

    public JPAQuery from(EntityPath<?>... paths) {
        return new JPAQuery(entityManager).from(paths);
    }


    @Before
    public void hibernateStats() {
        if (hibernateStatistics == null) {
            hibernateStatistics = entityManager.unwrap(Session.class).getSessionFactory().getStatistics();
            hibernateStatistics.setStatisticsEnabled(true);
            hibernateStatistics.clear();
        }
    }

    @After
    public void tearDown() throws Exception {
        hibernateStatistics.clear();
    }

    protected void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }

    public <T> T findMatching(Collection<T> collection, Function<T, Boolean> filterFunction) {
        return collection.stream().filter(filterFunction::apply).findFirst().get();
    }
}

