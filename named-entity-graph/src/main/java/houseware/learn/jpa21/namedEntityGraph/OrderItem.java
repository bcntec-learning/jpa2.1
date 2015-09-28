package houseware.learn.jpa21.namedEntityGraph;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long id = null;


    @Getter
    @Setter
    @Version
    @Column
    int version = 0;

    @Getter
    @Setter
    @Column
    int quantity;

    @Getter
    @Setter
    @ManyToOne
    Order order;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    Product product;
}

