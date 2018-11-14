package bcntec.learning.jpa21.queries;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Table(name = "MESSAGES")
@NamedQueries({
        @NamedQuery(
                name = "Message.listTextAndMemberOf",
                query = "select object(m) from Message m where m.text like :message and :tag member of m.messageTags"
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Message_Native.listTextAndMemberOf",
                query = "select m.* from  MESSAGES m  where (m.MESSAGE_TEXT like :message) and ( :tag in ( select t.MESSAGE_TAG_ID from MESSAGE_MESSAGE_TAGS t where m.MESSAGE_ID=t.MESSAGE_ID))",
                resultClass = Message.class)
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
