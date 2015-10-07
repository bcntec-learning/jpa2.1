package houseware.learn.jpa21.criteria;

import houseware.learn.jpa21.criteria.framework.AbstractDAO;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class CountryDAO extends AbstractDAO<Country, String> {


    public CountryDAO(EntityManager entityManager) {
        super(Country.class, String.class, entityManager);
    }

    public List<Country> listByName(String name) {
        CriteriaQuery<Country> query = createCriteriaQuery();
        Root<Country> root = query.from(Country.class);
        query.select(root);
        query.where(
                getCriteriaBuilder().like(root.get(Country_.name), name));
        return getResultList(query);

    }
}
