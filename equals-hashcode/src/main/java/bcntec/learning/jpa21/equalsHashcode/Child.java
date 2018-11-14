package bcntec.learning.jpa21.equalsHashcode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Table(name = "CHILDS")
@NoArgsConstructor
public class Child {

    @Getter
    @Setter
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Getter
    @Setter
    @Column(unique = true)
    String name;

    @Getter
    @Setter
    @ManyToOne
    Parent parent;


    public Child(String name, Parent parent) {
        this.name = name;
        this.parent = parent;
    }


    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent.getId() +
                '}';
    }
}
