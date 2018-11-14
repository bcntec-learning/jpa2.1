package bcntec.learning.jpa21.mapping.collections;

import javax.persistence.Embeddable;

@Embeddable
public class Phone {
    private String type;
    private String areaCode;
    private String number;
}