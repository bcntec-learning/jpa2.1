package bcntec.learning.jpa21.queries.test;

import bcntec.learning.jpa21.queries.Message;
import bcntec.learning.jpa21.queries.MessageTag;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


/**
 * @author francisco.philip@gmail.com
 */

@Slf4j
public class NamedNativeTest extends AbstractTest {


    @Test
    public void use_named_native_query() {

        EntityManager entityManager = factory.createEntityManager();

        test_message_member(entityManager, "Message_Native.listTextAndMemberOf");

    }



    @Test
    public void create_named_native_query() {
        String query = "select count(m.MESSAGE_ID) from  MESSAGES m  where (m.MESSAGE_TEXT like :message) and ( :tag in ( select t.MESSAGE_TAG_ID from MESSAGE_MESSAGE_TAGS t where m.MESSAGE_ID=t.MESSAGE_ID))";

        EntityManager entityManager = factory.createEntityManager();
        Query nativeQuery = entityManager.createNativeQuery(query, Long.class);
        factory.addNamedQuery("Message_Native.countTextAndMemberOf", nativeQuery);
        MessageTag jee = entityManager.find(MessageTag.class, "SPRING");

        long count = entityManager.createNamedQuery("Message_Native.countTextAndMemberOf", Long.class)
                .setParameter("message", "%useful%")
                .setParameter("tag", jee)
                .getSingleResult();


        assertEquals(1L, count);
    }

    /*
    @Test
    public void clone_named_native_query() {

        EntityManager entityManager = factory.createEntityManager();
        factory.addNamedQuery("CloneOfMessage.listTextAndMemberOf", entityManager.createNamedQuery("Message.listTextAndMemberOf", Message.class));

        test_message_member(entityManager, "CloneOfMessage.listTextAndMemberOf");

    }
    */

    private void test_message_member(EntityManager entityManager, String name) {
        log.info("Test query [" + name + "]");
        MessageTag jee = entityManager.find(MessageTag.class, "JEE");

        List<Message> messages = entityManager.createNamedQuery(name, Message.class)
                .setParameter("message", "%useful%")
                .setParameter("tag", jee)
                .getResultList();


        log.info(messages.size() + " message(s) found with tag [" + jee.getDescription() + "]");
        show_messages(messages, 2);
    }


    private void show_messages(List<Message> messages, int expected) {
        assertEquals(2, messages.size());

        for (Message m : messages) {
            log.info(m.getUser().getUserName() + ", write a  " + m.getMessageType().getType()
                    + "\n >>>>>>>" + m.getText());
        }

    }

}
