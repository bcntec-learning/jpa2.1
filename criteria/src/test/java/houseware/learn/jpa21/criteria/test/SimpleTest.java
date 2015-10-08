package houseware.learn.jpa21.criteria.test;

import houseware.learn.jpa21.criteria.Country;
import houseware.learn.jpa21.criteria.Country_;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class SimpleTest extends AbstractTest {


    @Test
    public void super_simple() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        query.from(Country.class);
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(19, countries);

    }

    @Test
    public void simple_id() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = builder.createQuery(String.class);

        query.select(query.from(Country.class).get(Country_.id));

        List<String> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(19, countries);

    }



}
