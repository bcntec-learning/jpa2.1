package houseware.learn.jpa21.criteria;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import javax.persistence.Entity;

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
