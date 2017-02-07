//package com.adenlie.adventure.repository;
//
//import org.hibernate.stat.Statistics;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.sql.DataSource;
//import java.util.Arrays;
//
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public abstract class AbstractRepositoryTest {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Autowired
//    protected TestEntityManager entityManager;
//
//
//    @Autowired
//    private DataSource dataSource;
//
//    protected Statistics hibernateStatistics;
//
////    public JPAQuery from(EntityPath<?>... paths) {
////        return new JPAQuery(entityManager).from(paths);
////    }
//
////    @Before
////    public void hibernateStats() {
////        if (hibernateStatistics == null) {
////            hibernateStatistics = entityManager.unwrap(Session.class).getSessionFactory().getStatistics();
////            hibernateStatistics.setStatisticsEnabled(true);
////            hibernateStatistics.clear();
////        }
////    }
//
////    @After
////    public void tearDown() throws Exception {
////        hibernateStatistics.clear();
////    }
//
//    protected void flushAndClear() {
//        entityManager.flush();
//        entityManager.clear();
//    }
//
//    protected void saveAll(Object... entity) {
//        Arrays.stream(entity).forEach(entityManager::persist);
//        entityManager.flush();
//    }
//
////    protected List getAll(EntityPath path) {
////        return new JPAQuery(entityManager).from(path).list(path);
////    }
//
//}
//
