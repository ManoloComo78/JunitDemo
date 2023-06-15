package it.ing.demo.junit.model;

import it.ing.demo.junit.enums.BrandName;
import it.ing.demo.junit.enums.VehicleEngine;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private VehicleEngine vehicleEngine;
    private BrandName brandName;
    private int horsePower;
    private String licensePlate;
    private String label;

    public Vehicle(VehicleEngine vehicleEngine, BrandName brandName, int horsePower, String licensePlate) {
        this.vehicleEngine = vehicleEngine;
        this.brandName = brandName;
        this.horsePower = horsePower;
        this.licensePlate = licensePlate;
    }
}
