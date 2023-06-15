package it.ing.demo.junit.service;

import com.flextrade.jfixture.JFixture;
import it.ing.demo.junit.enums.BrandName;
import it.ing.demo.junit.enums.VehicleEngine;
import it.ing.demo.junit.model.*;
import it.ing.demo.junit.util.CarValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.flextrade.jfixture.FixtureAnnotations.initFixtures;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CategorizationImplTest {

    @Mock
    private CarValidator carValidator;
    @InjectMocks
    private CategorizationImpl categorization;

    private List<Vehicle> vehicles;

    @BeforeEach
    public void setUp() {
        vehicles = new ArrayList<>();
    }

    @Test
    void testCategorize_Success() {
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_HYBRID, BrandName.BRAND_FIAT, 150, "AA 001 AA"));
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_HYBRID, BrandName.BRAND_TOYOTA, 50, "AA 002 AA"));
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_ELECTRIC, BrandName.BRAND_FIAT, 90, "AA 003 AA"));
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_HYBRID, BrandName.BRAND_FERRARI, 1000, "AA 004 AA"));
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_DIESEL, BrandName.BRAND_FIAT, 500, "AA 005 AA"));
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_DIESEL, BrandName.BRAND_TOYOTA, 250, "AA 006 AA"));
        vehicles.add(new Vehicle(VehicleEngine.ENGINE_DIESEL, null, 250, "AA 007 AA"));
        vehicles.add(new Vehicle(null, null, 0, "AA 008 AA"));

        List<Vehicle> checkedVehicles = categorization.categorize(vehicles);

        assertEquals(8, checkedVehicles.size());
        assertEquals(NotCategorized.class, checkedVehicles.get(0).getClass());
        assertEquals(CityCar.class, checkedVehicles.get(1).getClass());
        assertEquals(CityCar.class, checkedVehicles.get(2).getClass());
        assertEquals(SuperCar.class, checkedVehicles.get(3).getClass());
        assertEquals(Truck.class, checkedVehicles.get(4).getClass());
        assertEquals(Truck.class, checkedVehicles.get(5).getClass());
        assertEquals(NotCategorized.class, checkedVehicles.get(6).getClass());
        assertEquals(NotCategorized.class, checkedVehicles.get(7).getClass());
    }

}