package houseware.learn.jpa21.criteria.test;

import houseware.learn.jpa21.criteria.Company;
import houseware.learn.jpa21.criteria.CompanyDAO;
import houseware.learn.jpa21.criteria.Country;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class CompanyDAOTest extends AbstractTest {


    @Test
    public void test_listByName() {
        EntityManager entityManager = factory.createEntityManager();
        List<Company> countries =  new CompanyDAO(entityManager).listByName("SE%%");

        assertAndShow(1, countries);

    }


    @Test
    public void test_findById() {
        EntityManager entityManager = factory.createEntityManager();
        Company country =  new CompanyDAO(entityManager).findById("B2");
        assertEquals("SETTING", country.getName());

    }



    @Test
    public void test_listByCountry() {
        EntityManager entityManager = factory.createEntityManager();
        Country c = new Country();
        c.setId("YE");
        List<Company> countries =  new CompanyDAO(entityManager).listByCountry(c);

        assertAndShow(2, countries);

    }

    @Test
    public void test_listByCountryName() {
        EntityManager entityManager = factory.createEntityManager();

        List<Company> countries =  new CompanyDAO(entityManager).listByCountryName("ZA%");

        assertAndShow(2, countries);

    }

    @Test
    public void test_totalCompaniesByCountryById() {
        EntityManager entityManager = factory.createEntityManager();

        long companies =  new CompanyDAO(entityManager).totalCompaniesByCountryById("ZM");

        assertEquals(2L, companies);

    }

    @Test
    public void test_totalCompaniesByCountry() {
        EntityManager entityManager = factory.createEntityManager();

        Country c = new Country();
        c.setId("YE");
        long companies =  new CompanyDAO(entityManager).totalCompaniesByCountry(c);

        assertEquals(2L, companies);

    }


}
