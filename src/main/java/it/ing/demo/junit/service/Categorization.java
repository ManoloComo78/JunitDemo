package it.ing.demo.junit.service;

import it.ing.demo.junit.model.Vehicle;

import java.util.List;

public interface Categorization {
    List<Vehicle> categorize(List<Vehicle> vehicles);

    Vehicle categorize(Vehicle vehicle);
}
