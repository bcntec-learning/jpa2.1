package bcntec.learning.jpa21.queries;

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
    @Column(name = "USER_ID")
    private Long id;

    @Getter @Setter
    @Column(name = "USERNAME")
    private String userName;


}
