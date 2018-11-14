package bcntec.learning.jpa21.metamodel.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author francisco.philip@gmail.com
 */
@Slf4j
public class CrazyHibernate5NamingStrategyTest {

    //todo
    @Test
    public void crazyNames() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:simple");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getMetamodel();
    }


}
