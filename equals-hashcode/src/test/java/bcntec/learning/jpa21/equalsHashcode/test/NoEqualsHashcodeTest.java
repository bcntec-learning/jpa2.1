package bcntec.learning.jpa21.equalsHashcode.test;

import bcntec.learning.jpa21.equalsHashcode.Child;
import bcntec.learning.jpa21.equalsHashcode.Parent;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author francisco.philip@gmail.com
 */
@Slf4j
public class NoEqualsHashcodeTest {


    @Test(expected = PersistenceException.class)
    public void test_2() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:no-equals-hashcode");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();
        Parent parent = new Parent();
        parent.setName("parent.2");
        parent.getChilds().add(new Child("child.1", parent));
        parent.getChilds().add(new Child("child.2", parent));
        parent.getChilds().add(new Child("child.3", parent));
        parent.getChilds().add(new Child("child.1", parent));
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(parent);
        entityManager.flush();
        transaction.commit();

        transaction.begin();
        List<Parent> parents = list(entityManager);
        Assert.assertEquals("childs", 3,
                parents.get(0).getChilds().size());
        transaction.commit();

    }


    public List<Parent> list(EntityManager entityManager) {
        CriteriaQuery<Parent> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Parent.class);
        Root<Parent> from = criteriaQuery.from(Parent.class);
        CriteriaQuery<Parent> select = criteriaQuery.select(from);
        List<Parent> list = entityManager.createQuery(criteriaQuery).getResultList();
        for (Parent p : list) {
            System.err.println("p?" + p);
        }
        return list;
    }
}
