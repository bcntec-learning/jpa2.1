package houseware.learn.jpa21.mapping.collections;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @Column(name = "ID", length = 22)
    private String id;

    @AttributeOverride(
            name = "areaCode", column = @Column(name = "area")
    )
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "EMPlOYEE_PHONES",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    private List<Phone> phones;

    @ElementCollection
    @CollectionTable(
            name = "EMPlOYEE_ROLES",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID")
    )
    @Column(name = "ROLE", length = 1)
    @Enumerated(EnumType.STRING)
    private List<Role> roles;


    @ElementCollection
    @CollectionTable(name="EMPlOYEE_CARDS")
    @MapKeyColumn(name="CARD_TYPE")
    @Column(name="CARD")
    private Map<String, String> cards;

    @ElementCollection
    @CollectionTable(name="EMPlOYEE_PHONES2")
    @MapKeyColumn(name="PHONE_TYPE")
    private Map<String, Phone> phones2;

}
