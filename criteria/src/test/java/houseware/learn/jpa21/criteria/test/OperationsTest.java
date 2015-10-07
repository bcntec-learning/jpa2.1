package houseware.learn.jpa21.criteria.test;

import houseware.learn.jpa21.criteria.Country;
import houseware.learn.jpa21.criteria.Country_;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class OperationsTest extends AbstractTest {


    @Test
    public void and() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        query.where(
                builder.and(builder.like(root.get(Country_.id), "U%"), builder.equal(root.get(Country_.id), "US"))
        );
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(1, countries);

    }

    @Test
    public void or() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        query.where(
                builder.or(builder.equal(root.get(Country_.id), "UY"), builder.equal(root.get(Country_.id), "US"))
        );
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(2, countries);

    }

    @Test
    public void not() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        query.where(builder.not(
                builder.or(builder.equal(root.get(Country_.id), "UY"), builder.equal(root.get(Country_.id), "US"))
        ));
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(17, countries);

    }


    @Test
    public void disjunction() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        query.where(
                builder.and(builder.disjunction(), builder.equal(root.get(Country_.id), "VE")))
        ;
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(0, countries);

    }

    @Test
    public void conjuction() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        query.where(
                builder.and(builder.conjunction(), builder.equal(root.get(Country_.id), "VE")))
        ;
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(19, countries);
    }
}
