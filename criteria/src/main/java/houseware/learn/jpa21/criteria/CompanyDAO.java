package houseware.learn.jpa21.criteria;

import houseware.learn.jpa21.criteria.framework.AbstractDAO;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class CompanyDAO extends AbstractDAO<Company, String> {


    public CompanyDAO(EntityManager entityManager) {
        super(Company.class, String.class, entityManager);
    }

    public List<Company> listByName(String name) {
        CriteriaQuery<Company> query = createCriteriaQuery();
        Root<Company> root = query.from(Company.class);
        query.select(root);
        query.where(
                getCriteriaBuilder().like(root.get(Company_.name), name));
        return getResultList(query);

    }
}
