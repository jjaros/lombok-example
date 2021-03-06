package cz.jjaros.funfromboredom.lombok.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:jarosjan@yahoo.com">Jan Jaros</a>
 */
@Getter
@RequiredArgsConstructor // creates exactly one constructor Company(@NonNull String, int)
@ToString(includeFieldNames = false, exclude = "cars")
public abstract class Company {

    @NonNull
    private String name;

    @NonNull
    private int employeesCount;

    @Setter(AccessLevel.PROTECTED)
    private boolean taxPayer;

    @Getter(lazy = true)
    @Setter(AccessLevel.NONE)
    private final List<Car> cars = new ArrayList<>();

    public void addCar(@NonNull Car newCar) {
        getCars().add(newCar);
    }
}
