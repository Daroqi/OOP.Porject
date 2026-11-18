package UI;

import MODELS.Car;
import MODELS.Motorcycle;
import MODELS.Truck;
import SYSTEM.PlateNumber;
import java.util.Scanner;
import Calculations.AdditionClass;

// SCANNER (INPUT/OUTPUT HANDLING)
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String ownerName = input.nextLine();

        System.out.print("Enter your car brand: ");
        String brand = input.nextLine();

        System.out.print("Enter vehicle type (Car / Motorcycle / Truck): ");
        String vehicleType = input.nextLine();

        System.out.print("Enter your plate number: ");
        String plateNum = input.nextLine();

        // SWITCH STATEMENT
        Car myCar;
        switch (vehicleType.trim().toLowerCase()) {
            case "motorcycle":
                myCar = new Motorcycle(brand);
                break;
            case "truck":
                myCar = new Truck(brand);
                break;
            default:
                myCar = new Car(brand, "Car");
                break;
        }

        // GETTER/SETTER
        int rate = myCar.getRate();

        PlateNumber plateInfo = new PlateNumber(ownerName, plateNum);

        System.out.print("Enter the time you parked (24-hr format): ");
        int timeIn = input.nextInt();

        System.out.print("Enter the time you left (24-hr format): ");
        int timeOut = input.nextInt();
        int hours = timeOut - timeIn;

        AdditionClass calc = new AdditionClass();
        int total = calc.GetTotalRate(rate, hours);

        // SIMPLE PRINTING
        System.out.println("\nWelcome: " + ownerName + "!");
        System.out.println("Time Used: " + hours + " Hrs");
        System.out.println("Model: " + brand + "\n" + " Plate Num: " + plateNum);
        System.out.println("Your Total Payment is: " + total);

        input.close();
    }
}