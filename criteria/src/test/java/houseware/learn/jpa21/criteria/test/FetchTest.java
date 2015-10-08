package houseware.learn.jpa21.criteria.test;

import houseware.learn.jpa21.criteria.*;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class FetchTest extends AbstractTest {


    @Test
    public void fetch_inner() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Company> query = builder.createQuery(Company.class);
        Root<Company> companyRoot = query.from(Company.class);
        Fetch<Company, Employee> fetch = companyRoot.fetch(Company_.employees);
        query.select(companyRoot);
        List<Company> companies = entityManager.createQuery(query).getResultList();
        assertAndShow(8, companies);
    }

    @Test
    public void fetch_left() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Company> query = builder.createQuery(Company.class);
        Root<Company> companyRoot = query.from(Company.class);
        Fetch<Company, Employee> fetch = companyRoot.fetch(Company_.employees, JoinType.LEFT);
        query.select(companyRoot);
        List<Company> companies = entityManager.createQuery(query).getResultList();
        assertAndShow(11, companies);
    }



}
