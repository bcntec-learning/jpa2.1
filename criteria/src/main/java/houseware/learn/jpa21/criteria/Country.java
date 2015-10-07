package houseware.learn.jpa21.criteria;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

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
@ToString
public class Country {
    @Id
    private String id;
    @Column
    private String name;

}
