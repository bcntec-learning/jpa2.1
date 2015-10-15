package houseware.learn.jpa21.storeProcedureQuery.test;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;


/**
 *
 * @author fphilip@houseware.es
 */

@Slf4j
@SuppressWarnings("unchecked")
public class StoreProceduresTest extends AbstractTest {




    @Test
    public void register_simple_call() {

        EntityManager entityManager = factory.createEntityManager();
        entityManager.createStoredProcedureQuery("PROC_SEND_MESSAGE")
                .registerStoredProcedureParameter("message", String.class, ParameterMode.IN)
                .setParameter("message", "this is my 'register_simple_call' message")
                .registerStoredProcedureParameter("message_type", String.class, ParameterMode.IN)
                .setParameter("message_type", "INFO")
                .registerStoredProcedureParameter("sender", String.class, ParameterMode.IN)
                .setParameter("sender","fphilip")
                .execute();

        entityManager.close();
    }

}
