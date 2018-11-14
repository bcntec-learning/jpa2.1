package bcntec.learning.jpa21.persistenceUnit.test;

import bcntec.learning.jpa21.persistenceUnit.Club;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author francisco.philip@gmail.com
 */
@Slf4j
@RunWith(Arquillian.class)
public class JEEContainerTest {

    @Deployment
    public static WebArchive createTestArchive() {

        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addPackage("bcntec.learning.learn.jpa21.persistenceUnit")
                .addAsWebInfResource("openjpa-jee-persistence.xml", "persistence.xml")
                .addAsResource("import.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml") ;

        log.info(archive.toString(true));
        return archive;
    }

    @Getter
    @PersistenceContext
    protected EntityManager entityManager;

    @Test
    public void container(){


        for (Club club : entityManager.createQuery("select object(c) from Club c order by c.league", Club.class).getResultList()) {
            log.info(club.getName());
        }

    }
}
