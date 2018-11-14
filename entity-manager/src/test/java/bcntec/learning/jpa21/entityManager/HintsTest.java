package bcntec.learning.jpa21.entityManager;

import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

/**
 * @author francisco.philip@gmail.com
 */
@Slf4j
public class HintsTest  extends AbstractTest{

    static EntityManagerFactory emf;

    @BeforeClass
    public static void createTestData() {
        Map<String,String> m = new HashMap<>();
        m.put("hibernate.show", "false");
        emf = Persistence.createEntityManagerFactory("jpa21:entity-manager",m);

        EntityManager em = emf.createEntityManager();
        for (int i = 0; i < 10000; i++) {
            em.persist(new Trace(i,String.format("K%07d", i)));
        }
        em.close();
    }

    @Test
    public void testHint1() {

        EntityManager em = emf.createEntityManager();
        Query t = em.createQuery("select object(e) from Trace e");
        t.setHint("org.hibernate.fetchSize", new Integer(50));
        int s = t.getResultList().size();

    }
}
