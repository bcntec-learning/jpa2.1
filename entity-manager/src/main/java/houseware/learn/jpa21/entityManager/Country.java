package houseware.learn.jpa21.entityManager;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Getter
@Setter
public class Country {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private Boolean enabled;

}
