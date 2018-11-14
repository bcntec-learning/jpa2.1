package bcntec.learning.jpa21.storeProcedureQuery;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author francisco.philip@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name = "SENDERS")
public class Sender {
    @Id
    @Column(name = "USERNAME")
    String userName;


}
