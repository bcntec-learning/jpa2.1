package houseware.learn.jpa21.metamodel.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class CrazyHibernate5NamingStrategyTest {


    @Test
    public void crazyNames() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:hibernate-things");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getMetamodel();
    }


}
