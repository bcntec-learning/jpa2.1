package houseware.learn.jpa21.entityManager;

import lombok.Cleanup;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
 */
public class OptimisticLockTest extends Assert {



    @Test(expected = RollbackException.class)
    public void optimistic_lock_update() {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:entityManager");
        @Cleanup
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        @Cleanup
        EntityManager em2 = emf.createEntityManager();
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


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:entityManager");
        @Cleanup
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        @Cleanup
        EntityManager em2 = emf.createEntityManager();
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
