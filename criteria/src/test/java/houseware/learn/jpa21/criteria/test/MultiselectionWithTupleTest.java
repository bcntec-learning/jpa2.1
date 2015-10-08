package houseware.learn.jpa21.criteria.test;

import houseware.learn.jpa21.criteria.Company;
import houseware.learn.jpa21.criteria.Employee;
import houseware.learn.jpa21.criteria.Employee_;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class MultiselectionWithTupleTest extends AbstractTest {


    @Test
    public void tuple_simple() {

        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);

        Root<Employee> from = query.from(Employee.class);
        query.select(builder.tuple(from.get(Employee_.id), from.get(Employee_.age)));

        List<Tuple> list = entityManager.createQuery(query).getResultList();

        assertAndShowTuple(8, list);

    }

    @Test
    public void tuple_entity() {

        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);

        Root<Employee> from = query.from(Employee.class);
        query.select(builder.tuple(from.get(Employee_.id), from));

        List<Tuple> list = entityManager.createQuery(query).getResultList();

        assertAndShowTuple(8, list);

    }


    @Test
    public void avg_by_company() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = builder.createQuery(Tuple.class);
        Root<Employee> from = query.from(Employee.class);
        Join<Employee, Company> join = from.join(Employee_.company, JoinType.LEFT);


        Expression avg = builder.avg(from.get(Employee_.age));
        query.select(builder.tuple(join, avg, avg));
        query.groupBy(join);
        List<Tuple> avgs = entityManager.createQuery(query).getResultList();
        assertAndShowTuple(4, avgs);

    }


}
