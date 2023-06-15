package it.ing.demo.junit.service;

import it.ing.demo.junit.enums.BrandName;
import it.ing.demo.junit.enums.VehicleEngine;
import it.ing.demo.junit.model.Car;
import it.ing.demo.junit.model.SuperCar;
import it.ing.demo.junit.model.Truck;
import it.ing.demo.junit.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRegistrationImpl implements VehicleRegistration {

    public static final String CAR = "I am a normal car %s with engine %s";
    public static final String CITYCAR = "I am a small city car %s with engine %s";
    public static final String SUPERCAR = "I am a fantastic supercar %s with engine %s";
    public static final String TRUCK = "I am a working machine %s with engine %s";

    @Override
    public List<Vehicle> approveVehicles(List<Vehicle> vehicles) {
        //più 200 cv Supercar ma non diesel e una ferrari
        //più di 100 cv ma solo diesel
        //meno di 100 cv elettrica o hybrid ma non ferrari

        List<Vehicle> approvedVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getHorsePower() >= 200 && vehicle.getVehicleEngine() != VehicleEngine.ENGINE_DIESEL && vehicle.getBrandName().equals(BrandName.BRAND_FERRARI)) {
                SuperCar superCar = new SuperCar(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower());
                String label = String.format(SUPERCAR, superCar.getBrandName().getValue(), superCar.getVehicleEngine().getValue());
                superCar.setLabel(label);
                approvedVehicles.add(superCar);
            } else if (vehicle.getHorsePower() >= 100 && vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_DIESEL)) {
                Truck truck = new Truck(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower());
                String label = String.format(TRUCK, truck.getBrandName().getValue(), truck.getVehicleEngine().getValue());
                truck.setLabel(label);
                approvedVehicles.add(truck);
            } else if (vehicle.getHorsePower() < 100 && (vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_ELECTRIC) || vehicle.getVehicleEngine().equals(VehicleEngine.ENGINE_HYBRID)) && !vehicle.getBrandName().equals(BrandName.BRAND_FERRARI)) {
                Truck truck = new Truck(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower());
                String label = String.format(CITYCAR, truck.getBrandName().getValue(), truck.getVehicleEngine().getValue());
                truck.setLabel(label);
                approvedVehicles.add(truck);
            } else {
                Car car = new Car(vehicle.getVehicleEngine(), vehicle.getBrandName(), vehicle.getHorsePower());
                String label = String.format(CAR, car.getBrandName().getValue(), car.getVehicleEngine().getValue());
                car.setLabel(label);
                approvedVehicles.add(car);
            }
        }
        return approvedVehicles;
    }
}
