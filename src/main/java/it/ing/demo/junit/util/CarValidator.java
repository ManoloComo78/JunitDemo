package it.ing.demo.junit.util;

import it.ing.demo.junit.enums.BrandName;
import it.ing.demo.junit.enums.VehicleEngine;
import it.ing.demo.junit.model.Vehicle;

public class CarValidator {

    public boolean isSuperCar(Vehicle vehicle) {
        return isCategorizable(vehicle) && vehicle.getHorsePower() >= 200 && vehicle.getVehicleEngine() != VehicleEngine.ENGINE_DIESEL && vehicle.getBrandName().equals(BrandName.BRAND_FERRARI);
    }

    public boolean isTruck(Vehicle vehicle) {
        return isCategorizable(vehicle) && vehicle.getHorsePower() >= 100 && vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_DIESEL);
    }

    public boolean isCityCar(Vehicle vehicle) {
        return isCategorizable(vehicle) && vehicle.getHorsePower() < 100 && (vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_ELECTRIC) || vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_HYBRID)) && !vehicle.getBrandName().equals(BrandName.BRAND_FERRARI);
    }

    public boolean isCategorizable(Vehicle vehicle) {
        return (vehicle.getVehicleEngine() != null) && (vehicle.getBrandName() != null);
    }


}
