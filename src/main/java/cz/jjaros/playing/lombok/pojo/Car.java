package cz.jjaros.playing.lombok.pojo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author <a href="mailto:jarosjan@yahoo.com">Jan Jaros</a>
 */
@Data
public abstract class Car {

    @NonNull
    @Setter(AccessLevel.NONE)
    private String carBrand;
    private String modelName;

    @NonNull
    @Setter(AccessLevel.NONE)
    private CarType type;

    public enum CarType {
        PASSENGER,
        VAN
    }
}
