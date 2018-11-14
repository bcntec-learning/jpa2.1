package bcntec.learning.jpa21.entityEventListener.oldskool;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@EntityListeners(OldskoolListener.class)
public class Oldskool {
	@Id
	@GeneratedValue
	private long id;
	private String data;

}
