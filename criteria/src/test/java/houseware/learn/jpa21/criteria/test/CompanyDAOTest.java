package houseware.learn.jpa21.criteria.test;

import houseware.learn.jpa21.criteria.Company;
import houseware.learn.jpa21.criteria.CompanyDAO;
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



}
