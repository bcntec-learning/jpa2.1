package houseware.learn.jpa21.criteria.simple;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Getter
@Setter
public class MyEntity {
    @Id
    private Integer id;
    @Column
    private String name;

}
