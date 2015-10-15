package houseware.learn.jpa21.mapping.inheritance;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class JoinInheritance2 extends JoinInheritance {
    private String joinData2;
}
