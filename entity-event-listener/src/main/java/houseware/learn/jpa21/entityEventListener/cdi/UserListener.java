package houseware.learn.jpa21.entityEventListener.cdi;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.PostPersist;

@Slf4j
public class UserListener {
    @Resource
    ManagedExecutorService managedExecutorService;

//todo    https://issues.jboss.org/browse/WFLY-2540
//todo    http://stackoverflow.com/questions/32693471/injection-of-ejb-in-entitylistener-via-cdi-fails-jpa-2-1/32710250#32710250
//    @Inject
    Instance<UserWelcomeTask> userWelcomeTaskInstance;


    @PostPersist
    public void postPersist(User user) {
        log.info("postPersist(): " + user.getId());
//        UserWelcomeTask task = userWelcomeTaskInstance.get();
//        task.setUser(user);
//        this.managedExecutorService.submit(task);
    }

//    old skool
    public static BeanManager getBeanManager() {
            try {
                InitialContext initialContext = new InitialContext();
                return (BeanManager) initialContext.lookup("java:comp/BeanManager");
            } catch (NamingException e) {
                log.error("accesing bean manager",e);
                return null;
            }
        }

        public Object getBeanByName(String name) {
            BeanManager bm = getBeanManager();
            Bean bean = bm.getBeans(name).iterator().next();
            CreationalContext ctx = bm.createCreationalContext(bean);
            return bm.getReference(bean, bean.getClass(), ctx);
        }
}
