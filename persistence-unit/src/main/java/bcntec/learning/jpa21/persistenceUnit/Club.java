package bcntec.learning.jpa21.persistenceUnit;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author francisco.philip@gmail.com
 */
@Data
@Entity
public class Club {
    @Id
    @Column
    private String id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    private League league;

}
