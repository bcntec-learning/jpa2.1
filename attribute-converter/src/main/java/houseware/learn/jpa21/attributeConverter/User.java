package houseware.learn.jpa21.attributeConverter;

import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.awt.image.RenderedImage;

/**
 * @author fphilip@houseware.es
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
