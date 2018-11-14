package bcntec.learning.jpa21.criteria;

import bcntec.learning.jpa21.criteria.framework.AbstractDAO;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author francisco.philip@gmail.com
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


    public List<Country> listCountriesWithCompanies() {
        CriteriaQuery<Country> query = createCriteriaQuery();
        Root<Company> root = query.from(Company.class);

        Join<Company, Country> jc = root.join(Company_.country, JoinType.LEFT);

        query.select(jc);
        query.groupBy(jc.get(Country_.id));
        query.orderBy(cb().desc(jc.get(Country_.name)));
        return getResultList(query);

    }

}
