package houseware.learn.jpa21.criteriaApiBulkOperations;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Table(name = "PRICES")
@IdClass(PricePK.class)
public class Price {
    @Getter
    @Setter
    @Id
    @ManyToOne
    private Product product;

    @Getter
    @Setter
    @Id
    @ManyToOne
    private Country country;

    @Getter
    @Setter
    @Column
    private BigDecimal value;

}
