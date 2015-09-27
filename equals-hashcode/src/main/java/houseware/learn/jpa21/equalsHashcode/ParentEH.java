package houseware.learn.jpa21.equalsHashcode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Table(name = "EH_PARENTS")
@ToString()
public class ParentEH {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Getter
    @Setter
    @Column
    String name;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL)
    Set<ChildEH> childs = new HashSet<>();

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
