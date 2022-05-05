package expense_system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

/**
 * The Expense class records the details of an expense that a User makes against the user's
 * Team budget.
 */
public class Expense {

    // FIELDS
    private double amount;
    private String description;
    private Date date;
    private SimpleDateFormat dateFormatter;
    private User user;

    // CONSTRUCTOR
    public Expense(double amount, String description, String dateString, User user) throws ParseException {
        this.amount = amount;
        this.description = description;
        // A simple formatter to convert string date into Date
        this.dateFormatter = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        this.date = this.dateFormatter.parse(dateString);
        this.user = user;
    }

    // METHODS

    // to string
    public String toString() {
        return this.amount + " (" + this.description + ")";
    }

    // getters
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

    // other methods

    // get date as string
    public String getDateAsString() {
        return this.dateFormatter.format(this.date);
    }
}
