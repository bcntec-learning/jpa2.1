package bcntec.learning.jpa21.mapping.inheritance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author francisco.philip@gmail.com
 */
@Getter
@Setter
@Entity
public class BasicInheritance extends AbstractInheritance {
    private String basicData;
}
