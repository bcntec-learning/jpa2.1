package bcntec.learning.jpa21.unsynchronizedPersistenceContext.test;

import bcntec.learning.jpa21.unsynchronizedPersistenceContext.Child;
import bcntec.learning.jpa21.unsynchronizedPersistenceContext.Controller;
import bcntec.learning.jpa21.unsynchronizedPersistenceContext.Parent;
import lombok.extern.slf4j.Slf4j;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author francisco.philip@gmail.com
 */
@Slf4j
@RunWith(Arquillian.class)
public  class UnsynchronizedPeristenceContextTest {
    @EJB
    Controller controller;

    @PersistenceContext
    EntityManager entityManager;

    @Deployment
    public static JavaArchive createTestArchive() {

        JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
                .addClasses(Parent.class, Child.class, Controller.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsResource("import.sql")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        log.info(archive.toString(true));
        return archive;
    }

    @Test
    @InSequence(0)
    public void create_parent() {
        controller.parentAdd("one");
        controller.parentAdd("two");
        controller.parentAdd("three");

        Assert.assertNotNull(controller.parentFind("one"));

        Assert.assertEquals("P.A ",0, controller.parentList().size());
        Assert.assertEquals("P.B ", 0, entityManager.createQuery("from Parent").getResultList().size());
        controller.myCommit();
        Assert.assertEquals("P.C ", 3, entityManager.createQuery("from Parent").getResultList().size());
    }

    @Test
    @InSequence(1)
    public void add_child() {

        Assert.assertNotNull(controller.childAdd("one", "one.one"));

        Assert.assertEquals("added second child",2,controller.childAdd("one", "one.two").getChilds().size());

        Assert.assertEquals("C.A", 0, entityManager.find(Parent.class, "one").getChilds().size());
        controller.myCommit();
        Assert.assertEquals("C.B", 2, entityManager.find(Parent.class, "one").getChilds().size());
    }



}
