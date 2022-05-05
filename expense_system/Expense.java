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

    // fields
    private double amount;
    private String description;
    private Date date;
    private User user;
    public static List<String> amountRow = new ArrayList<String>();
    public static List<String> descriptionRow = new ArrayList<String>();
    public static List<String> dateRow = new ArrayList<String>();
    public static List<String> userRow = new ArrayList<String>();
    public static List<Expense> expenses = new ArrayList<Expense>();

    // constructor
    public Expense(double amount, String description, String dateString, String user) throws ParseException {
        this.amount = amount;
        this.description = description;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        this.date = formatter.parse(dateString);
        this.user = new User(user, User.password, "Team1");
    }

    // methods
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

    public static void scanExpensesCSV() throws NumberFormatException, ParseException {
        String filepath = "Expenses.csv";
        BufferedReader reader = null;
        String line = "";
        

        try {
            reader = new BufferedReader(new FileReader(filepath));
            while((line = reader.readLine()) != null) {
                //System.out.println(line);
                String[] row = line.split(",");
                amountRow.add(row[0]);
                descriptionRow.add(row[1]);
                dateRow.add(row[2]);
                userRow.add(row[3]);
                
                for(String index : row) {
                    //System.out.printf("%-10s", index);
                    //System.out.println(row[0]);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // add users to list while constructing
        
        for (int i = 2; i < amountRow.size(); i++) {

            Expense newExpense = new Expense(Double.valueOf(amountRow.get(i)), descriptionRow.get(i), dateRow.get(i), userRow.get(i));
            expenses.add(newExpense);
        }
        
    }
}
