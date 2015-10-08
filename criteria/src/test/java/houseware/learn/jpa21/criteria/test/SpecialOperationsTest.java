package houseware.learn.jpa21.criteria.test;

import houseware.learn.jpa21.criteria.Country;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class SpecialOperationsTest extends AbstractTest {


    @Test
    public void index() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);

        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(19, countries);

    }

    @Test
    public void keyValue() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(19, countries);

    }

    @Test
    public void size() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(19, countries);

    }


    @Test
    public void isEmpty() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(19, countries);

    }

    @Test
    public void isNotEmpty() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(19, countries);

    }

    @Test
    public void type() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(19, countries);
    }
    @Test
    public void as() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(19, countries);
    }
    @Test
    public void function() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(19, countries);
    }
}
