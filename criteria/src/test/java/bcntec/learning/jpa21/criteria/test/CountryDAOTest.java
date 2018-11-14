package bcntec.learning.jpa21.criteria.test;

import bcntec.learning.jpa21.criteria.Country;
import bcntec.learning.jpa21.criteria.CountryDAO;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author francisco.philip@gmail.com
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


    @Test
    public void test_listCountriesWithCompanies() {
        EntityManager entityManager = factory.createEntityManager();
        List<Country> countries =  new CountryDAO(entityManager).listCountriesWithCompanies();
        assertAndShow(3, countries);
        assertEquals("ZAMBIA", countries.get(0).getName());
    }



}
