package it.ing.demo.junit.enums;

public enum VehicleEngine {
    ENGINE_DIESEL("diesel"),
    ENGINE_ELECTRIC("electric"),
    ENGINE_HYBRID("hybrid"),
    NO_ENGINE("no engine");
    private final String value;

    VehicleEngine(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
