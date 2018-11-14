package bcntec.learning.jpa21.entityEventListener.simple;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author francisco.philip@gmail.com
 */
@Data
@Slf4j
@Entity
@EntityListeners(value = {AnnotatedtListener.class})
public class Annotated {
    @Id
    @GeneratedValue
    private long id;
    private String data;


}
