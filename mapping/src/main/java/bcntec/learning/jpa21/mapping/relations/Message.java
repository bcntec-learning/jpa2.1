package bcntec.learning.jpa21.mapping.relations;

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
    @JoinColumn(name = "SENDER_ID", nullable = false)
    private Sender sender;

}
