package houseware.learn.jpa21.entityManager;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
public class HibernateFlushOperationsTest  extends AbstractTest{
    @Test
    public void simple_case() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa21:entity-manager");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        assortedEnities(em);


        log.info("commited, see sql executed");
        tx.commit();
        em.close();

    }


    @Test
    public void flush_commit_case_with_query() {
        _case_with_query(FlushModeType.COMMIT);
    }
    
    @Test
    public void flush_auto_case_with_query() {
        _case_with_query(FlushModeType.AUTO);
    }


    @Test
    public void flush_commit_case_with_find() {
        _case_with_find(FlushModeType.COMMIT);
    }
    
    @Test
    public void flush_auto_case_with_find() {
        _case_with_find(FlushModeType.AUTO);
    }


    @Test
    public void flush_commit_case_with_find_notfound() {
        _case_with_find_notfound(FlushModeType.COMMIT);
    }

    @Test
    public void flush_auto_case_with_find_notfound() {
        _case_with_find_notfound(FlushModeType.AUTO);
    }



    private void _case_with_find(FlushModeType mode) {


        EntityManager em = factory.createEntityManager();
        em.setFlushMode(mode);
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        assortedEnities(em);


        log.info("find, see sql executed");
        em.find(Country.class, "EN");

        log.info("commited, see sql executed");
        tx.commit();
        em.close();

    }




    private void _case_with_find_notfound(FlushModeType mode) {


        EntityManager em = factory.createEntityManager();
        em.setFlushMode(mode);
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        assortedEnities(em);


        log.info("find, see sql executed");
        em.find(Country.class, "ZZZZ");

        log.info("commited, see sql executed");
        tx.commit();
        em.close();

    }





  
    private void _case_with_query(FlushModeType mode) {


        EntityManager em = factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        em.setFlushMode(mode);
        tx.begin();

        assortedEnities(em);
        log.info("list, see sql executed");
        em.createQuery("select object(c) from Country c").getResultList();


        log.info("commited, see sql executed");
        tx.commit();
        em.close();

    }








    private void assortedEnities(EntityManager em) {

        Country spain = crearCountry(em, "ES","Spain");
        Country argentine = crearCountry(em,"AR", "Argentine");
        Country france = crearCountry(em,"FR", "France");
        Country england = crearCountry(em,"EN", "England");
        Country italy = crearCountry(em, "IT","Italy");
        Country poland = crearCountry(em, "Po","Poland");

        em.flush();
        log.info("flushed");
        em.remove(france);
        log.info("removing france and no sql shown even");

        england.setEnabled(Boolean.FALSE);
        em.persist(england);
        em.remove(poland);
        italy.setName("ITALY");
        em.persist(italy);

        Country netherlands = crearCountry(em, "NE","Netherlands");
        em.persist(netherlands);
    }

    private static Country crearCountry(EntityManager em, String id, String name) {
        Country country = new Country();
        country.setId(id);
        country.setName(name);
        country.setEnabled(Boolean.TRUE);
        em.persist(country);
        log.info("{} ({}) persisted", country.getName(), country.getId());
        return country;
    }

}
