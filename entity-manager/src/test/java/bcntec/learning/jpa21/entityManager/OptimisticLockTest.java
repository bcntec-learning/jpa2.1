package bcntec.learning.jpa21.entityManager;

import lombok.Cleanup;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

/**
 * @author francisco.philip@gmail.com
 */
public class OptimisticLockTest extends AbstractTest {



    @Test(expected = RollbackException.class)
    public void optimistic_lock_update() {


        @Cleanup
        EntityManager em1 = factory.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        @Cleanup
        EntityManager em2 = factory.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();
        tx2.begin();

        Country a1 = em1.find(Country.class, "US");
        assertNotNull(a1);
        Country a2 = em2.find(Country.class, "US");
        assertNotNull(a2);

        a1.setName(a1.getName().concat("___"));
        a2.setName(a1.getName().concat("==="));
        em1.persist(a1);
        em2.persist(a2);
        tx2.commit();
        tx1.commit();
    }

    @Test(expected = RollbackException.class)
    public void optimistic_lock_remove() {


        @Cleanup
        EntityManager em1 = factory.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        @Cleanup
        EntityManager em2 = factory.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();
        tx2.begin();

        Country a1 = em1.find(Country.class, "VE");
        assertNotNull(a1);
        Country a2 = em2.find(Country.class, "VE");
        assertNotNull(a2);


        em1.remove(a1);
        em2.remove(a2);
        tx2.commit();
        tx1.commit();
    }
}
