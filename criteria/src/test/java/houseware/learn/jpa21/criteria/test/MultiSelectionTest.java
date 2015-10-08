package houseware.learn.jpa21.criteria.test;

import houseware.learn.jpa21.criteria.Employee;
import houseware.learn.jpa21.criteria.Employee_;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class MultiSelectionTest extends AbstractTest {



    @Test
    public void multiselection_simple() {

        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root<Employee> from = query.from(Employee.class);
        query.select(builder.array(from.get(Employee_.id), from.get(Employee_.age)));

        List<Object[]> list = entityManager.createQuery(query).getResultList();
        assertAndShowArray(8, list);


    }

    @Test
    public void multiselection_complex() {

        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root<Employee> from = query.from(Employee.class);
        query.select(builder.array(from.get(Employee_.id), from.get(Employee_.age)));

        List<Object[]> list = entityManager.createQuery(query).getResultList();
        assertAndShowArray(8, list);


    }

}
