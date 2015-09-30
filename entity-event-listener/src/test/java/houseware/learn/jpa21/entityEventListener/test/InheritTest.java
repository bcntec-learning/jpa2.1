package houseware.learn.jpa21.entityEventListener.test;

import org.junit.Test;

/**
 * @author fphilip@houseware.es
 */
public class InheritTest extends AbstractTest {

    @Test
    public void persist() {
        doCase((entityManager, tx) -> {


        });


    }


    @Test
    public void remove() {
        doCase((entityManager, tx) -> {


        });


    }


    private void doCase(DoIt doIt) {

        doCase("jpa21:inherit-event-listener", doIt);
    }


}
