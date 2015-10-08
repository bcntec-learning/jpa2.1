package houseware.learn.jpa21.criteria.test;

import houseware.learn.jpa21.criteria.Company;
import houseware.learn.jpa21.criteria.Company_;
import houseware.learn.jpa21.criteria.Country;
import houseware.learn.jpa21.criteria.Country_;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class SubqueryTest extends AbstractTest {


    @Test
    public void subquery_on_where() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        Subquery<Long> sq = query.subquery(Long.class);
        Root<Company> sRoot = sq.from(Company.class);

        Expression<Long> e = builder.count(sRoot.get(Company_.id));
        sq.select(e);
        sq.where(
                builder.equal(
                        sRoot.get(Company_.country), root.get(Country_.id))

                );


        query.where(builder.greaterThan(sq, 2L));
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(1, countries);
        assertEquals("UZBEKISTAN", countries.get(0).getName());
    }


}
