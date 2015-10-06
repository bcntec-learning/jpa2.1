package houseware.learn.jpa21.entityManager;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class FetchTest extends Assert {

    @Test
    public void relation_scenario1() {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:entityManager");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Country c = new Country();
        c.setId("GR");
        c.setName("Germany");
        People e = new People();
        e.setId(91);
        e.setName("Mateo");
        e.setCountry(c);
        em.persist(c);
        em.persist(e);
        tx.commit();
        tx.begin();

        EntityManager em2 = emf.createEntityManager();
        People p = em.find(People.class, 91);
        assertNotNull(p);
        assertEquals("Mateo", p.getName());
        assertEquals("Germany", p.getCountry().getName());
        em2.close();
    }

    /**
     * Testing Lazy Loading Fetch
     */
    @Test(expected = LazyInitializationException.class)
    public void relation_scenario2() {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:entityManager");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Country c = new Country();
        c.setId("PT");
        c.setName("Portugal");
        People e = new People();
        e.setId(92);
        e.setName("Santiago");
        e.setCountry(c);
        em.persist(c);
        em.persist(e);
        tx.commit();
        em.close();


        EntityManager em2 = emf.createEntityManager();
        People p = em2.find(People.class, 92);
        em2.close();
        assertNotNull(p);
        assertEquals("Santiago", p.getName());
        assertEquals("Portugal", p.getCountry().getName());


    }
}
