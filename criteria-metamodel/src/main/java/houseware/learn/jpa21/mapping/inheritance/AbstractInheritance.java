package houseware.learn.jpa21.mapping.inheritance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author fphilip@houseware.es
 */
@Getter
@Setter
@MappedSuperclass
public class AbstractInheritance {
    @Id
    private String id;
    @Version
    private Long version;
    private Date createdAt;
    private Date lastUpdate;

    @PrePersist
    private void prePersist() {
        createdAt = new Date();
    }

    @PreUpdate
    private void preUpdate() {
        lastUpdate = new Date();
    }
}
