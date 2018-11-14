package bcntec.learning.jpa21.criteria.test;

import bcntec.learning.jpa21.criteria.Company;
import bcntec.learning.jpa21.criteria.Company_;
import bcntec.learning.jpa21.criteria.Employee;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author francisco.philip@gmail.com
 */
public class GroupByTest extends AbstractTest {


    @Test
    public void groupBy() {

        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Company> query = builder.createQuery(Company.class);
        Root<Company> from = query.from(Company.class);
        Join<Company, Employee> join = from.join(Company_.employees, JoinType.LEFT);


        query.select(from);
        query.groupBy(from);
        List<Company> companies = entityManager.createQuery(query).getResultList();
        assertAndShow(7, companies);
    }

}
