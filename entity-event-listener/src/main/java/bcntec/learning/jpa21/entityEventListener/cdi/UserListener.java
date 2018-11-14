package bcntec.learning.jpa21.entityEventListener.cdi;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.persistence.PostPersist;

@Slf4j
public class UserListener {
    @Resource
    ManagedExecutorService managedExecutorService;

// todo, no funciona en todos los escenarios   @Inject
//    Instance<UserWelcomeTask> userWelcomeTaskInstance;
//todo es un WA
    @EJB
    UserWelcomeEJB controller2;

    @PostPersist
    public void postPersist(User user) {
        log.info("postPersist(): " + user.getId());
        UserWelcomeTask task = controller2.getUserWelcomeTaskInstance().get();
        task.setUser(user);
        this.managedExecutorService.submit(task);

    }

}
