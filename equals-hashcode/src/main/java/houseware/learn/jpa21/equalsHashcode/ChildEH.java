package houseware.learn.jpa21.equalsHashcode;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * @author fphilip@houseware.es
 */
@Entity
@Table(name = "uqal")
public class ChildEH {

    @Getter
    @Setter
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Getter
    @Setter
    @Column(unique = true)
    String name;

    @Getter
    @Setter
    @ManyToOne
    ParentEH parent;


    public ChildEH(String name, ParentEH parent) {
        this.name = name;
        this.parent = parent;
    }

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

    @Override
    public String toString() {
        return "ChildEH{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent.getId() +
                '}';
    }
}
