package it.ing.demo.junit;

import it.ing.demo.junit.enums.BrandName;
import it.ing.demo.junit.enums.VehicleEngine;
import it.ing.demo.junit.model.NotCategorized;
import it.ing.demo.junit.model.Vehicle;
import it.ing.demo.junit.service.Categorization;
import it.ing.demo.junit.service.CategorizationImpl;
import it.ing.demo.junit.util.CarValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"it.ing.demo.junit"})
@Slf4j
public class Application {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_HYBRID, BrandName.BRAND_FIAT, 150, "AA 001 AA"));
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_HYBRID, BrandName.BRAND_TOYOTA, 50, "AA 002 AA"));
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_ELECTRIC, BrandName.BRAND_FIAT, 90, "AA 003 AA"));
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_HYBRID, BrandName.BRAND_FERRARI, 1000, "AA 004 AA"));
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_DIESEL, BrandName.BRAND_FIAT, 500, "AA 005 AA"));
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_DIESEL, BrandName.BRAND_TOYOTA, 250, "AA 006 AA"));
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_DIESEL, null, 250, "AA 007 AA"));
        vehicles.add(new Vehicle(null, null, 0, "AA 008 AA"));

        Categorization categorization = new CategorizationImpl(new CarValidator());
        List<Vehicle> checkedVehicles = categorization.categorize(vehicles);

        for (Vehicle vehicle : checkedVehicles) {
            log.info(vehicle.getLabel());
        }
    }
}
