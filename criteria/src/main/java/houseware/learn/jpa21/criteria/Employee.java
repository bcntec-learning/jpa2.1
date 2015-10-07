package houseware.learn.jpa21.criteria;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Setter
@Getter
public class Employee {
    @Id
    private String id;
    @Column
    private String name;
}
