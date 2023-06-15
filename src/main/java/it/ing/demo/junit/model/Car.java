package it.ing.demo.junit.model;

import it.ing.demo.junit.enums.BrandName;
import it.ing.demo.junit.enums.VehicleEngine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car extends Vehicle{

    public Car(VehicleEngine vehicleEngine, BrandName brandName, int horsePower) {
        super(vehicleEngine, brandName, horsePower);
    }
}
