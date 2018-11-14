package bcntec.learning.jpa21.entityEventListener.test;

import bcntec.learning.jpa21.entityEventListener.simple.Annotated;
import org.junit.Test;

/**
 * @author francisco.philip@gmail.com
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

            Annotated s = entityManager.find(Annotated.class, 12L);
            entityManager.remove(s);
        });


    }


    private void doCase(DoIt doIt) {

        doCase("jpa21:simple-event-listener", doIt);
    }

}
