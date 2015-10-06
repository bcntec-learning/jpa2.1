package houseware.learn.jpa21.entityManager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Trace {
    @Id
    private Integer id;
    @Column
    private String data;

}
