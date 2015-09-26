package houseware.learn.jpa21.equalsHashcode;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
 */
@Data
@Entity
@Table(name="CHILDS")
public class ChildEH {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String name;

    @OneToMany
    ParentEH parent;


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
        if (!(obj instanceof ChildEH)) {
            return false;
        }
        ChildEH that = (ChildEH) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(getName(), that.getName());
        return eb.isEquals();
    }

}
