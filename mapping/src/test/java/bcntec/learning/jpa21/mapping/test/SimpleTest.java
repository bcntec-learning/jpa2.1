package bcntec.learning.jpa21.mapping.test;

import lombok.Cleanup;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author francisco.philip@gmail.com
 */
public class SimpleTest {

    @Test
    public void simple_context() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:simple");
        @Cleanup
        EntityManager em = emf.createEntityManager();


    }


}
