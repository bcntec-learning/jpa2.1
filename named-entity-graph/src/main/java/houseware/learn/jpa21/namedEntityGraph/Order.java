package houseware.learn.jpa21.namedEntityGraph;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
@NamedEntityGraphs({
        @NamedEntityGraph(name = "graph.Order.items",
                attributeNodes = @NamedAttributeNode(value = "items", subgraph = "items")),
        @NamedEntityGraph(name = "graph.Order.items.products",
                attributeNodes = @NamedAttributeNode(value = "items", subgraph = "items"),
                subgraphs = @NamedSubgraph(name = "items", attributeNodes = @NamedAttributeNode("product")))

})

public class Order {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    Long id = null;

    @Getter
    @Setter
    @Version
    @Column
    int version = 0;

    @Getter
    @Setter
    @Column
    String orderNumber;

    @Getter
    @Setter
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    Set<OrderItem> items = new HashSet<>();
}