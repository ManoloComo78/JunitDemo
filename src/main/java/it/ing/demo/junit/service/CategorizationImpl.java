package it.ing.demo.junit.service;

import it.ing.demo.junit.enums.BrandName;
import it.ing.demo.junit.enums.Labels;
import it.ing.demo.junit.enums.VehicleEngine;
import it.ing.demo.junit.model.*;

import java.util.ArrayList;
import java.util.List;

public class CategorizationImpl implements Categorization {

    @Override
    public List<Vehicle> categorize(List<Vehicle> vehicles) {
        //più 200 cv Supercar ma non diesel e una ferrari
        //più di 100 cv ma solo diesel
        //meno di 100 cv elettrica o hybrid ma non ferrari

        List<Vehicle> approvedVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if ((vehicle.getVehicleEngine() != null) && (vehicle.getBrandName() != null) && vehicle.getHorsePower() >= 200 && vehicle.getVehicleEngine() != VehicleEngine.ENGINE_DIESEL && vehicle.getBrandName().equals(BrandName.BRAND_FERRARI)) {
                SuperCar superCar = new SuperCar(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower(), vehicle.getLicensePlate());
                String label = String.format(Labels.SUPERCAR.getValue(), superCar.getBrandName().getValue(), superCar.getVehicleEngine().getValue(), superCar.getHorsePower(), superCar.getHorsePower());
                superCar.setLabel(label);
                approvedVehicles.add(superCar);
            } else if ((vehicle.getVehicleEngine() != null) && (vehicle.getBrandName() != null) && vehicle.getHorsePower() >= 100 && vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_DIESEL)) {
                Truck truck = new Truck(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower(), vehicle.getLicensePlate());
                String label = String.format(Labels.TRUCK.getValue(), truck.getBrandName().getValue(), truck.getVehicleEngine().getValue(), truck.getHorsePower(), truck.getHorsePower());
                truck.setLabel(label);
                approvedVehicles.add(truck);
            } else if ((vehicle.getVehicleEngine() != null) && (vehicle.getBrandName() != null) && vehicle.getHorsePower() < 100 && (vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_ELECTRIC) || vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_HYBRID)) && !vehicle.getBrandName().equals(BrandName.BRAND_FERRARI)) {
                CityCar cityCar = new CityCar(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower(), vehicle.getLicensePlate());
                String label = String.format(Labels.CITYCAR.getValue(), cityCar.getBrandName().getValue(), cityCar.getVehicleEngine().getValue(), vehicle.getHorsePower());
                cityCar.setLabel(label);
                approvedVehicles.add(cityCar);
            } else {
                VehicleEngine vehicleEngine = vehicle.getVehicleEngine() != null ? vehicle.getVehicleEngine() : VehicleEngine.NO_ENGINE;
                BrandName brandName = vehicle.getBrandName() != null ? vehicle.getBrandName() : BrandName.NO_BRAND;
                NotCategorized notCategorized = new NotCategorized(vehicleEngine, brandName, vehicle.getHorsePower(), vehicle.getLicensePlate());
                String label = String.format(Labels.UNCATEGORIZED.getValue(), vehicle.getLicensePlate());
                notCategorized.setLabel(label);
                approvedVehicles.add(notCategorized);
            }
        }
        return approvedVehicles;
    }
}
