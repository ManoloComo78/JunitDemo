package it.ing.demo.junit.model;

import it.ing.demo.junit.enums.BrandName;
import it.ing.demo.junit.enums.VehicleEngine;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotCategorized extends Vehicle{


    public NotCategorized(VehicleEngine vehicleEngine, BrandName brandName, int horsePower, String licensePlate) {
        super(vehicleEngine, brandName, horsePower, licensePlate);
    }
}
