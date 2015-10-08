package houseware.learn.jpa21.criteria.test;

import org.junit.Assert;
import org.junit.BeforeClass;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public abstract class AbstractTest extends Assert {
    static EntityManagerFactory factory;

    @BeforeClass
    public static void preapre() {

        factory = Persistence.createEntityManagerFactory("jpa21:criteria");

    }

    public static void assertAndShow(int expected, List<?> elements) {
        elements.stream().forEach(System.out::println);
        assertEquals(expected, elements.size());

    }

    public static void assertAndShowArray(int expected, List<Object[]> elements) {
        elements.stream().forEach(e -> {
            for (Object o : e) {
                System.out.print(o + " ");
            }
            System.out.println("");
        });
        assertEquals(expected, elements.size());

    }

    public static void assertAndShowTuple(int expected, List<Tuple> elements) {
        elements.stream().forEach(e -> {
            e.getElements().stream().forEach(f -> {
                System.out.print(e.get(f) + " ");
            });
            System.out.println("");
        });
        assertEquals(expected, elements.size());

    }

}
