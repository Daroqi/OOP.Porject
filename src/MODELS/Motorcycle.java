package MODELS;

        // INHERITANCE
public class Motorcycle extends Car {

     // SUPER KEYWORD IN JAVA OVERRIDING
    public Motorcycle(String brand) {
        super(brand, "Motorcycle");
    }
        //METHOD OVERRIDING
    @Override
    public int getRate() {
        return 20;
    }
}