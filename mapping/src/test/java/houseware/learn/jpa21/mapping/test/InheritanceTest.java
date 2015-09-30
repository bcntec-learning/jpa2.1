package houseware.learn.jpa21.mapping.test;

import houseware.learn.jpa21.mapping.inheritance.JoinInheritance;
import lombok.Cleanup;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author fphilip@houseware.es
 */
public class InheritanceTest {

    @Test
    public void inheritance_context() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:inheritance");
        @Cleanup
        EntityManager em = emf.createEntityManager();
        em.find(JoinInheritance.class,"abc");

    }

}
