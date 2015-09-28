
package houseware.learn.jpa21.constructorMappingResult;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author fphilip@houseware.es
 */
@Data
@AllArgsConstructor
public class TotalBook {

    Long id;
    String firstName;
    String lastName;
    Long total;



}