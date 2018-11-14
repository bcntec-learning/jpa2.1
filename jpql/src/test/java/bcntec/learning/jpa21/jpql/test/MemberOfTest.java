package bcntec.learning.jpa21.jpql.test;

import bcntec.learning.jpa21.jpql.Message;
import bcntec.learning.jpa21.jpql.MessageTag;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.List;


/**
 * @author francisco.philip@gmail.com
 */

@Slf4j
public class MemberOfTest extends AbstractTest {


    @Test
    public void test_member_of() {

        EntityManager entityManager = factory.createEntityManager();

        MessageTag jee = entityManager.find(MessageTag.class, "JEE");


        List<Message> messages = entityManager.createNamedQuery("Message.text_and_member_of", Message.class)
                .setParameter("message", "%useful%")
                .setParameter("tag", jee)
                .getResultList();

        assertEquals(2, messages.size());
        log.info(messages.size() + " message(s) found");

        for (Message m : messages) {
            log.info(m.getUser().getUserName() + ", write a  " + m.getMessageType().getType()
                    + " with tag :" + jee.getDescription() + "\n >>>>>>>" + m.getText());
        }


    }


}
