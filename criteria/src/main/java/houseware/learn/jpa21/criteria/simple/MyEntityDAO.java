package houseware.learn.jpa21.criteria.simple;

import houseware.learn.jpa21.criteria.simple.MyEntity_;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
public class MyEntityDAO {
    @Getter
//    @Inject
    EntityManager entityManager;

    public MyEntity findById(Integer id) {

        return entityManager.find(MyEntity.class, id);
    }

    public List<MyEntity> listByName(String like) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MyEntity> cq = cb.createQuery(MyEntity.class);
        Root<MyEntity> root = cq.from(MyEntity.class);
        cq.select(root);
        cq.where(cb.like(
                root.get(MyEntity_.name)
                , like));
        return entityManager.createQuery(cq).getResultList();
    }
}
