package houseware.learn.jpa21.equalsHashcode.test;

import houseware.learn.jpa21.equalsHashcode.Child;
import houseware.learn.jpa21.equalsHashcode.Parent;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author fphilip@houseware.es
 */
public class NoEqualsHashcodeTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap
                .create(JavaArchive.class)
                .addClasses(Child.class, Parent.class)
                .addAsManifestResource("META-INF/persistence.xml",
                        "no-equals-hashcode.persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
}
