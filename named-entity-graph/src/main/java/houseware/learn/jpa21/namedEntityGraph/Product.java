package houseware.learn.jpa21.namedEntityGraph;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
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
    @Column(name = "version")
    int version = 0;

    @Getter
    @Setter
    @Column
    String name;
}