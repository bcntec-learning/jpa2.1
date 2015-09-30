package houseware.learn.jpa21.entityEventListener.cdi;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@EntityListeners(UserListener.class)
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;

}
