package bcntec.learning.jpa21.mapping.test;

import bcntec.learning.jpa21.mapping.polymorphic.Animal;
import lombok.Cleanup;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author francisco.philip@gmail.com
 */
public class PolymorficTest {

    @Test
    public void polymorphic_context() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:polymorphic");
        @Cleanup
        EntityManager em = emf.createEntityManager();

        em.createQuery("select object (a) from Animal a ").getResultList();
        em.createQuery("select object (a) from Dog a ").getResultList();

    }

    @Test
    public void polymorphic_criteria() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:polymorphic");
        @Cleanup
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Animal> cq = cb.createQuery(Animal.class);

        Root<Animal> r = cq.from(Animal.class);
        cq.select(r);

        em.createQuery(cq).getResultList();


    }

}
