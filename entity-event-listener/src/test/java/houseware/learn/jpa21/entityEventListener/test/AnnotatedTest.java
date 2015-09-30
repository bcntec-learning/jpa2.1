package houseware.learn.jpa21.entityEventListener.test;

import houseware.learn.jpa21.entityEventListener.simple.Annotated;
import houseware.learn.jpa21.entityEventListener.simple.Simple;
import org.junit.Test;

/**
 * @author fphilip@houseware.es
 */
public class AnnotatedTest extends AbstractTest {

    @Test
    public void persist() {
        doCase((entityManager, tx) -> {
            Annotated s = new Annotated();
            s.setData("persisting my data");
            entityManager.persist(s);
        });


    }


    @Test
    public void remove() {
        doCase((entityManager, tx) -> {

            Annotated s = entityManager.find(Annotated.class, 1L);
            entityManager.remove(s);
        });


    }


    private void doCase(DoIt doIt) {

        doCase("jpa21:simple-event-listener", doIt);
    }

}
