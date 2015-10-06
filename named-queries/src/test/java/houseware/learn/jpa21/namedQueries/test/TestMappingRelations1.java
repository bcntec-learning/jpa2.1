package houseware.learn.jpa21.namedQueries.test;

import houseware.learn.jpa21.namedQueries.domain.Message;
import houseware.learn.jpa21.namedQueries.domain.MessageTag;
import houseware.learn.jpa21.namedQueries.domain.MessageType;
import houseware.learn.jpa21.namedQueries.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.arquillian.persistence.PersistenceTest;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * JEE simple case
 *
 * @author fphilip@houseware.es
 */

@Slf4j
@SuppressWarnings("unchecked")
@RunWith(Arquillian.class)  @PersistenceTest
public class TestMappingRelations1 {

    @PersistenceContext
    private EntityManager entityManager;

    @Deployment
    public static WebArchive createDeployment() {
        WebArchive j = ShrinkWrap
                .create(WebArchive.class)
                .addClasses(Message.class, MessageTag.class, MessageType.class, User.class)
                .addAsWebInfResource("1-persistence.xml",
                        "persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        log.info(j.toString(true));
        return j;
    }

    @Test
    @UsingDataSet("data/my_bizz_case.yml")
    public void my_bizz_case_message_text_named_query() {


//        Message msg1 = crearMessage("Java Persistence API es muy util", PEDRO, 1, jee, jpa);
//        Message msg2 = crearMessage("Realmente crees que es util?", JUAN, 2, jee, jpa);
//        Message msg3 = crearMessage("Encapsula el acceso a datos, reduciendo mucho la cantidad de codigo", PEDRO, 3, jee, jpa);
//        Message msg4 = crearMessage("Ademas, es muy integrable con Spring, realmente es util", LUIS, 1, JPA, SPRING);

        MessageTag jee = entityManager.find(MessageTag.class, "JEE");

        //todo Assert.assertNotNull("'JEE' MessageTag not found", jee);

        List<Message> messages = entityManager.createNamedQuery("Message.text", Message.class)
                .setParameter("message", "%util%")
                .setParameter("tag", jee)
                .getResultList();

        log.info(messages.size() + " message(s) found");

        for (Message m : messages) {
            log.info(m.getUser().getUserName() + ", escribio el mensaje tipo " + m.getMessageType().getType()
                    + ", que cotiene el tag :" + jee.getDescription() + "\n >>>>>>>" + m.getText());
        }


    }


}
