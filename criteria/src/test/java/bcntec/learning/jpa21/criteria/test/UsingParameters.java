package bcntec.learning.jpa21.criteria.test;

import bcntec.learning.jpa21.criteria.Employee;
import bcntec.learning.jpa21.criteria.Employee_;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author francisco.philip@gmail.com
 */
public class UsingParameters extends AbstractTest {
    @Test
    public void between_with_parameter() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(root);
        ParameterExpression<Integer> ceil =  builder.parameter(Integer.class, "_ceil");
        ParameterExpression<Integer> floor =  builder.parameter(Integer.class, "_floor");



        query.where(
                builder.between(root.get(Employee_.age), floor, ceil)
        );

        TypedQuery<Employee>  query2 = entityManager.createQuery(query);
        query2.setParameter("_ceil",60);
        query2.setParameter("_floor",18);

        List<Employee> countries = query2.getResultList();
        assertAndShow(3, countries);

    }
}
