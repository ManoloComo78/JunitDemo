package it.ing.demo.junit.enums;

public enum Labels {
    UNCATEGORIZED("I am a uncategorized vehicle with license plate %s"),
    CITYCAR("I am a small city car %s with engine %s with %s CV"),
    SUPERCAR("I am a fantastic supercar %s with engine %s with %s CV"),
    TRUCK("I am a working machine %s with engine %s with %s CV");
    private final String value;

    Labels(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
