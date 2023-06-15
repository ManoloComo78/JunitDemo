package it.ing.demo.junit.service;

import it.ing.demo.junit.enums.BrandName;
import it.ing.demo.junit.enums.VehicleEngine;
import it.ing.demo.junit.model.*;

import java.util.ArrayList;
import java.util.List;

public class VehicleRegistrationImpl implements VehicleRegistration {

    public static final String UNCATEGORIZED = "I am a uncategorized vehicle with license plate %s";
    public static final String CITYCAR = "I am a small city car %s with engine %s with %s CV";
    public static final String SUPERCAR = "I am a fantastic supercar %s with engine %s with %s CV";
    public static final String TRUCK = "I am a working machine %s with engine %s with %s CV";

    @Override
    public List<Vehicle> approveVehicles(List<Vehicle> vehicles) {
        //più 200 cv Supercar ma non diesel e una ferrari
        //più di 100 cv ma solo diesel
        //meno di 100 cv elettrica o hybrid ma non ferrari

        List<Vehicle> approvedVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if ((vehicle.getVehicleEngine() != null) && (vehicle.getBrandName() != null) && vehicle.getHorsePower() >= 200 && vehicle.getVehicleEngine() != VehicleEngine.ENGINE_DIESEL && vehicle.getBrandName().equals(BrandName.BRAND_FERRARI)) {
                SuperCar superCar = new SuperCar(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower(), vehicle.getLicensePlate());
                String label = String.format(SUPERCAR, superCar.getBrandName().getValue(), superCar.getVehicleEngine().getValue(), superCar.getHorsePower(), superCar.getHorsePower());
                superCar.setLabel(label);
                approvedVehicles.add(superCar);
            } else if ((vehicle.getVehicleEngine() != null) && (vehicle.getBrandName() != null) && vehicle.getHorsePower() >= 100 && vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_DIESEL)) {
                Truck truck = new Truck(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower(), vehicle.getLicensePlate());
                String label = String.format(TRUCK, truck.getBrandName().getValue(), truck.getVehicleEngine().getValue(), truck.getHorsePower(), truck.getHorsePower());
                truck.setLabel(label);
                approvedVehicles.add(truck);
            } else if ((vehicle.getVehicleEngine() != null) && (vehicle.getBrandName() != null) && vehicle.getHorsePower() < 100 && (vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_ELECTRIC) || vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_HYBRID)) && !vehicle.getBrandName().equals(BrandName.BRAND_FERRARI)) {
                CityCar cityCar = new CityCar(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower(), vehicle.getLicensePlate());
                String label = String.format(CITYCAR, cityCar.getBrandName().getValue(), cityCar.getVehicleEngine().getValue(), vehicle.getHorsePower());
                cityCar.setLabel(label);
                approvedVehicles.add(cityCar);
            } else {
                VehicleEngine vehicleEngine = vehicle.getVehicleEngine() != null ? vehicle.getVehicleEngine() : VehicleEngine.NO_ENGINE;
                BrandName brandName = vehicle.getBrandName() != null ? vehicle.getBrandName() : BrandName.NO_BRAND;
                NotCategorized notCategorized = new NotCategorized(vehicleEngine, brandName, vehicle.getHorsePower(), vehicle.getLicensePlate());
                String label = String.format(UNCATEGORIZED, vehicle.getLicensePlate());
                notCategorized.setLabel(label);
                approvedVehicles.add(notCategorized);
            }
        }
        return approvedVehicles;
    }
}
