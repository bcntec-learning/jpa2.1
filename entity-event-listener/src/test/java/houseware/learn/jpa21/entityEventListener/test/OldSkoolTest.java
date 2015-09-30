package houseware.learn.jpa21.entityEventListener.test;

import houseware.learn.jpa21.entityEventListener.cdi.User;
import houseware.learn.jpa21.entityEventListener.cdi.UserController;
import lombok.extern.slf4j.Slf4j;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * @author fphilip@houseware.es
 */
@SuppressWarnings("unchecked")
@RunWith(Arquillian.class)
@Slf4j
public class OldSkoolTest  {


    @Inject
    private UserController userController;

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive j = ShrinkWrap
                .create(JavaArchive.class)
                .addPackage(User.class.getPackage())
                .addAsManifestResource("persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        log.info(j.toString(true));
        return j;
    }


    @Test
    public void register_me() {

        User p = new User();
        p.setFirstName("Francisco");
        p.setLastName("Philip");
        userController.persist(p);
    }
}
