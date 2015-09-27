package houseware.learn.jpa21.equalsHashcode.test;

import houseware.learn.jpa21.equalsHashcode.Child;
import houseware.learn.jpa21.equalsHashcode.Parent;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author fphilip@houseware.es
 */
@RunWith(Arquillian.class)
public class NoEqualsHashcodeTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap
                .create(JavaArchive.class)
                .addClasses(Child.class, Parent.class)
                .addAsManifestResource("equals-hashcode.persistence.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
//   	@ShouldMatchDataSet(value = "data/cc.yml", excludeColumns = "id")
    public void test_2() {
    }

    @Test
    @UsingDataSet("data/parent-child.yml")
    public void test_1() {
    }
}
