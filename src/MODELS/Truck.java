package MODELS;

public class Truck extends Car {

    public Truck(String brand) {
        super(brand, "Truck");
    }

    @Override
    public int getRate() {
        return 50;
    }
}