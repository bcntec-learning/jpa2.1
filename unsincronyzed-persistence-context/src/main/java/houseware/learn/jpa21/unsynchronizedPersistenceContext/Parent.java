package houseware.learn.jpa21.unsynchronizedPersistenceContext;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
@ToString()
@NoArgsConstructor
public class Parent {


    @Id
    @Getter
    @Setter
    @Column
    String name;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL)
    Set<Child> childs = new HashSet<>();

    public Parent(String name) {
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
        if (!(obj instanceof Parent)) {
            return false;
        }
        Parent that = (Parent) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(getName(), that.getName());
        return eb.isEquals();
    }


    public Child addChild(String child) {
        return new Child(this, child);
    }

    public Parent removeChild(String child) {

        getChilds().removeIf(item -> {
            return item.getName().equals(child);

        });


        return this;
    }
}
