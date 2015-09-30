package houseware.learn.jpa21.entityEventListener.oldskool;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.*;

@Slf4j
public class OldskoolListener {


    @PrePersist
    public void prePersist(Oldskool data) {
        getBeanByName(OldskoolController.class).console("PrePersist", data);
    }

    @PostPersist
    public void postPersist(Oldskool data) {
        getBeanByName(OldskoolController.class).console("PostPersist", data);
    }

    @PreUpdate
    public void preUpdate(Oldskool data) {
        getBeanByName(OldskoolController.class).console("PreUpdate", data);
    }

    @PostUpdate
    public void postUpdate(Oldskool data) {
        getBeanByName(OldskoolController.class).console("PostUpdate", data);
    }


    @PostLoad
    public void postLoad(Oldskool data) {
        getBeanByName(OldskoolController.class).console("PostLoad", data);
    }

    @PreRemove
    public void preRemove(Oldskool data) {
        getBeanByName(OldskoolController.class).console("PreRemove", data);
    }

    @PostRemove
    public void postRemove(Oldskool data) {
        getBeanByName(OldskoolController.class).console("PostRemove", data);
    }

    //    old skool
    public static BeanManager getBeanManager() {
        try {
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:comp/BeanManager");
        } catch (NamingException e) {
            log.error("accesing bean manager", e);
            return null;
        }
    }

    public <T> T getBeanByName(Class<T> clazz) {
        BeanManager bm = getBeanManager();
        Bean bean = bm.getBeans(clazz).iterator().next();
        CreationalContext ctx = bm.createCreationalContext(bean);
        return (T) bm.getReference(bean, bean.getClass(), ctx);
    }
}
