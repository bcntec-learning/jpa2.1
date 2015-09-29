package houseware.learn.jpa21.namedQueries;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
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
