package houseware.learn.jpa21.entityEventListener.simple;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
 */
@Data
@Slf4j
@Entity
public class Simple {
    @Id
    @GeneratedValue
    private long id;
    private String data;


    @PrePersist
    public void prePersist() {
        log.info("PrePersist {}", this);
    }

    @PostPersist
    public void postPersist() {
        log.info("PostPersist {} ", this);
    }

    @PreUpdate
    public void preUpdate() {
        log.info("PreUpdate {}", this);
    }

    @PostUpdate
    public void postUpdate() {
        log.info("PostUpdate {}", this);
    }


    @PostLoad
    public void postLoad() {
        log.info("PostLoad {}", this);
    }

    @PreRemove
    public void preRemove() {
        log.info("PreRemove {}", this);
    }

    @PostRemove
    public void postRemove() {
        log.info("PostRemove {}", this);
    }
}
