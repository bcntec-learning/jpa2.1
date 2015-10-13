package houseware.learn.jpa21.storeProcedureQuery.test;

import org.junit.AfterClass;
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

        factory = Persistence.createEntityManagerFactory("jpa21:store-procedure-query");

    }
    @AfterClass
    public static void close(){
        factory.close();
    }


}
