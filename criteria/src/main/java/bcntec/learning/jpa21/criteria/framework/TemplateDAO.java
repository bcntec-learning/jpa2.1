package bcntec.learning.jpa21.criteria.framework;

import javax.persistence.EntityManager;

/**
 * @author francisco.philip@gmail.com
 */
public class TemplateDAO<E,K> extends AbstractDAO<E,K> {

    public TemplateDAO(Class<E> entityClass, Class<K> keyClass, EntityManager entityManager) {
        super(entityClass, keyClass, entityManager);
    }
}
