package bcntec.learning.jpa21.mapping.secondaryTable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Table(name = "USERS")
public class User {

    @Getter
    @Setter
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Getter
    @Setter
    @Column(name = "USERNAME")
    private String userName;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name= "ID", referencedColumnName = "USER_ID")
    private UserExt ext;


}
