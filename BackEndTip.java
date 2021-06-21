package tip;
import java.text.DecimalFormat;
/**
 * Returns total tip
 */
public class BackEndTip
{
    private double amount;
    private double percent;
    public BackEndTip(double amount, double percent)
    {
        this.amount = amount;
        this.percent = percent;
    }
    public String returnTip(double amount, double percent)
    {
        DecimalFormat format = new DecimalFormat("#0.00");
        double percentage = percent/100;
        double total = percentage * amount;
        return format.format(total);
    }
}
