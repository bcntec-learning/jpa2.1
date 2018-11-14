package bcntec.learning.jpa21.mapping.polymorphic;

import javax.persistence.*;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("DOG")
public class Dog extends Animal {
}
