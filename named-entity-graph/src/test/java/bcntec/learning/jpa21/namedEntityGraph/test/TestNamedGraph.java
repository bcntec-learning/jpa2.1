package bcntec.learning.jpa21.namedEntityGraph.test;

import bcntec.learning.jpa21.namedEntityGraph.Order;
import bcntec.learning.jpa21.namedEntityGraph.OrderItem;
import bcntec.learning.jpa21.namedEntityGraph.Product;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author francisco.philip@gmail.com
 */
@Slf4j
public class TestNamedGraph {


    static EntityManagerFactory factory;

    @BeforeClass
    public static void factoryInit() {

        factory = Persistence.createEntityManagerFactory("jpa21:named-entity-graph");

    }

    @Test  (expected = LazyInitializationException.class)
    public void without_graph() {
        EntityManager entityManager = factory.createEntityManager();

        Order order = entityManager.find(Order.class, 1L);

        entityManager.close();
        Assert.assertEquals(order.getItems().size(), 3);
    }

    @Test
    public void with_graph() {
        EntityManager entityManager = factory.createEntityManager();

        EntityGraph graph = entityManager.getEntityGraph("graph.Order.items");

        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);
        Order order = entityManager.find(Order.class, 1L, hints);

        entityManager.close();
        Assert.assertEquals(order.getItems().size(),3);


    }

    @Test
    public void with_graph_access_product_with_subgraph() {
        EntityManager entityManager = factory.createEntityManager();

        EntityGraph graph = entityManager.getEntityGraph("graph.Order.items.products");

        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);
        Order order = entityManager.find(Order.class, 4L, hints);

        entityManager.close();

        Assert.assertEquals(order.getItems().size(),1);


        OrderItem i = order.getItems().iterator().next();
        Assert.assertEquals("Butifarra",i.getProduct().getName());
    }
    @Test
    public void with_graph_access_product_with_subgraph_dynamic() {
        EntityManager entityManager = factory.createEntityManager();

        EntityGraph graph = entityManager.getEntityGraph("graph.Order.items");
        Subgraph itemGraph = graph.addSubgraph("items");
        itemGraph.addAttributeNodes("product");

        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);
        Order order = entityManager.find(Order.class, 4L, hints);

        entityManager.close();

        Assert.assertEquals(order.getItems().size(),1);


        OrderItem i = order.getItems().iterator().next();
        Assert.assertEquals("Butifarra",i.getProduct().getName());
    }


    @Test  (expected = LazyInitializationException.class)
    public void with_graph_access_product_without_subgraph() {
        EntityManager entityManager = factory.createEntityManager();

        EntityGraph graph = entityManager.getEntityGraph("graph.Order.items");

        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", graph);
        Order order = entityManager.find(Order.class, 4L, hints);

        entityManager.close();

        Assert.assertEquals(order.getItems().size(),1);

        OrderItem i = order.getItems().iterator().next();
        Assert.assertEquals("Butifarra",i.getProduct().getName());


    }

    @Test
    public void create_dynamic_entitygraph() {
        EntityManager entityManager = factory.createEntityManager();

        EntityGraph dynamicGraph = entityManager.createEntityGraph(Product.class);
        dynamicGraph.addAttributeNodes("orderItems");

        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", dynamicGraph);
        Product product = entityManager.find(Product.class, 2L, hints);

        entityManager.close();
        Assert.assertEquals(product.getOrderItems().size(),3);



    }

}




