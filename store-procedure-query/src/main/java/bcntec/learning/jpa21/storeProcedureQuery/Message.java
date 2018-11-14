package bcntec.learning.jpa21.storeProcedureQuery;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author francisco.philip@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name = "MESSAGES")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MESSAGE_ID")
    private Long id;

    @Column(name = "MESSAGE_TEXT")
    private String text;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "MESSAGE_TYPE", nullable = false)
    private MessageTypeEnum messageType;


    @ManyToOne(optional = false)
    @JoinColumn(name = "SENDER_ID", nullable = false)
    private Sender sender;

}
