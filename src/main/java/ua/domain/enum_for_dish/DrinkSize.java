package ua.domain.enum_for_dish;

public enum DrinkSize {

    SMALL (0.5),
    MEDIUM (1),
    LARGE (2);

    private double coof;

    DrinkSize(double coof) {
        this.coof = coof;
    }

    public double getCoof() {
        return coof;
    }
}
