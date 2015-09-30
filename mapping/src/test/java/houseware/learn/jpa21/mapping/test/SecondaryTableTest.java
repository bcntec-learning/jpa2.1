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
public class SecondaryTableTest {

    @Test
    public void secondary_table_context() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:secondary-table");
        @Cleanup
        EntityManager em = emf.createEntityManager();
    }


    @Test
    public void user_onetoone() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:secondary-table");
        @Cleanup
        EntityManager em = emf.createEntityManager();

        User u = em.find(User.class, 1L);
        Assert.assertEquals(u.getUserName(), "JUAN");

        Assert.assertEquals(u.getExt().getFacebook(), "juan@facebook");
        Assert.assertEquals(u.getExt().getTwitter(), "juan@witter");

    }


    @Test
    public void user_full_secondary_table() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:secondary-table");

        @Cleanup
        EntityManager em = emf.createEntityManager();

        UserFull u = em.find(UserFull.class, 2L);
        Assert.assertEquals(u.getUserName(), "PEDRO");
        Assert.assertEquals(u.getFacebook(), "pedro@facebook");
        Assert.assertEquals(u.getTwitter(), "pedro@witter");


    }


}
