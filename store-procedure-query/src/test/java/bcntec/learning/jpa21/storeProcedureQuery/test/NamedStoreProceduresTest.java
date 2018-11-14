package bcntec.learning.jpa21.storeProcedureQuery.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.EntityManager;


/**
 * @author francisco.philip@gmail.com
 */

@Slf4j
@SuppressWarnings("unchecked")
public class NamedStoreProceduresTest extends AbstractTest {


    @Test
    public void test_simple_call() {

        EntityManager entityManager = factory.createEntityManager();
        entityManager.createNamedStoredProcedureQuery("MessageSendProcedure")
                .setParameter("message", "this is my 'test_simple_call' message")
                .setParameter("message_type", "INFO")
                .setParameter("sender", "fphilip")
                .execute();
        entityManager.close();
    }


    @Test
    public void test_resultset_call() {

        EntityManager entityManager = factory.createEntityManager();
        entityManager.createNamedStoredProcedureQuery("MessageSendAndShowProcedure")
                .setParameter("message", "this is my 'test_simple_call' message")
                .setParameter("message_type", "INFO")
                .setParameter("sender", "fphilip")
                .getResultList();

        entityManager.close();
    }


}
