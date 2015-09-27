package houseware.learn.jpa21.criteriaApiBulkOperations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @Column
    private String id;
    @Column
    private String name;


}
