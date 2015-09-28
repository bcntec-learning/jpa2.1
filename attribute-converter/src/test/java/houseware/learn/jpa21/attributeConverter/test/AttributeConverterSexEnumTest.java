package houseware.learn.jpa21.attributeConverter.test;

import houseware.learn.jpa21.attributeConverter.SexEnum;
import houseware.learn.jpa21.attributeConverter.User;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class AttributeConverterSexEnumTest {


    @Test
    public void decoded_converter_test() {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:attribute-converter");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();
        User user = entityManager.find(User.class, "fphilip");
        Assert.assertEquals("invalid decode", SexEnum.MALE, user.getSex());


    }

    @Test(expected = NoResultException.class)
    public void as_parameter_we_have_a_probem() {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:attribute-converter");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();


        User user = entityManager.createQuery("select u from User u " +
                "where  u.username= :username " +
                "and u.sex = :sex", User.class)
                .setParameter("username", "fphilip")
                .setParameter("sex", SexEnum.MALE)
                .getSingleResult();


    }
}
