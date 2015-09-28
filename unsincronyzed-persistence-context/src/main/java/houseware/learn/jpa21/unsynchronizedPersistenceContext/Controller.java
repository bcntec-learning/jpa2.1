package houseware.learn.jpa21.unsynchronizedPersistenceContext;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Stateful
public class Controller implements Serializable {
    @PersistenceContext(type = PersistenceContextType.EXTENDED, synchronization = SynchronizationType.UNSYNCHRONIZED)
    EntityManager entityManager;

    public void myCommit() {
        entityManager.joinTransaction();
    }

    @Remove
    public void remove() {

    }

    public List<Parent> parentList() {
        return entityManager.createQuery("from Parent").getResultList();
    }

    public Parent parentFind(String name) {
        return find(name);
    }

    public Parent parentAdd(String name) {
        try {
            find(name);
            throw new EntityExistsException(name);
        } catch (EntityNotFoundException e) {
            Parent p = new Parent(name);
            entityManager.persist(p);
            return p;
        }

    }

    public Parent parentRemove(String parent) {

        Parent p = find(parent);
        if (p != null) {
            entityManager.remove(p);
            return p;
        }
        throw new EntityNotFoundException(parent);
    }

    public Parent childAdd(String parent, String child) {
        return entityManager.merge(find(parent).addChild(child).getParent());
    }

    public Parent childRemove(String parent, String child) {
        return entityManager.merge(find(parent).removeChild(child));
    }

    private Parent find(String parent) {
        Parent p = entityManager.find(Parent.class, parent);
        if (p != null) {
            return p;
        }
        throw new EntityNotFoundException(parent);
    }
}
