package houseware.learn.jpa21.attributeConverter.test;

import com.vividsolutions.jts.geom.Geometry;
import houseware.learn.jpa21.attributeConverter.GIS;
import houseware.learn.jpa21.attributeConverter.User;
import org.geotools.geojson.geom.GeometryJSON;
import org.junit.Assert;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.UUID;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class AttributeConverterGISTest {


    @Test
    public void encoded_openlayers_converter_test() throws IOException {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:attribute-converter");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        GIS gis = new GIS();
        gis.setEntry(UUID.randomUUID().toString());
        Geometry c = new GeometryJSON().read(
                getClass().getResourceAsStream("/openlayers.json"));
        gis.setGeometry(c);
        entityManager.persist(gis);
        entityManager.flush();
        transaction.commit();


    }

    @Test
    public void encoded_osmbuilding_converter_test() throws IOException {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:attribute-converter");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        GIS gis = new GIS();
        gis.setEntry(UUID.randomUUID().toString());
        Geometry c = new GeometryJSON().read(
                getClass().getResourceAsStream("/osmbuilding.json"));
        gis.setGeometry(c);
        entityManager.persist(gis);
        entityManager.flush();
        transaction.commit();


    }

    @Test
    public void decoded_converter_test() {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa21:attribute-converter");
        @Cleanup
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        transaction.begin();
        transaction.commit();


    }

}
