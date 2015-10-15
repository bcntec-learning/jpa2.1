package houseware.learn.jpa21.storeProcedureQuery;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
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
