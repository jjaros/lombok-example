package cz.jjaros.playing.lombok.dto;

public class PassengerCar extends Car {

    public PassengerCar(String brandName) {
        super(brandName, CarType.PASSENGER);
    }
}
