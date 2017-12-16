package cz.jjaros.playing.lombok.pojo;

import lombok.Data;
import lombok.NonNull;

@Data(staticConstructor = "create")
public class Computer {

    private String operatingSystem;

    @NonNull
    private String hddSize;

    @NonNull
    private String ramSize;

}
