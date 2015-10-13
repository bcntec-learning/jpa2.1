package houseware.learn.jpa21.jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Table(name = "MESSAGES")
@NamedQueries({
        @NamedQuery(
                name = "Message.text_and_member_of",
                query = "select object(m) from Message m where m.text like :message and :tag member of m.messageTags"
        )
})
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID")
    private Long id;

    @Column(name = "MESSAGE_TEXT")
    private String text;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MESSAGE_TYPE_ID", nullable = false)
    private MessageType messageType;

    @ManyToMany
    @JoinTable(name = "MESSAGE_MESSAGE_TAGS",
            joinColumns = @JoinColumn(name = "MESSAGE_ID"),
            inverseJoinColumns = @JoinColumn(name = "MESSAGE_TAG_ID"))
    private Set<MessageTag> messageTags = new HashSet<MessageTag>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

}
