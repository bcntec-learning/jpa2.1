package houseware.learn.jpa21.attributeConverter.test;

import houseware.learn.jpa21.attributeConverter.User;
import lombok.Cleanup;
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
public class AttributeConverterUserTest {


    @Test
    public void encoded_converter_test() {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:attribute-converter");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        User user = new User();
        user.setUsername("mfierro");
        user.setFirstName("Martín");
        user.setLastName("Fierro");
        user.setPassword("vizcacha");
        entityManager.persist(user);
        entityManager.flush();
        transaction.commit();


    }

    @Test
    public void decoded_converter_test() {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:attribute-converter");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        transaction.begin();
        User user = entityManager.find(User.class, "fphilip");
        Assert.assertEquals("invalid decode", "password", user.getPassword());
        entityManager.flush();
        transaction.commit();


    }
}
