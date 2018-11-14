package bcntec.learning.jpa21.criteria;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author francisco.philip@gmail.com
 */
@Setter
@Getter
@ToString
@Entity
public class Employee {
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private int age;
    @ManyToOne
    private Company company;
}
