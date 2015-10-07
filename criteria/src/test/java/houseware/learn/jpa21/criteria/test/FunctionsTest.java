package houseware.learn.jpa21.criteria.test;

import houseware.learn.jpa21.criteria.Country;
import houseware.learn.jpa21.criteria.Country_;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class FunctionsTest extends AbstractTest {

    @Test
    public void diff() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        query.where(builder.equal(root.get(Country_.id),"US"));
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(1, countries);

    }





}
