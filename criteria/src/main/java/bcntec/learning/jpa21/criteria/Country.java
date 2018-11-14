package bcntec.learning.jpa21.criteria;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author francisco.philip@gmail.com
 */

@Entity
@Setter
@Getter
@ToString
public class Country {
    @Id
    private String id;
    @Column
    private String name;


}
