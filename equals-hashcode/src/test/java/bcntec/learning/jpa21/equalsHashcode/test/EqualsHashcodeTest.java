package bcntec.learning.jpa21.equalsHashcode.test;

import bcntec.learning.jpa21.equalsHashcode.ChildEH;
import bcntec.learning.jpa21.equalsHashcode.ParentEH;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author francisco.philip@gmail.com
 */
@Slf4j
public class EqualsHashcodeTest {


    @Test
    public void test_2() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:equals-hashcode");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();
        ParentEH parent = new ParentEH();
        parent.setName("parent.1");
        parent.getChilds().add(new ChildEH("child.1", parent));
        parent.getChilds().add(new ChildEH("child.2", parent));
        parent.getChilds().add(new ChildEH("child.3", parent));
        parent.getChilds().add(new ChildEH("child.1", parent));

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(parent);
        entityManager.flush();
        transaction.commit();


        transaction.begin();
        List<ParentEH> parents = list(entityManager);
        Assert.assertNotNull(parents);
        Assert.assertEquals("childs",3,
                parents.get(0).getChilds().size());
        transaction.commit();


    }

    public List<ParentEH> list(EntityManager entityManager) {
        CriteriaQuery<ParentEH> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(ParentEH.class);
        Root<ParentEH> from = criteriaQuery.from(ParentEH.class);
        CriteriaQuery<ParentEH> select = criteriaQuery.select(from);
        List<ParentEH> list = entityManager.createQuery(criteriaQuery).getResultList();
        for (ParentEH p : list) {
            System.err.println("p?" + p);
        }
        return list;
    }
}
