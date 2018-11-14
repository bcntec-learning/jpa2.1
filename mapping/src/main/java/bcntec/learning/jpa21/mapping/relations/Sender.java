package bcntec.learning.jpa21.mapping.relations;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Table(name = "SENDERS")
public class Sender {
    @Getter
    @Setter
    @Id
    @GeneratedValue
    @Column(name = "SENDER_ID")
    Long id;

    @Getter
    @Setter
    @Column(name = "USERNAME")
    String userName;


}
