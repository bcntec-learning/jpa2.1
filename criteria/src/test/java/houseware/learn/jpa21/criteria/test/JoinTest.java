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
public class JoinTest extends AbstractTest {


    @Test
    public void join_inner() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> countryRoot = query.from(Country.class);
        Root<Company> companyRoot = query.from(Company.class);
        Join< Company, Country> join = companyRoot.join(Company_.country);

        query.select(countryRoot);

        List<Country> companies = entityManager.createQuery(query).getResultList();
        assertAndShow(133, companies);
    }

    @Test
    public void join_left() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> countryRoot = query.from(Country.class);
        Root<Company> companyRoot = query.from(Company.class);
        Join< Company, Country> join = companyRoot.join(Company_.country, JoinType.LEFT);
        query.select(countryRoot);
        List<Country> companies = entityManager.createQuery(query).getResultList();
        assertAndShow(133, companies);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void join_right() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> countryRoot = query.from(Country.class);
        Root<Company> companyRoot = query.from(Company.class);
        query.select(countryRoot);
        Join< Company, Country> join = companyRoot.join(Company_.country, JoinType.RIGHT);


        List<Country> companies = entityManager.createQuery(query).getResultList();
        assertAndShow(6, companies);
    }

    @Test
     public void join_inner_on_expression() {
         EntityManager entityManager = factory.createEntityManager();
         CriteriaBuilder builder = entityManager.getCriteriaBuilder();

         CriteriaQuery<Country> query = builder.createQuery(Country.class);
         Root<Country> countryRoot = query.from(Country.class);
         Root<Company> companyRoot = query.from(Company.class);
         Join< Company, Country> join = companyRoot.join(Company_.country);
         join.on(builder.like(countryRoot.get(Country_.name), "UNI%"));
         query.select(countryRoot);

         List<Country> companies = entityManager.createQuery(query).getResultList();
         assertAndShow(28, companies);
     }




}
