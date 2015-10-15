package houseware.learn.jpa21.mapping.polymorphic;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)  // this strategy will be ignored
public class PedigreeDog extends Dog {
    private String credit;


}
