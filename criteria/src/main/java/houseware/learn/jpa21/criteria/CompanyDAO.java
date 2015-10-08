package houseware.learn.jpa21.criteria;

import houseware.learn.jpa21.criteria.framework.AbstractDAO;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
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

    public List<Company> listByCountry(Country country) {
        CriteriaQuery<Company> query = createCriteriaQuery();
        Root<Company> root = query.from(Company.class);
        query.select(root);
        query.where(
                getCriteriaBuilder().equal(root.get(Company_.country), country));
        return getResultList(query);

    }
    public List<Company> listByCountryName(String country) {
        CriteriaQuery<Company> query = createCriteriaQuery();
        Root<Company> root = query.from(Company.class);
        Join<Company, Country>  jc = root.join(Company_.country) ;
        query.select(root);
        query.where(
                getCriteriaBuilder().like(jc.get(Country_.name), country));
        return getResultList(query);

    }

    public long totalCompaniesByCountry(Country country) {
        CriteriaQuery<Long> query  =  cb().createQuery(Long.class);

        Root<Company> root = query.from(Company.class);

        query.select(cb().count(root.get(Company_.id)));

        query.where(
                getCriteriaBuilder().equal(root.get(Company_.country), country));
        return em().createQuery(query).getSingleResult();
    }



    public long totalCompaniesByCountryById(String id) {
        CriteriaQuery<Long> query  =  cb().createQuery(Long.class);

        Root<Company> root = query.from(Company.class);
        Join<Company, Country>  jc = root.join(Company_.country);

        query.select(cb().count(root.get(Company_.id)));

        query.where(
                getCriteriaBuilder().equal(jc.get(Country_.id), id));
        return em().createQuery(query).getSingleResult();
    }
}
