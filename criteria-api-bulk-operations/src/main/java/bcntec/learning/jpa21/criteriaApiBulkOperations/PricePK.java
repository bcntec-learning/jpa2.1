package bcntec.learning.jpa21.criteriaApiBulkOperations;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @author francisco.philip@gmail.com
 */

public class PricePK implements Serializable {

    @Getter
    @Setter
    private Product product;


    @Getter
    @Setter
    private Country country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PricePK pricePK = (PricePK) o;

        return new EqualsBuilder()
                .append(getProduct(), pricePK.getProduct())
                .append(getCountry(), pricePK.getCountry())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getProduct())
                .append(getCountry())
                .toHashCode();
    }
}
