package bcntec.learning.jpa21.criteriaApiBulkOperations.test;

import bcntec.learning.jpa21.criteriaApiBulkOperations.Country;
import bcntec.learning.jpa21.criteriaApiBulkOperations.Price;
import bcntec.learning.jpa21.criteriaApiBulkOperations.Product;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author francisco.philip@gmail.com
 */
@Slf4j
public class CriteriaBulkApiTest {


    @Test
    public void test_update_spain() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:criteria-api-bulk-operations");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        int us = updateByCountry(entityManager, entityManager.find(Country.class, "ES"), new BigDecimal(15));


        transaction.commit();


    }

    @Test
    public void test_update_butifarras() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:criteria-api-bulk-operations");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        transaction.begin();

        int us = updateByProduct(entityManager, entityManager.find(Product.class, "AAA1"), new BigDecimal(25));


        transaction.commit();


    }
    @Test
    public void test_remove_francia() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:criteria-api-bulk-operations");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        transaction.begin();

        int us = deleteByCountry(entityManager, entityManager.find(Country.class, "FR"));


        transaction.commit();


    }

    public int updateByCountry(EntityManager entityManager, Country country, BigDecimal factor) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Price> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Price.class);
        criteriaUpdate.from(Price.class);

        Root<Price> root = criteriaUpdate.getRoot();
        Path<Number> path = root.get("value");
        Expression<Number> value = root.get("value");
        Expression<Number> quot = criteriaBuilder.quot(value, factor);

        criteriaUpdate.set(path, criteriaBuilder.sum(value, quot));


        criteriaUpdate.where(entityManager.getCriteriaBuilder().equal(root.get("country"), country));
        return entityManager.createQuery(criteriaUpdate).executeUpdate();
    }


    public int updateByProduct(EntityManager entityManager, Product product, BigDecimal factor) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Price> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Price.class);
        criteriaUpdate.from(Price.class);

        Root<Price> root = criteriaUpdate.getRoot();
        Path<Number> path = root.get("value");
        Expression<Number> value = root.get("value");
        Expression<Number> quot = criteriaBuilder.quot(value, factor);

        criteriaUpdate.set(path, criteriaBuilder.sum(value, quot));

        criteriaUpdate.where(entityManager.getCriteriaBuilder().equal(root.get("product"), product));
        return entityManager.createQuery(criteriaUpdate).executeUpdate();
    }


    public int deleteByCountry(EntityManager entityManager, Country country) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaDelete<Price> criteriaUpdate = criteriaBuilder.createCriteriaDelete(Price.class);
        criteriaUpdate.from(Price.class);

        Root<Price> root = criteriaUpdate.getRoot();

        criteriaUpdate.where(entityManager.getCriteriaBuilder().equal(root.get("country"), country));
        return entityManager.createQuery(criteriaUpdate).executeUpdate();
    }

    public List<Price> list(EntityManager entityManager, String country) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Price> criteriaQuery = criteriaBuilder.createQuery(Price.class);
        Root<Price> from = criteriaQuery.from(Price.class);
        CriteriaQuery<Price> select = criteriaQuery.select(from);
        List<Price> list = entityManager.createQuery(criteriaQuery).getResultList();
        for (Price p : list) {
            System.err.println("p?" + p);
        }
        return list;
    }
}
