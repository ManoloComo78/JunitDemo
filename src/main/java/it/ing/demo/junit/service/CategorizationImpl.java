package it.ing.demo.junit.service;

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
            checkedVehicles.add(categorize(vehicle));
        }
        return checkedVehicles;
    }

    @Override
    public Vehicle categorize(Vehicle vehicle) {
        if (carValidator.isSuperCar(vehicle)) {
            return new SuperCar(vehicle);
        }
        if (carValidator.isTruck(vehicle)) {
            return new Truck(vehicle);
        }
        if (carValidator.isCityCar(vehicle)) {
            return new CityCar(vehicle);
        }
        return new NotCategorized(vehicle);
    }
}
