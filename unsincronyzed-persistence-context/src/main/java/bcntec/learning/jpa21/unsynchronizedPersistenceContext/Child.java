package bcntec.learning.jpa21.unsynchronizedPersistenceContext;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author francisco.philip@gmail.com
 */
@Entity
public class Child {

    @Getter
    @Setter
    @Id
    @Column
    String name;

    @Getter
    @Setter
    @ManyToOne
    Parent parent;

    public Child() {
    }

    public Child(Parent parent, String name) {
        this.parent = parent;
        this.name = name;
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
        if (!(obj instanceof Child)) {
            return false;
        }
        Child that = (Child) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(getName(), that.getName());
        return eb.isEquals();
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", parent=" + parent.getName() +
                '}';
    }
}
