package bcntec.learning.jpa21.mapping.simple;

import javax.persistence.*;

/**
 * @author francisco.philip@gmail.com
 */
@Entity(name = "Simple")
@Table(name = "SIMPLES", uniqueConstraints = {
        @UniqueConstraint(name = "KEY_INDEX", columnNames = {"KEY", "IDX"})}
)
public class SimpleEntity {
    @Id
    private String id;
    @Basic(fetch = FetchType.LAZY)
    private String lazy;
    @Column(unique = true)
    private String key;
    @Column(name = "IDX")
    private String index;
}
