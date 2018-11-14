package bcntec.learning.jpa21.mapping.test;

import bcntec.learning.jpa21.mapping.inheritance.JoinInheritance2;
import lombok.Cleanup;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author francisco.philip@gmail.com
 */
public class InheritanceTest {

    @Test
    public void inheritance_context() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:inheritance");
        @Cleanup
        EntityManager em = emf.createEntityManager();
        em.find(JoinInheritance2.class,"abc");

    }

}
