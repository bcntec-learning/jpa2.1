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
public class MultiselectionWithTupleTest extends AbstractTest {


    @Test
    public void multiselection_tuple_simple() {

        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);

        Root<Employee> from = query.from(Employee.class);
        query.select(builder.tuple(from.get(Employee_.id), from.get(Employee_.age)));

        List<Tuple> list = entityManager.createQuery(query).getResultList();

        assertAndShowTuple(8, list);

    }

    @Test
    public void multiselection_tuple_entity() {

        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);

        Root<Employee> from = query.from(Employee.class);
        query.select(builder.tuple(from.get(Employee_.id), from));

        List<Tuple> list = entityManager.createQuery(query).getResultList();

        assertAndShowTuple(8, list);

    }

}
