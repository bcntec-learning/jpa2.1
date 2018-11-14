package bcntec.learning.jpa21.criteria.test;

import bcntec.learning.jpa21.criteria.Country;
import bcntec.learning.jpa21.criteria.Country_;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author francisco.philip@gmail.com
 */
public class ComparasionTest extends AbstractTest {

    @Test
    public void equal() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);

        query.where(
                builder.equal(root.get(Country_.id),"US")
        );

        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(1, countries);

    }



    @Test
    public void notEqual() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);

        query.where(builder.notEqual(root.get(Country_.id),"US"));

        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(18, countries);
    }
    @Test
    public void lessThan() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);

        query.where(builder.lessThan(root.get(Country_.id), "US"));

        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(6, countries);

    }



    @Test
    public void greaterThan() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);

        query.where(builder.greaterThan(root.get(Country_.id), "US"));

        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(12, countries);
    }


    @Test
    public void in() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);

        query.where(
                builder.in(root.get(Country_.id)).value( "UY").value( "UG").value( "UA").value( "YE")
        );

        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(4, countries);

    }





}
