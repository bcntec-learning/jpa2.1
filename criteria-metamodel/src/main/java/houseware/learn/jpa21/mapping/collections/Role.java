package houseware.learn.jpa21.mapping.collections;

/**
 * @author fphilip@houseware.es
 */
public enum Role {
    ADMIN("A"), USER("U");

    private String u;
    Role(String u) {
        this.u = u;
    }

    @Override
    public String toString() {
       return u;
    }
}
