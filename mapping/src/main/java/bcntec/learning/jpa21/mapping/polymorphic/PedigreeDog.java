package bcntec.learning.jpa21.mapping.polymorphic;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)  // this strategy will be ignored
public class PedigreeDog extends Dog {
    private String credit;


}
