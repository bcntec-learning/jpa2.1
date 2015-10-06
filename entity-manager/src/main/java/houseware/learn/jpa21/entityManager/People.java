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
public class People {

    @Id
    private Integer id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;
}
