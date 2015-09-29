package houseware.learn.jpa21.namedQueries;

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
                name = "Message.text",
                query = "select m from Message m where m.text like :message and :tag member of m.messageTags"
        )
})
public class Message {

    @Getter
    @Setter
    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID")
    private Long id;

    @Getter
    @Setter
    @Column(name = "MESSAGE_TEXT")
    private String text;

    @Getter
    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "MESSAGE_TYPE_ID", nullable = false)
    private MessageType messageType;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "MESSAGE_MESSAGE_TAGS",
            joinColumns = @JoinColumn(name = "MESSAGE_ID"),
            inverseJoinColumns = @JoinColumn(name = "MESSAGE_TAG_ID"))
    private Set<MessageTag> messageTags = new HashSet<MessageTag>();

    @Getter
    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

}
