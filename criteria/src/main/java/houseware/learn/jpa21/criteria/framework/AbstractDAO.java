package houseware.learn.jpa21.criteria.framework;


import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class AbstractDAO<E, K> {

    Class<E> entityClass;
    Class<K> keyClass;

    EntityManager entityManager;

    public AbstractDAO(Class<E> entityClass, Class<K> keyClass, EntityManager entityManager) {
        this.entityClass = entityClass;
        this.keyClass = keyClass;
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    public EntityManager em(){
        return entityManager;
    }

    public CriteriaBuilder getCriteriaBuilder(){
         return entityManager.getCriteriaBuilder();
    }

    public CriteriaBuilder cb(){
        return getCriteriaBuilder();
    }


    public CriteriaQuery<E> createCriteriaQuery(){
         return getCriteriaBuilder().createQuery(entityClass);
    }


    public List<E> getResultList(CriteriaQuery<E> criteriaQuery) {
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }

    public E getSingleResult(CriteriaQuery<E> criteriaQuery) {
        return getEntityManager().createQuery(criteriaQuery).getSingleResult();
    }






    public E findById(K key){
        return getEntityManager().find(entityClass, key);
    }

    public List<E> all() {
        CriteriaQuery<E> q = getCriteriaBuilder().createQuery(entityClass);
        return getResultList(q);
    }

}
