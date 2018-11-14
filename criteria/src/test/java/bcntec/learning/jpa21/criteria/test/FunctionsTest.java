package bcntec.learning.jpa21.criteria.test;

import bcntec.learning.jpa21.criteria.Country;
import bcntec.learning.jpa21.criteria.Country_;
import bcntec.learning.jpa21.criteria.Employee;
import bcntec.learning.jpa21.criteria.Employee_;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author francisco.philip@gmail.com
 */
public class FunctionsTest extends AbstractTest {

    @Test
    public void diff() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(root);

        query.where(
                builder.lessThan(
                        builder.diff(root.get(Employee_.age), 10), 10)
        );

        List<Employee> employees = entityManager.createQuery(query).getResultList();
        assertAndShow(4, employees);

    }


    @Test
    public void length() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        query.where(
                builder.greaterThan(
                        builder.length(root.get(Country_.name)), 10)
        );
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(9, countries);

    }

    @Test
    public void between() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        query.where(
                builder.between(
                        builder.length(root.get(Country_.name)), 5, 10)
        );
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(10, countries);

    }

    @Test
    public void isNull() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        query.where(
                builder.isNull(root.get(Country_.name))
        );
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(0, countries);

    }

    @Test
    public void isNotNull() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root);
        query.where(
                builder.isNotNull(root.get(Country_.name))
        );
        List<Country> countries = entityManager.createQuery(query).getResultList();
        assertAndShow(19, countries);

    }

    @Test
    public void min() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(builder.min(root.get(Employee_.age)));
        int min = entityManager.createQuery(query).getSingleResult();
        assertEquals(3, min);

    }
    @Test
    public void max() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integer> query = builder.createQuery(Integer.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(builder.max(root.get(Employee_.age)));
        int min = entityManager.createQuery(query).getSingleResult();
        assertEquals(70, min);

    }

    @Test
    public void avg() {
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Double> query = builder.createQuery(Double.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(builder.avg(root.get(Employee_.age)));
        Double min = entityManager.createQuery(query).getSingleResult();
        assertEquals(new Double(35.625), min);

    }


}
