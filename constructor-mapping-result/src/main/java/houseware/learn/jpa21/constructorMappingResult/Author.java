package houseware.learn.jpa21.constructorMappingResult;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author fphilip@houseware.es
 */
@Entity
public class Author implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;


    @Getter
    @Setter
    @Version
    @Column(name = "version")
    int version;

    @Getter
    @Setter
    @Column
    String firstName;

    @Getter
    @Setter
    @Column
    String lastName;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Author)) {
            return false;
        }
        Author other = (Author) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (firstName != null && !firstName.trim().isEmpty()) {
            result += "firstName: " + firstName;
        }
        if (lastName != null && !lastName.trim().isEmpty()) {
            result += ", lastName: " + lastName;
        }
        return result;
    }
}