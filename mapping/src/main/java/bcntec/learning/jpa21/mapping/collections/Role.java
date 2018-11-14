package bcntec.learning.jpa21.mapping.collections;

/**
 * @author francisco.philip@gmail.com
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
