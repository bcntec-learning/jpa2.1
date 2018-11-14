
package bcntec.learning.jpa21.constructorMappingResult;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author francisco.philip@gmail.com
 */
@Data
@AllArgsConstructor
public class TotalBook {

    Long id;
    String firstName;
    String lastName;
    Long total;



}