package bcntec.learning.jpa21.jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Table(name = "MESSAGE_TYPES")
public class MessageType {

    @Getter
    @Setter
    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_TYPE_ID")
    private Long id;

    @Getter @Setter
    @Column(name = "MESSAGE_TYPE")
    private String type;





}
