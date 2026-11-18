package FileHandling;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecordSystem {
    private static final String FILE_NAME = "parking_records.txt";

    // CREATE: makes the file if it doesn't exist yet
    public static void createFile() {
        File file = new File(FILE_NAME);
        try {
            if (file.createNewFile()) {
                System.out.println("Record file created: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("Could not create file: " + e.getMessage());
        }
    }

    // WRITE: adds one record to the end of the file
    public static void saveRecord(String owner, String plate, String brand,
                                  String vehicleType, int hours, int total) {
        createFile();
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) { // true = append
            writer.write(owner + "|" + plate + "|" + brand + "|"
                    + vehicleType + "|" + hours + "|" + total + "\n");
        } catch (IOException e) {
            System.out.println("Could not save record: " + e.getMessage());
        }
    }

    // READ: prints every saved record and the total earnings
    public static void showRecords() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No records yet.");
            return;
        }

        int earnings = 0;
        System.out.println("\n===== PARKING RECORDS =====");
        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split("\\|");
                if (parts.length == 6) {
                    System.out.println("Owner: " + parts[0]
                            + " | Plate: " + parts[1]
                            + " | " + parts[3] + " (" + parts[2] + ")"
                            + " | Hours: " + parts[4]
                            + " | Paid: " + parts[5]);
                    earnings += Integer.parseInt(parts[5]);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read records: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("A record has an invalid payment value.");
        }
        System.out.println("Total earnings: " + earnings);
    }

    // DELETE: removes the whole record file
    public static void deleteRecords() {
        File file = new File(FILE_NAME);
        if (file.delete()) {
            System.out.println("All records deleted.");
        } else {
            System.out.println("No record file to delete.");
        }
    }
    
}
