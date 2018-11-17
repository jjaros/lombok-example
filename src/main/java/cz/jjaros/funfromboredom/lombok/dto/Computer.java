package cz.jjaros.funfromboredom.lombok.dto;

import lombok.Data;
import lombok.NonNull;

/**
 * @author <a href="mailto:jarosjan@yahoo.com">Jan Jaros</a>
 */
@Data(staticConstructor = "create")
public class Computer {

    private String operatingSystem;

    @NonNull
    private String hddSize;

    @NonNull
    private String ramSize;

}
