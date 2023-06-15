package it.ing.demo.junit.enums;

public enum BrandName {
    BRAND_TOYOTA("Toyota"),
    BRAND_FERRARI("Ferrari"),
    BRAND_FIAT("Fiat"),
    NO_BRAND("No brand");
    private final String value;

    BrandName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
