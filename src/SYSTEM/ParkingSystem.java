package SYSTEM;

        // STATIC METHOD & STATIC KEYWORD
public class ParkingSystem {

    public static int Parking_payment(int day1, int day2) {
        return day1 + day2;
    }

    public static int Time(int T1) {
        return T1;
    }

    public String Cars;
    public String PlateNumbers;
    // int Payment_PerHour;
    // int Time_Consumed;

    // Original constructor - default car/plate info
    public ParkingSystem() {
        Cars  = ""  ;
        PlateNumbers= "";
    }

    // Overloaded constructor - merged from Rules_Regulations
    // public ParkingSystem(int paymentPerHour, int timeConsumed) {
    //     this.Payment_PerHour = paymentPerHour;
    //     this.Time_Consumed = timeConsumed;
    // }

    //void Rules() {
        //System.out.println("Welcome!, your payment per hour is: " + Payment_PerHour
               // + " Your time consumed: " + Time_Consumed);
    //}
}