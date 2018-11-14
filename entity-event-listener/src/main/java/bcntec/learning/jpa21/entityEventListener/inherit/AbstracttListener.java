package bcntec.learning.jpa21.entityEventListener.inherit;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * @author francisco.philip@gmail.com
 */
@Slf4j
public class AbstracttListener {


    @PrePersist
    public void prePersist(AbstractEntity data) {
        log.info("PrePersist {}", data);
    }

    @PostPersist
    public void postPersist(AbstractEntity data) {
        log.info("PostPersist {}", data);
    }

    @PreUpdate
    public void preUpdate(AbstractEntity data) {
        log.info("PreUpdate {}", data);
    }

    @PostUpdate
    public void postUpdate(AbstractEntity data) {
        log.info("PostUpdate {}", data);
    }


    @PostLoad
    public void postLoad(AbstractEntity data) {
        log.info("PostLoad {}", data);
    }

    @PreRemove
    public void preRemove(AbstractEntity data) {
        log.info("PreRemove {}", data);
    }

    @PostRemove
    public void postRemove(AbstractEntity data) {
        log.info("PostRemove {}", data);
    }

}
