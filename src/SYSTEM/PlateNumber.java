package SYSTEM;

        // CONSTRUCTOR 
public class PlateNumber {
    String Owner;
    String PlateNumbers;

    public PlateNumber(String owner, String PlateNumbers) {
        this.Owner = owner;
        this.PlateNumbers = PlateNumbers;
    }

    public void User() {
        System.out.println("Welcome! " + Owner + " Your Platenumber registered: " + PlateNumbers + " At RON Parking company!");
    }
}