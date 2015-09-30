package houseware.learn.jpa21.entityEventListener.simple;

import houseware.learn.jpa21.entityEventListener.oldskool.Oldskool;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
public class AnnotatedtListener {


    @PrePersist
    public void prePersist(Oldskool data) {
        log.info("PrePersist", data);
    }

    @PostPersist
    public void postPersist(Oldskool data) {
        log.info("PostPersist", data);
    }

    @PreUpdate
    public void preUpdate(Oldskool data) {
        log.info("PreUpdate", data);
    }

    @PostUpdate
    public void postUpdate(Oldskool data) {
        log.info("PostUpdate", data);
    }


    @PostLoad
    public void postLoad(Oldskool data) {
        log.info("PostLoad", data);
    }

    @PreRemove
    public void preRemove(Oldskool data) {
        log.info("PreRemove", data);
    }

    @PostRemove
    public void postRemove(Oldskool data) {
        log.info("PostRemove", data);
    }
}
