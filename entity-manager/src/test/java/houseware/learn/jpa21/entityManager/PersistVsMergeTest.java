package houseware.learn.jpa21.entityManager;

import lombok.extern.slf4j.Slf4j;
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
public class PersistVsMergeTest extends Assert {

    @Test
    public void simple_scenario1() {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:entityManager");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        People e = new People();

        e.setName("pepe");
        em.persist(e);
        e.setName("Pepe");

        log.info("commited, see sql executed");
        tx.commit();


        People p = em.find(People.class, 1);
        assertNotNull(p);
        assertEquals("pepe", p.getName());
        em.close();
    }

    @Test
    public void simple_scenario2() {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:entityManager");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        People e = new People();
        e.setName("juan");
        em.merge(e);
        e.setName("Juan");


        tx.commit();

        People p = em.find(People.class, 1);
        assertNotNull(p);
        assertEquals("juan", p.getName());

        em.close();
    }

    @Test
    public void simple_scenario3() {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:entityManager");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        People e = new People();
        e.setName("pedro");
        People e2 = em.merge(e);
        e2.setName("Pedro");
        log.info("commited, see sql executed");
        tx.commit();

        People p = em.find(People.class, 1);
        assertNotNull(p);
        assertEquals("Pedro", p.getName());

        em.close();
    }

}
