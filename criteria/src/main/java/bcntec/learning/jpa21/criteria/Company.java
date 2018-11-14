package bcntec.learning.jpa21.criteria;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author francisco.philip@gmail.com
 */

@Entity
@Data
//@ToString(exclude = {"employees","country"})
public class Company {
    @Id
    private String id;
    @Column
    private String name;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
