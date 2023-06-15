package it.ing.demo.junit.enums;

public enum VehicleEngine {
    ENGINE_DIESEL("diesel"),
    ENGINE_ELECTRIC("electric"),
    ENGINE_HYBRID("hybrid");
    private final String value;

    VehicleEngine(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
