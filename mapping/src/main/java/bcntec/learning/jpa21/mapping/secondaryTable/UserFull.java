package bcntec.learning.jpa21.mapping.secondaryTable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Table(name = "USERS")
@SecondaryTable(name = "USER_EXTS",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "USER_ID", referencedColumnName = "ID")
)
public class UserFull {

    @Getter
    @Setter
    @Id
    @GeneratedValue
    @Column(name = "ID", table = "USERS")
    private Long id;

    @Getter
    @Setter
    @Column(name = "USERNAME", table = "USERS")
    private String userName;

    @Getter
    @Setter
    @Column(name = "FACEBOOK_ACCOUNT", table = "USER_EXTS")
    private String facebook;

    @Getter
    @Setter
    @Column(name = "TWITTER_ACCOUNT", table = "USER_EXTS")
    private String twitter;

}
