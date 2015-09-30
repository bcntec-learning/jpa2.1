package houseware.learn.jpa21.entityEventListener.simple;

import houseware.learn.jpa21.entityEventListener.oldskool.Oldskool;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
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
