package bcntec.learning.jpa21.equalsHashcode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
@Table(name = "PARENTS")
@ToString()
public class Parent {
    @Getter
    @Setter
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Getter
    @Setter
    @Column
    String name;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL)
    Set<Child> childs = new HashSet<>();

}
