package tuling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author thirteenmj
 * Date: 2021/3/24 22:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple {
    private Integer id;
    private String color;
    private Integer weight;
    //产地
    private String origin;


}
