package it.ing.demo.junit.service;

import it.ing.demo.junit.model.Vehicle;

import java.util.List;

public interface VehicleRegistration {
    List<Vehicle> approveVehicles(List<Vehicle> vehicles);
}
