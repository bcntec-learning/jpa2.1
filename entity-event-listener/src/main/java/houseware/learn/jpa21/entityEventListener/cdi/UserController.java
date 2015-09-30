package houseware.learn.jpa21.entityEventListener.cdi;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Named
public class UserController {
    @PersistenceContext
    EntityManager entityManager;


//  ejb way  @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public User persist(User user) {
        return entityManager.merge(user);
    }

    public List<User> list() {
        return entityManager.createQuery("from Person", User.class).getResultList();
    }

    public List<UserRegisterLog> listAudits() {
        return entityManager.createQuery("from AuditLog", UserRegisterLog.class).getResultList();
    }

    public void registerLog(UserRegisterLog userRegisterLog) {
        entityManager.persist(userRegisterLog);
    }

    public void sendWelcomeEmail(User user) {
        log.info("sending....");
    }
}
