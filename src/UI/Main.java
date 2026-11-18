package UI;

import FileHandling.RecordSystem;
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

        // TIME INPUT (HH:MM)
        System.out.print("Enter the time you parked (HH:MM, 24-hr, e.g. 12:00): ");
        String timeIn = input.nextLine();

        System.out.print("Enter the time you left (HH:MM, 24-hr, e.g. 14:30): ");
        String timeOut = input.nextLine();

        int minutes = toMinutes(timeOut) - toMinutes(timeIn);
        if (minutes < 0) minutes += 24 * 60;          // handles parking past midnight
        int hours = (int) Math.ceil(minutes / 60.0);  // partial hours count as a full hour

        AdditionClass calc = new AdditionClass();
        int total = calc.GetTotalRate(rate, hours);

       // RECEIPT
        System.out.println("\n==========================================");
        System.out.println("            RON PARKING COMPANY");
        System.out.println("                 RECEIPT");
        System.out.println("==========================================");
        System.out.printf("%-20s %s%n", "Customer:", ownerName);
        System.out.printf("%-20s %s%n", "Plate Number:", plateNum);
        System.out.printf("%-20s %s%n", "Vehicle Brand:", brand);
        System.out.printf("%-20s %s%n", "Vehicle Type:", vehicleType);
        System.out.println("------------------------------------------");
        System.out.printf("%-20s %s%n", "Time In:", timeIn);
        System.out.printf("%-20s %s%n", "Time Out:", timeOut);
        System.out.printf("%-20s %d min%n", "Duration:", minutes);
        System.out.printf("%-20s %d hr(s)%n", "Billed Hours:", hours);
        System.out.println("------------------------------------------");
        System.out.printf("%-20s %d per hour%n", "Rate:", rate);
        System.out.printf("%-20s %d x %d%n", "Computation:", rate, hours);
        System.out.println("==========================================");
        System.out.printf("%-20s %d%n", "TOTAL PAYMENT:", total);
        System.out.println("==========================================");
        System.out.println("     Thank you for parking with us!");

        // FILE HANDLING
        RecordSystem.saveRecord(ownerName, plateNum, brand, vehicleType, hours, total);

        System.out.print("\nView all saved records? (yes/no): ");
        String choice = input.nextLine();
        if (choice.trim().equalsIgnoreCase("yes")) {
            RecordSystem.showRecords();
        }

        input.close();
    }

    // Converts "HH:MM" into total minutes
    public static int toMinutes(String time) {
        String[] parts = time.trim().split(":");
        int h = Integer.parseInt(parts[0]);
        int m = parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
        return h * 60 + m;
    }
}