package tip;
import java.text.DecimalFormat;
/**
 * Takes care of the calculation
 */
public class BackEndCheck {
    private int people;
    private double amount;

    public BackEndCheck(int people, double amount) {
        this.people = people;
        this.amount = amount;
    }// end contructor

    public String returnValue(int people, double amount) {
        DecimalFormat format = new DecimalFormat("#0.00");
        double totalValue = 0;
        totalValue = amount / people;
        return format.format(totalValue);
    }
}// end class