package houseware.learn.jpa21.persistenceUnit.test;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
@RunWith(Arquillian.class)
public class EJBContainerTest {

    @Deployment
    public static JavaArchive createTestArchive() {

        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addPackage("houseware.learn.jpa21.persistenceUnit")
                .addAsResource("persistence.xml")
                ;

        log.info(archive.toString(true));
        return archive;
    }

    @Getter
    @PersistenceContext
    protected EntityManager entityManager;
}
