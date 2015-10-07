package houseware.learn.jpa21.criteria.framework;

import javax.persistence.EntityManager;

/**
 * @author fphilip@houseware.es
 */
public class TemplateDAO<E,K> extends AbstractDAO<E,K> {

    public TemplateDAO(Class<E> entityClass, Class<K> keyClass, EntityManager entityManager) {
        super(entityClass, keyClass, entityManager);
    }
}
