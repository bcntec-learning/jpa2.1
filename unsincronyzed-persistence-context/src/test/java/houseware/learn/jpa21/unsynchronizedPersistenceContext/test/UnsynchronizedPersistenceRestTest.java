package houseware.learn.jpa21.unsynchronizedPersistenceContext.test;

import houseware.learn.jpa21.unsynchronizedPersistenceContext.ApplicationRest;
import houseware.learn.jpa21.unsynchronizedPersistenceContext.Child;
import houseware.learn.jpa21.unsynchronizedPersistenceContext.Controller;
import houseware.learn.jpa21.unsynchronizedPersistenceContext.Parent;
import lombok.extern.slf4j.Slf4j;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
@RunWith(Arquillian.class)
public class UnsynchronizedPersistenceRestTest {

    private static WebTarget target;


    @PersistenceContext
    EntityManager entityManager;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class).
                addClasses(Parent.class, Child.class, Controller.class, ApplicationRest.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsResource("import.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        log.info(war.toString(true));

        return war;
    }

    @ArquillianResource
    private URL base;

    @Before
    public void setupClass() throws MalformedURLException {
        Client client = ClientBuilder.newClient();
        target = client.target(URI.create(new URL(base, "unsynchornized/rest").toExternalForm()));
    }

    /**
     */
    @Test
    public void test1Post() {
        String r =  target.path("parent/list").request().get(String.class);
        assertEquals("[apple]", r);
    }
}
