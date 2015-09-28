package houseware.learn.jpa21.namedEntityGraph.test;

import houseware.learn.jpa21.namedEntityGraph.Order;
import houseware.learn.jpa21.namedEntityGraph.OrderItem;
import houseware.learn.jpa21.namedEntityGraph.Product;
import lombok.extern.slf4j.Slf4j;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author fphilip@houseware.es
 */
@RunWith(Arquillian.class)
@Slf4j
public class TestNamedGraph {

    @PersistenceContext
    private EntityManager em;

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive j = ShrinkWrap
                .create(JavaArchive.class)
                .addClasses(Order.class, OrderItem.class, Product.class)
                .addAsManifestResource("META-INF/persistence.xml",
                        "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsManifestResource("META-INF/orm.xml",
                        "orm.xml");
        log.info(j.toString(true));
        return j;
    }
}




