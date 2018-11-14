package bcntec.learning.jpa21.attributeConverter.test;

import bcntec.learning.jpa21.attributeConverter.User;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;

/**
 * @author francisco.philip@gmail.com
 */
@Slf4j
public class AttributeConverterImageTest {


    @Test
    public void encoded_converter_test() throws IOException, ParseException {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:attribute-converter");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        User user = new User();
        user.setUsername("newduke");
        user.setFirstName("Java");
        user.setLastName("Duke");
        user.setPassword("rockstar");
        user.setIcon(ImageIO.read(getClass().getResourceAsStream("/java-duke-image.jpg")));
        entityManager.persist(user);
        entityManager.flush();
        transaction.commit();

        Object o = entityManager.createNativeQuery("select ICON from USER where USERNAME='newduke'").getSingleResult();

        Assert.assertNotNull("invalid crypto convertion",o);

        JSONObject file = (JSONObject)new JSONParser().parse( IOUtils.toString(getClass().getResourceAsStream("/jduke.json")));
        JSONObject db = (JSONObject)new JSONParser().parse( (String)o);

        Assert.assertEquals("invalid crypto convertion", file.get("image"), db.get("image"));

    }

    @Test
    public void decoded_converter_test() {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:attribute-converter");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();

        User user = entityManager.find(User.class, "jduke");
        Assert.assertNotNull("invalid decode",  user.getIcon());
        Assert.assertNotNull("invalid decode", user.getIcon().getHeight());


    }
}
