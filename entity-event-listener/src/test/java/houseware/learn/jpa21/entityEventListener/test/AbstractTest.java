package houseware.learn.jpa21.entityEventListener.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author fphilip@houseware.es
 */
public class AbstractTest {


    public void doCase(String pu, DoIt doIt) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(pu);
            EntityManager entityManager = factory.createEntityManager();
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            doIt.doIt(entityManager,tx);
            tx.commit();
    }
}
