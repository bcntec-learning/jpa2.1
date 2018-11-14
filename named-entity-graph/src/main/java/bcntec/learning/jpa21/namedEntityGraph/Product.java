package bcntec.learning.jpa21.namedEntityGraph;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long id = null;

    @Getter
    @Setter
    @Version
    int version = 0;

    @Getter
    @Setter
    @Column
    String name;


    @Getter
    @Setter
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    Set<OrderItem> orderItems = new HashSet<>();
}