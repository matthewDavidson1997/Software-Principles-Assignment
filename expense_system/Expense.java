package expense_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Expense {

    private double amount;
    private String description;
    private Date date;
    private User user;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);

    public Expense(double amount, String description, String dateString, User user) throws ParseException {
        this.amount = amount;
        this.description = description;
        this.date = formatter.parse(dateString);
        this.user = user;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getDate() {
        return this.date;
    }

    public User getUser() {
        return this.user;
    }

    public String toString() {
        return this.amount + " (" + this.description + ")";
    }
}
