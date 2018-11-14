package bcntec.learning.jpa21.entityManager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author francisco.philip@gmail.com
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
