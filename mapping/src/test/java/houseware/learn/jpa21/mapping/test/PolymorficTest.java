package houseware.learn.jpa21.mapping.test;

import houseware.learn.jpa21.mapping.secondaryTable.User;
import houseware.learn.jpa21.mapping.secondaryTable.UserFull;
import lombok.Cleanup;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author fphilip@houseware.es
 */
public class PolymorficTest {

    @Test
    public void polymorphic_context() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:polymorphic");
        @Cleanup
        EntityManager em = emf.createEntityManager();


    }

}
