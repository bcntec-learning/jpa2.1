package bcntec.learning.jpa21.entityEventListener.inherit;

/**
 * @author francisco.philip@gmail.com
 */

import lombok.Data;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
@EntityListeners(AbstracttListener.class)
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private long id;
    private String data;
}
