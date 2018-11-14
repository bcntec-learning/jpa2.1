package bcntec.learning.jpa21.equalsHashcode.test;

import bcntec.learning.jpa21.equalsHashcode.Child;
import bcntec.learning.jpa21.equalsHashcode.Parent;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import org.jboss.arquillian.persistence.PersistenceTest;
//import org.jboss.arquillian.persistence.UsingDataSet;

/**
 * @author francisco.philip@gmail.com
 */
//@RunWith(Arquillian.class)
//@PersistenceTest
public abstract class NoEqualsHashcodeTest2 {

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
//    @UsingDataSet("data/parent-child.yml")
    public void test_1() {
        Assert.assertNotNull(entityManager);
    }
}
