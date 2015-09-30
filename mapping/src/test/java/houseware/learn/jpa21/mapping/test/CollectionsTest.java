package houseware.learn.jpa21.mapping.test;

import lombok.Cleanup;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author fphilip@houseware.es
 */
public class CollectionsTest {

    @Test
    public void collections_context() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:collections");
        @Cleanup
        EntityManager em = emf.createEntityManager();


    }


}
