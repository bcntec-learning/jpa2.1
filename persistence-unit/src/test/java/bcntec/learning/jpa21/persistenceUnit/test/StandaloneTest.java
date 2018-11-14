package bcntec.learning.jpa21.persistenceUnit.test;

import bcntec.learning.jpa21.persistenceUnit.Club;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * @author francisco.philip@gmail.com
 */
@Slf4j
public class StandaloneTest {


    @Test
    public void standalone() {
        Map<String, String> map = new HashMap<>();
        map.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        map.put("hibernate.hbm2ddl.auto", "create");
        map.put("hibernate.show", "true");
        map.put("javax.persistence.jdbc.url","jdbc:hsqldb:mem:jpa21:persistence-unit");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:persistence-unit",map);
        EntityManager entityManager = factory.createEntityManager();


        for (Club club : entityManager.createQuery("from Club order by league", Club.class).getResultList()) {
            log.info(club.getName());
        }

    }


}
