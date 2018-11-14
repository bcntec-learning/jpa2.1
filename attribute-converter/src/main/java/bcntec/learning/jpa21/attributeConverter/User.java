package bcntec.learning.jpa21.attributeConverter;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.awt.image.RenderedImage;

/**
 * @author francisco.philip@gmail.com
 */
@Data
@Entity
public class User {
    @Id
    @Column
    private String username;
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Convert(converter = ImageConverter.class)
    @Column(length = 16384)
    private RenderedImage icon;


   //see orm.xml
    @Column
    private String password;


    @Column(length = 1)
    private SexEnum sex;


}
