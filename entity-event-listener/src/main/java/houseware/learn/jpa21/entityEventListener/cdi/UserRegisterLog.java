package houseware.learn.jpa21.entityEventListener.cdi;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class UserRegisterLog implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    @ManyToOne
    private User user;

}
