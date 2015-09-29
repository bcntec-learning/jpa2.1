package houseware.learn.jpa21.mapping.secondaryTable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Table(name = "USER_EXTS")
public class UserExt {

    @Getter
    @Setter
    @Id
    @Column(name = "USER_ID")
    private Long id;

    @Getter
    @Setter
    @Column(name = "FACEBOOK_ACCOUNT")
    private String facebook;
    @Getter
    @Setter
    @Column(name = "TWITTER_ACCOUNT")
    private String twitter;



}
