package it.ing.demo.junit.service;

import it.ing.demo.junit.enums.BrandName;
import it.ing.demo.junit.enums.Labels;
import it.ing.demo.junit.enums.VehicleEngine;
import it.ing.demo.junit.model.*;
import it.ing.demo.junit.util.CarValidator;

import java.util.ArrayList;
import java.util.List;

public class CategorizationImpl implements Categorization {

    private final  CarValidator carValidator;

    public CategorizationImpl(CarValidator carValidator) {
        this.carValidator = carValidator;
    }

    @Override
    public List<Vehicle> categorize(List<Vehicle> vehicles) {
        List<Vehicle> checkedVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if ((vehicle.getVehicleEngine() != null) && (vehicle.getBrandName() != null) && vehicle.getHorsePower() >= 200 && vehicle.getVehicleEngine() != VehicleEngine.ENGINE_DIESEL && vehicle.getBrandName().equals(BrandName.BRAND_FERRARI)) {
                SuperCar superCar = new SuperCar(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower(), vehicle.getLicensePlate());
                String label = String.format(Labels.SUPERCAR.getValue(), superCar.getBrandName().getValue(), superCar.getVehicleEngine().getValue(), superCar.getHorsePower(), superCar.getHorsePower());
                superCar.setLabel(label);
                checkedVehicles.add(superCar);
            } else if ((vehicle.getVehicleEngine() != null) && (vehicle.getBrandName() != null) && vehicle.getHorsePower() >= 100 && vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_DIESEL)) {
                Truck truck = new Truck(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower(), vehicle.getLicensePlate());
                String label = String.format(Labels.TRUCK.getValue(), truck.getBrandName().getValue(), truck.getVehicleEngine().getValue(), truck.getHorsePower(), truck.getHorsePower());
                truck.setLabel(label);
                checkedVehicles.add(truck);
            } else if ((vehicle.getVehicleEngine() != null) && (vehicle.getBrandName() != null) && vehicle.getHorsePower() < 100 && (vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_ELECTRIC) || vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_HYBRID)) && !vehicle.getBrandName().equals(BrandName.BRAND_FERRARI)) {
                CityCar cityCar = new CityCar(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower(), vehicle.getLicensePlate());
                String label = String.format(Labels.CITYCAR.getValue(), cityCar.getBrandName().getValue(), cityCar.getVehicleEngine().getValue(), vehicle.getHorsePower());
                cityCar.setLabel(label);
                checkedVehicles.add(cityCar);
            } else {
                VehicleEngine vehicleEngine = vehicle.getVehicleEngine() != null ? vehicle.getVehicleEngine() : VehicleEngine.NO_ENGINE;
                BrandName brandName = vehicle.getBrandName() != null ? vehicle.getBrandName() : BrandName.NO_BRAND;
                NotCategorized notCategorized = new NotCategorized(vehicleEngine, brandName, vehicle.getHorsePower(), vehicle.getLicensePlate());
                String label = String.format(Labels.UNCATEGORIZED.getValue(), vehicle.getLicensePlate());
                notCategorized.setLabel(label);
                checkedVehicles.add(notCategorized);
            }
        }
        return checkedVehicles;
    }
}
