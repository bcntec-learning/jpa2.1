package houseware.learn.jpa21.queries.test;

import houseware.learn.jpa21.queries.Message;
import houseware.learn.jpa21.queries.MessageTag;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * @author fphilip@houseware.es
 */

@Slf4j
public class NamedTest extends AbstractTest {


    @Test
    public void use_named_query() {

        EntityManager entityManager = factory.createEntityManager();

        test_message_member(entityManager, "Message.listTextAndMemberOf");

    }


    @Test
    public void create_named_query() {
        String query = "select count(m) from Message m where m.text like :message and :tag member of m.messageTags";

        EntityManager entityManager = factory.createEntityManager();
        TypedQuery<Long> typedQuery = entityManager.createQuery(query, Long.class);
        factory.addNamedQuery("Message.countTextAndMemberOf", typedQuery);
        MessageTag jee = entityManager.find(MessageTag.class, "SPRING");
        long count = entityManager.createNamedQuery("Message.countTextAndMemberOf", Long.class)
                .setParameter("message", "%useful%")
                .setParameter("tag", jee)
                .getSingleResult();


        assertEquals(1L, count);
    }

    @Test
    public void clone_named_query() {

        EntityManager entityManager = factory.createEntityManager();
        factory.addNamedQuery("CloneOfMessage.listTextAndMemberOf", entityManager.createNamedQuery("Message.listTextAndMemberOf", Message.class));

        test_message_member(entityManager, "CloneOfMessage.listTextAndMemberOf");

    }

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
