package houseware.learn.jpa21.mapping.polymorphic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
 */
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ANIMAL_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Animal {
    @Id
    private String name;
}
