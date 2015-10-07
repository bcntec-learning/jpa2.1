package houseware.learn.jpa21.criteria.test;

import houseware.learn.jpa21.criteria.Country;
import houseware.learn.jpa21.criteria.CountryDAO;
import houseware.learn.jpa21.criteria.Country_;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class CountryDAOTest extends AbstractTest {


    @Test
    public void test_listByName() {
        EntityManager entityManager = factory.createEntityManager();
        List<Country> countries =  new CountryDAO(entityManager).listByName("UN%");

        assertAndShow(4, countries);

    }


    @Test
    public void test_findById() {
        EntityManager entityManager = factory.createEntityManager();
        Country country =  new CountryDAO(entityManager).findById("VU");
        assertEquals("VANUATU", country.getName());

    }



}
