package houseware.learn.jpa21.entityManager;

import lombok.Cleanup;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
 */
public class LockTypeTest extends AbstractTest {


//    @Test(expected = RollbackException.class)
    public void optimistic_lock() {
        _test("VA", LockModeType.OPTIMISTIC);
    }


//    @Test(expected = RollbackException.class)
    public void optimistic_force_increment_lock() {
        _test("ZW", LockModeType.OPTIMISTIC_FORCE_INCREMENT);
    }


//    @Test(expected = RollbackException.class)
    public void pessimistic_force_increment_lock() {
        _test("US", LockModeType.PESSIMISTIC_FORCE_INCREMENT);
    }


//    @Test(expected = RollbackException.class)
    public void pessimistic_read_lock() {
        _test("VG", LockModeType.PESSIMISTIC_READ);
    }


// todo   @Test(expected = RollbackException.class)
    public void pessimistic_wrote_lock() {
//        _test("VN", LockModeType.PESSIMISTIC_WRITE);
    }

// todo   @Test(expected = RollbackException.class)
    public void lock_unlock() {
        @Cleanup
        EntityManager em1 = factory.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        @Cleanup
        EntityManager em2 = factory.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();
        tx2.begin();

        Country a1 = em1.find(Country.class, "GB");
        assertNotNull(a1);
        em1.lock(a1, LockModeType.PESSIMISTIC_READ);
        Country a2 = em2.find(Country.class, "GB");
        assertNotNull(a2);

        a1.setName(a1.getName().concat("___"));
        a2.setName(a1.getName().concat("==="));
        em1.persist(a1);
        em2.persist(a2);

        tx2.commit();
        tx1.commit();
    }


    public void _test(String country, LockModeType lockModeType) {


        @Cleanup
        EntityManager em1 = factory.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

//        @Cleanup
//        EntityManager em2 = factory.createEntityManager();
//        EntityTransaction tx2 = em2.getTransaction();
//        tx2.begin();

        Country a1 = em1.find(Country.class, country, lockModeType);
        em1.flush();
        assertNotNull(a1);
//        Country a2 = em2.find(Country.class, country);
//        assertNotNull(a2);
        System.err.println("A1"+a1.getVersion());
//        System.err.println("A2"+a2.getVersion());
//        a1.setName(a1.getName().concat("___"));
//        a2.setName(a1.getName().concat("==="));
//        em1.persist(a1);
//        em2.persist(a2);

//        tx2.commit();
        tx1.commit();
    }

}
