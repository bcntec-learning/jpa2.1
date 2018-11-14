package bcntec.learning.jpa21.criteriaApiBulkOperations;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author francisco.philip@gmail.com
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
