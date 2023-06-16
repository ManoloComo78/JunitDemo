package it.ing.demo.junit.model;

import it.ing.demo.junit.enums.Labels;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityCar extends Vehicle {

    public CityCar(Vehicle vehicle) {
        super(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower(), vehicle.getLicensePlate());
    }

    @Override
    public String toString() {
        return String.format(Labels.CITYCAR.getValue(), getBrandName().getValue(), getVehicleEngine().getValue(), getHorsePower());
    }
}
