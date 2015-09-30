package houseware.learn.jpa21.mapping.collections;

import javax.persistence.*;
import java.util.List;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @Column(name = "ID",length = 22)
    private String  id;
    @ElementCollection
    @CollectionTable(
            name = "PHONE",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    private List<Phone> phones;

    @ElementCollection
    @CollectionTable(
            name = "ROLES",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID")
    )
    @Column(name = "ROLE") @Enumerated(EnumType.STRING)
    private List<Role> roles;

}
