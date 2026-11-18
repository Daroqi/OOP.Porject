package Calculations;

public class AdditionClass {

    int TotalAmount;
    int RatePerHour;
    int HourUsed;

    public int GetTotalRate(int RatePerHour, int HourUsed) {
        TotalAmount = RatePerHour * HourUsed;
        return TotalAmount;
    }
}