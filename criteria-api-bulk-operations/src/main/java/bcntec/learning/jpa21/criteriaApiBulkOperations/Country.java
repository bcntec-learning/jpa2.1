package bcntec.learning.jpa21.criteriaApiBulkOperations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author francisco.philip@gmail.com
 */

@Entity
@Table(name = "COUNTRIES")
public class Country {

    @Id
    @Column
    private String id;
    @Column
    private String name;
}
