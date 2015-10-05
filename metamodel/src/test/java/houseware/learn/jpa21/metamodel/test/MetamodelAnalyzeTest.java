package houseware.learn.jpa21.metamodel.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class MetamodelAnalyzeTest {


    @Test
    public void simple() {
        analyze("jpa21:simple");
    }

    @Test
    public void collections() {
        analyze("jpa21:collections");
    }

    @Test
    public void relations() {
        analyze("jpa21:relations");
    }

    @Test
    public void secondary_table() {
        analyze("jpa21:secondary-table");
    }

    @Test
    public void inheritance() {
        analyze("jpa21:inheritance");
    }


    @Test
    public void polymorphic() {
        analyze("jpa21:polymorphic");
    }


    private void analyze(String pu) {
        Map<String, String> opts = new HashMap<>();
        opts.put("hibernate.hbm2ddl.auto", "none");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(pu, opts);
        EntityManager entityManager = factory.createEntityManager();
        Metamodel metamodel = entityManager.getMetamodel();

        log.info("Entities");
        metamodel.getEntities().stream().forEach
//                (System.out::println);
                (e -> {
                    ManagedType<?> m = metamodel.managedType(e.getJavaType());


                    log.info("  Entity :" +
                            e.getName() + " (" + m.getJavaType() + ")");
                    m.getAttributes().stream().forEach((a -> {
                        log.info("    " + a.getName() + " (type=" + a.getJavaType() + " /asociation=" + a.isAssociation()
                                + " /colllection=" + a.isCollection() + " /JPA Type=" + a.getPersistentAttributeType().name());
                        if (a.isAssociation()) {
                            log.info("      associated " + a.getDeclaringType().getJavaType().getSimpleName());
                        }
                    }));
                });

        log.info("Embeddables");
        metamodel.getEmbeddables().stream().forEach
//                (System.out::println);
                (e -> {
                    ManagedType<?> m = metamodel.managedType(e.getJavaType());
                    log.info("  Embeddable : (" + m.getJavaType() + ")");
                    m.getAttributes().stream().forEach((a -> {

                        log.info("    " + a.getName() + " (type=" + a.getJavaType() + " /asociation=" + a.isAssociation()
                                + " /colllection=" + a.isCollection() + " /JPA Type=" + a.getPersistentAttributeType().name());
                        if (a.isAssociation()) {
                            log.info("      " + a.getDeclaringType().getJavaType().getSimpleName());
                        }
                    }));
                });
        log.info("Managed Types");
        metamodel.getManagedTypes().stream().forEach
//                (System.out::println);
                (e -> {
                    ManagedType<?> m = metamodel.managedType(e.getJavaType());
                    log.info("  Managed Type : (" + m.getJavaType() + ")");
                    m.getAttributes().stream().forEach((a -> {

                        log.info("    " + a.getName() + " (type=" + a.getJavaType() + " /asociation=" + a.isAssociation()
                                + " /colllection=" + a.isCollection() + " /JPA Type=" + a.getPersistentAttributeType().name());
                        if (a.isAssociation()) {
                            log.info("      " + a.getDeclaringType().getJavaType().getSimpleName());
                        }
                    }));
                });

    }


}
