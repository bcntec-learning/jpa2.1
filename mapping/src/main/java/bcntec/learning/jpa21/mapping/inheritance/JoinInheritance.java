package bcntec.learning.jpa21.mapping.inheritance;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class JoinInheritance extends AbstractInheritance {
    private String joinData;
}
