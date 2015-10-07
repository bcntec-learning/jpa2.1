package houseware.learn.jpa21.criteria.test;

import houseware.learn.jpa21.criteria.Country;
import org.junit.Assert;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public abstract class AbstractTest extends Assert {
    static EntityManagerFactory factory;

    @BeforeClass
    public static void preapre() {

        factory = Persistence.createEntityManagerFactory("jpa21:entityManager");

    }

    public static void assertAndShow(int expected, List<?> elements){
        elements.stream().forEach(System.err::println);
        assertEquals(expected, elements.size());

    }

}
