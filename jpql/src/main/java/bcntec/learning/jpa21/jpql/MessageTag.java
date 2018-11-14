package bcntec.learning.jpa21.jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Table(name = "MESSAGE_TAGS")
public class MessageTag {

    @Getter
    @Setter
    @Id
    @Column(name = "MESSAGE_TAG_ID")
    private String id;

    @Getter @Setter
    @Column(name = "MESSAGE_TAG_DESCRIPTION")
    private String description;


}
