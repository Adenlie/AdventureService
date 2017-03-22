package com.adenlie.adventure.repository;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;
import org.hibernate.Session;
import org.hibernate.stat.Statistics;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public abstract class AbstractRepositoryTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    protected EntityManager entityManager;


    @Autowired
    private DataSource dataSource;

    protected Statistics hibernateStatistics;

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

    protected void save(Object entity) {
        entityManager.persist(entity);
    }

    protected void saveAll(Object... entities) {
        Arrays.stream(entities).forEach(entityManager::persist);
        entityManager.flush();
    }

    protected List getAll(EntityPath path) {
        return new JPAQuery(entityManager).from(path).list(path);
    }
}

