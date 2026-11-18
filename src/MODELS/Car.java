// METHOD OVERRIDING & POLYMORPHISM
package MODELS;

    // CONSTRUCTOR
public class Car {

    String brand;
    String vehicleType;

    public Car(String brand, String vehicleType) {
        this.brand = brand;
        this.vehicleType = vehicleType;
    }
        // GETTER/SETTER
    public int getRate() {
        return 30; // default rate for a plain Car
    }

    void drive() {
        System.out.println();
    }
}