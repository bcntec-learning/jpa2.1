package bcntec.learning.jpa21.entityManager;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Getter
@Setter
public class Country {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private Boolean enabled;
    @Version
    private Integer version =0;

}
