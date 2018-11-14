package bcntec.learning.jpa21.constructorMappingResult;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
/**
 * @author francisco.philip@gmail.com
 */

@Entity
public class Book {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Getter
    @Setter
    @Version
    @Column(name = "version")
    private int version;

    @Getter
    @Setter
    @Column
    private String title;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (title != null && !title.trim().isEmpty()) {
            result += "title: " + title;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book other = (Book) obj;
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

}