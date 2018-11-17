package cz.jjaros.funfromboredom.lombok.dto;

/**
 * @author <a href="mailto:jarosjan@yahoo.com">Jan Jaros</a>
 */
public class PassengerCar extends Car {

    public PassengerCar(String brandName) {
        super(brandName, CarType.PASSENGER);
    }
}
