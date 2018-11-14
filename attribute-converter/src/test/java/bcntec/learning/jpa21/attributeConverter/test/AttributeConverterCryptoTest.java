package bcntec.learning.jpa21.attributeConverter.test;

import bcntec.learning.jpa21.attributeConverter.User;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author francisco.philip@gmail.com
 */
@Slf4j
public class AttributeConverterCryptoTest {


//    this case
    @Test
    public void as_parameter() {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:attribute-converter");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();

        User user = entityManager.createQuery("from User u " +
                "where  u.username= :username " +
                "and u.password = :pass", User.class)
                .setParameter("username", "fphilip")
                .setParameter("pass", "password")
                .getSingleResult();
        Assert.assertNotNull("user not found", user);
        Assert.assertEquals("invalid decode", "password", user.getPassword());

    }
}
