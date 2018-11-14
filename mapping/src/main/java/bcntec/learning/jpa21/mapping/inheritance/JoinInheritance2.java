package bcntec.learning.jpa21.mapping.inheritance;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class JoinInheritance2 extends JoinInheritance {
    private String joinData2;
}
