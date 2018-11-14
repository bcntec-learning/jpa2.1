package bcntec.learning.jpa21.entityEventListener.oldskool;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Slf4j
@Named
public class OldskoolController {
    @PersistenceContext
    EntityManager entityManager;


    //  ejb way  @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Oldskool merge(Oldskool data) {
        return entityManager.merge(data);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void persist(Oldskool data) {
        entityManager.persist(data);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void remove(Oldskool data) {
        entityManager.remove(data);
    }


    public void console(String event, Oldskool data) {
        log.info(event + " on " + data);
    }
}
