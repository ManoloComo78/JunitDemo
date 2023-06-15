package it.ing.demo.junit;

import it.ing.demo.junit.enums.BrandName;
import it.ing.demo.junit.enums.VehicleEngine;
import it.ing.demo.junit.model.Car;
import it.ing.demo.junit.model.Vehicle;
import it.ing.demo.junit.service.VehicleRegistration;
import it.ing.demo.junit.service.VehicleRegistrationImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"it.ing.demo.junit"})
@Slf4j
public class Application {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car(VehicleEngine.ENGINE_HYBRID, BrandName.BRAND_FIAT, 150));
        vehicles.add(new Car(VehicleEngine.ENGINE_HYBRID, BrandName.BRAND_TOYOTA, 50));
        vehicles.add(new Car(VehicleEngine.ENGINE_ELECTRIC, BrandName.BRAND_FIAT, 90));
        vehicles.add(new Car(VehicleEngine.ENGINE_HYBRID, BrandName.BRAND_FERRARI, 1000));
        vehicles.add(new Car(VehicleEngine.ENGINE_DIESEL, BrandName.BRAND_FIAT, 500));
        vehicles.add(new Car(VehicleEngine.ENGINE_DIESEL, BrandName.BRAND_TOYOTA, 250));
        vehicles.add(new Car(VehicleEngine.ENGINE_DIESEL, null, 250));

        VehicleRegistration vehicleRegistration = new VehicleRegistrationImpl();
        List<Vehicle> approveVehicles = vehicleRegistration.approveVehicles(vehicles);

        for (Vehicle vehicle : approveVehicles) {
            log.info(vehicle.getLabel());
        }
    }
}
