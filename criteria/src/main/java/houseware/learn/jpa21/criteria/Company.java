package houseware.learn.jpa21.criteria;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

/**
 * @author fphilip@houseware.es
 */

@Entity
@Setter
@Getter
public class Company {
    @Id
    private String id;
    @Column
    private String name;
    @ManyToOne
    private Country country;
}
