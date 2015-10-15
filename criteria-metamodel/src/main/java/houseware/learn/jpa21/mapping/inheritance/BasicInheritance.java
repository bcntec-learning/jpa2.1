package houseware.learn.jpa21.mapping.inheritance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author fphilip@houseware.es
 */
@Getter
@Setter
@Entity
public class BasicInheritance extends AbstractInheritance {
    private String basicData;
}
