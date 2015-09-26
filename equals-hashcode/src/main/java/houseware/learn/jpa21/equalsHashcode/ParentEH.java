package houseware.learn.jpa21.equalsHashcode;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Set;

/**
 * @author fphilip@houseware.es
 */
@Data
@Entity
@Table(name="PARENTS")
public class ParentEH {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String name;

    @ManyToOne
    Set<Child> childs;

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(getName());
        return hcb.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParentEH)) {
            return false;
        }
        ParentEH that = (ParentEH) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(getName(), that.getName());
        return eb.isEquals();
    }


}
