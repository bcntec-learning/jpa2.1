package houseware.learn.jpa21.entityEventListener.simple;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
public class AnnotatedtListener {


    @PrePersist
    public void prePersist(Annotated data) {
        log.info("PrePersist {}", data);
    }

    @PostPersist
    public void postPersist(Annotated data) {
        log.info("PostPersist {}", data);
    }

    @PreUpdate
    public void preUpdate(Annotated data) {
        log.info("PreUpdate {}", data);
    }

    @PostUpdate
    public void postUpdate(Annotated data) {
        log.info("PostUpdate {}", data);
    }


    @PostLoad
    public void postLoad(Annotated data) {
        log.info("PostLoad {}", data);
    }

    @PreRemove
    public void preRemove(Annotated data) {
        log.info("PreRemove {}", data);
    }

    @PostRemove
    public void postRemove(Annotated data) {
        log.info("PostRemove {}", data);
    }
}
