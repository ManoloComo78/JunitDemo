package it.ing.demo.junit.model;

import it.ing.demo.junit.enums.Labels;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuperCar extends Vehicle {


    public SuperCar(Vehicle vehicle) {
        super(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower(), vehicle.getLicensePlate());
    }

    @Override
    public String toString() {
        return String.format(Labels.SUPERCAR.getValue(), getBrandName().getValue(), getVehicleEngine().getValue(), getHorsePower());
    }
}
